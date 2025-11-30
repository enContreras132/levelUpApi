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
        for (MouseModel mm : mouseRepository.findAll()){
            output += "id: "+mm.getId()+"\n";
            output += "nombre: "+mm.getNombre()+"\n";
            output += "categoria: "+mm.getCategoria();
            output += "marca: "+mm.getMarca()+"\n";
            output += "precio: "+mm.getPrecio()+"\n";
            output += "stock: "+mm.getStock()+"\n";
            output += "inalambrico: "+mm.getInalambrico()+"\n";
            output += "color: "+mm.getColor()+"\n";
            output += "botonesCant: "+mm.getBotonesCant()+"\n";
            output += "dpiMin: "+mm.getDpiMin()+"\n";
            output += "dpiMax: "+mm.getDpiMax()+"\n";
            output += "descripcion: "+mm.getDescripcion()+"\n";
            output += "url imagen: "+mm.getUrlImagen()+"\n";


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
            MouseModel mm = mouseRepository.findById(id).get();
            output += "id: "+mm.getId()+"\n";
            output += "nombre: "+mm.getNombre()+"\n";
            output += "categoria: "+mm.getCategoria()+"\n";
            output += "marca: "+mm.getMarca()+"\n";
            output += "precio: "+mm.getPrecio()+"\n";
            output += "stock: "+mm.getStock()+"\n";
            output += "inalambrico: "+mm.getInalambrico()+"\n";
            output += "color: "+mm.getColor()+"\n";
            output += "botonesCant: "+mm.getBotonesCant()+"\n";
            output += "dpiMin: "+mm.getDpiMin()+"\n";
            output += "dpiMax: "+mm.getDpiMax()+"\n";
            output += "descripcion: "+mm.getDescripcion()+"\n";
            output += "url imagen: "+mm.getUrlImagen()+"\n";

            return output;
        }
        else {
            return "Mouse no encontrado";
        }
    }

    public String addMouse(MouseModel mouseModel){
        mouseRepository.save(mouseModel);
        return "Mouse agregegado";
    }

    public String deleteMouse(int id){
        if (mouseRepository.existsById(id)){
            mouseRepository.deleteById(id);
            return "Mouse eliminado";
        }else{
            return "Mouse no encontrado";
        }
    }

    public String updateMouse(int id, MouseModel nuevosDatosMouse){
        if (mouseRepository.existsById(id)){

            MouseModel mouseExistente = mouseRepository.findById(id).get();

            mouseExistente.setNombre(nuevosDatosMouse.getNombre());
            mouseExistente.setCategoria(nuevosDatosMouse.getCategoria());
            mouseExistente.setMarca(nuevosDatosMouse.getMarca());
            mouseExistente.setPrecio(nuevosDatosMouse.getPrecio());
            mouseExistente.setStock(nuevosDatosMouse.getStock());
            mouseExistente.setInalambrico(nuevosDatosMouse.getInalambrico());
            mouseExistente.setColor(nuevosDatosMouse.getColor());
            mouseExistente.setBotonesCant(nuevosDatosMouse.getBotonesCant());
            mouseExistente.setDpiMin(nuevosDatosMouse.getDpiMin());
            mouseExistente.setDpiMax(nuevosDatosMouse.getDpiMax());
            mouseExistente.setDescripcion(nuevosDatosMouse.getDescripcion());




            mouseRepository.save(mouseExistente);

            return "Mouse actualizado exitosamente";
        }
        else {
            return "Mouse no encontrado con ID: " + id;
        }
    }
}
