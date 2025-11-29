package com.example.demo.Service;

import com.example.demo.Model.TecladoModel;
import com.example.demo.Repository.TecladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@SuppressWarnings("null")
@Service

public class TecladoService {

    @Autowired
    TecladoRepository TecladoRepository;

    //Listar
    public String getAllTeclado() {
        String output = "";
        for (TecladoModel tm : TecladoRepository.findAll()){
            output += "id: "+tm.getId()+"\n";
            output += "nombre: "+tm.getNombre()+"\n";
            output += "categoria: "+tm.getCategoria();
            output += "marca: "+tm.getMarca()+"\n";
            output += "precio: "+tm.getPrecio()+"\n";
            output += "stock: "+tm.getStock()+"\n";
            output += "color: "+tm.getColor()+"\n";
            output += "inalambrico: "+tm.getInalambrico()+"\n";
            output += "dimension: "+tm.getDimension()+"\n";
            output += "tipo: "+tm.getTipo()+"\n";
            output += "switches: "+tm.getSwitches()+"\n";
            output += "descripcion: "+tm.getDescripcion()+"\n";
        }
        if (output.isEmpty()){
            return "Agregar Teclado!";
        }
        else {
            return output;
        }
    }

    //Listar por ID
    public String getTecladoById(int id) {
        String output = "";
        if(TecladoRepository.existsById(id)){
            TecladoModel tm = TecladoRepository.findById(id).get();
            output += "id: "+tm.getId()+"\n";
            output += "nombre: "+tm.getNombre()+"\n";
            output += "categoria: "+tm.getCategoria();
            output += "marca: "+tm.getMarca()+"\n";
            output += "precio: "+tm.getPrecio()+"\n";
            output += "stock: "+tm.getStock()+"\n";
            output += "color: "+tm.getColor()+"\n";
            output += "inalambrico: "+tm.getInalambrico()+"\n";
            output += "dimension: "+tm.getDimension()+"\n";
            output += "tipo: "+tm.getTipo()+"\n";
            output += "switches: "+tm.getSwitches()+"\n";
            output += "descripcion: "+tm.getDescripcion()+"\n";
            return output;
        }
        else {
            return "Teclado no encontrado";
        }
    }

    //Agregar
    public String addTeclado(TecladoModel tecladoModel){
        TecladoRepository.save(tecladoModel);
        return "Teclado agregegado";
    }

    //Delete
    public String deleteTeclado(int id){
        if (TecladoRepository.existsById(id)){
            TecladoRepository.deleteById(id);
            return "Teclado eliminado";
        }else{
            return "Teclado no encontrado";
        }
    }


    //Update
    public String updateTeclado(int id, TecladoModel nuevosDatosTeclado){
        if (TecladoRepository.existsById(id)){

            TecladoModel tecladoExistente = TecladoRepository.findById(id).get();

            tecladoExistente.setNombre(nuevosDatosTeclado.getNombre());
            tecladoExistente.setCategoria(nuevosDatosTeclado.getCategoria());
            tecladoExistente.setMarca(nuevosDatosTeclado.getMarca());
            tecladoExistente.setPrecio(nuevosDatosTeclado.getPrecio());
            tecladoExistente.setStock(nuevosDatosTeclado.getStock());
            tecladoExistente.setInalambrico(nuevosDatosTeclado.getInalambrico());
            tecladoExistente.setColor(nuevosDatosTeclado.getColor());
            tecladoExistente.setDimension(nuevosDatosTeclado.getDimension());
            tecladoExistente.setTipo(nuevosDatosTeclado.getTipo());
            tecladoExistente.setSwitches(nuevosDatosTeclado.getSwitches());
            tecladoExistente.setDescripcion(nuevosDatosTeclado.getDescripcion());
            tecladoExistente.setUrlImagen(nuevosDatosTeclado.getUrlImagen());


            TecladoRepository.save(tecladoExistente);

            return "Notebook actualizado exitosamente";
        }
        else {
            return "Notebook no encontrado con ID: " + id;
        }
    }

}
