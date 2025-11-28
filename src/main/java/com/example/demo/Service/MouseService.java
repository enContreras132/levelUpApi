package com.example.demo.Service;

import com.example.demo.Model.MouseModel;
import com.example.demo.Repository.MouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("null")
public class MouseService {

    @Autowired
    MouseRepository mouseRepository;

    //Listar

    public String getAllMouse() {
        String output = "";
        for (MouseModel ad : mouseRepository.findAll()){
            output += "id: "+ad.getId()+"\n";
            output += "nombre: "+ad.getNombre()+"\n";
            output += "categoria: "+ad.getCategoria();
            output += "marca: "+ad.getMarca()+"\n";
            output += "precio: "+ad.getPrecio()+"\n";
            output += "stock: "+ad.getStock()+"\n";
            output += "inalambrico: "+ad.getInalambrico()+"\n";
            output += "color: "+ad.getColor()+"\n";
            output += "botonesCant: "+ad.getBotonesCant()+"\n";
            output += "dpiMin: "+ad.getDpiMin()+"\n";
            output += "dpiMax: "+ad.getDpiMax()+"\n";
            output += "descripcion: "+ad.getDescripcion()+"\n";

        }
        if (output.isEmpty()){
            return "Agregar mouses!";
        }
        else {
            return output;
        }
    }

    public String getMouseById(int id) {
        String output = "";
        if (mouseRepository.existsById(id)){
            MouseModel ad = mouseRepository.findById(id).get();
            output += "id: "+ad.getId()+"\n";
            output += "nombre: "+ad.getNombre()+"\n";
            output += "categoria: "+ad.getCategoria();
            output += "marca: "+ad.getMarca()+"\n";
            output += "precio: "+ad.getPrecio()+"\n";
            output += "stock: "+ad.getStock()+"\n";
            output += "inalambrico: "+ad.getInalambrico()+"\n";
            output += "color: "+ad.getColor()+"\n";
            output += "botonesCant: "+ad.getBotonesCant()+"\n";
            output += "dpiMin: "+ad.getDpiMin()+"\n";
            output += "dpiMax: "+ad.getDpiMax()+"\n";
            output += "descripcion: "+ad.getDescripcion()+"\n";
            return output;
        }
        else {
            return "Mouse no encontrado";
        }
    }

    public String addMouse(MouseModel mouseModel){
        mouseRepository.save(mouseModel);
        return "mouse agregegado";
    }

    public String deleteMouse(int id){
        if (mouseRepository.existsById(id)){
            mouseRepository.deleteById(id);
            return "mouse eliminado";
        }else{
            return "mouse no encontrado";
        }
    }

    public String updateMouse(int id, MouseModel nuevosDatosMouse){
        if (mouseRepository.existsById(id)){

            MouseModel mouseExistente = mouseRepository.findById(id).get();

            mouseExistente.setNombre(nuevosDatosMouse.getNombre());
            mouseExistente.setCategoria(nuevosDatosMouse.getCategoria());
            mouseExistente.setMarca(nuevosDatosMouse.getMarca());
            mouseExistente.setPrecio(nuevosDatosMouse.getPrecio());

            mouseRepository.save(mouseExistente);

            return "Mouse actualizado exitosamente";
        }
        else {
            return "Mouse no encontrado con ID: " + id;
        }
    }
}
