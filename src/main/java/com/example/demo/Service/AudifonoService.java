package com.example.demo.Service;

import com.example.demo.Model.AudifonoModel;
import com.example.demo.Repository.AudifonoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AudifonoService {

    @Autowired
    AudifonoRepository audifonoRepository;

    //Listar
    public String getAllAudifono() {
        String output = "";
        for (AudifonoModel am : audifonoRepository.findAll()){
            output += "id: "+am.getId()+"\n";
            output += "nombre: "+am.getNombre()+"\n";
            output += "categoria: "+am.getCategoria();
            output += "marca: "+am.getMarca()+"\n";
            output += "precio: "+am.getPrecio()+"\n";
            output += "stock: "+am.getStock()+"\n";
            output += "inalambrico: "+am.getInalambrico()+"\n";
            output += "color: "+am.getColor()+"\n";

        }
        if (output.isEmpty()){
            return "Agregar audifono!";
        }
        else {
            return output;
        }
    }
    //Listar por ID
    public String getAudifonoById(int id) {
        String output = "";
        if (audifonoRepository.existsById(id)){
            AudifonoModel ad = audifonoRepository.findById(id).get();
            output += "id: "+ad.getId()+"\n";
            output += "nombre: "+ad.getNombre()+"\n";
            output += "categoria: "+ad.getCategoria();
            output += "marca: "+ad.getMarca()+"\n";
            output += "precio: "+ad.getPrecio()+"\n";
            output += "stock: "+ad.getStock()+"\n";
            output += "inalambrico: "+ad.getInalambrico()+"\n";
            output += "color: "+ad.getColor()+"\n";
            output += "botonesCant: "+ad.getBotonesCant()+"\n";
            output += "descripcion: "+ad.getDescripcion()+"\n";
            return output;
        }
        else {
            return "Audifono no encontrado";
        }
    }
    //Agregar
    public String addAudifono(AudifonoModel audifonoModel){
        audifonoRepository.save(audifonoModel);
        return "Audifono agregegado";
    }

    //Delete
    public String deleteAudifono(int id){
        if (audifonoRepository.existsById(id)){
            audifonoRepository.deleteById(id);
            return "Audifono eliminado";
        }else{
            return "Audifono no encontrado";
        }
    }

    //Update
    public String updateAudifono(int id, AudifonoModel nuevosDatosAudifonos){
        if (audifonoRepository.existsById(id)){

            AudifonoModel audifonoExistente = audifonoRepository.findById(id).get();

            audifonoExistente.setNombre(nuevosDatosAudifonos.getNombre());
            audifonoExistente.setCategoria(nuevosDatosAudifonos.getCategoria());
            audifonoExistente.setMarca(nuevosDatosAudifonos.getMarca());
            audifonoExistente.setPrecio(nuevosDatosAudifonos.getPrecio());

            audifonoRepository.save(audifonoExistente);

            return "Audifono actualizado exitosamente";
        }
        else {
            return "Audifono no encontrado con ID: " + id;
        }
    }




}
