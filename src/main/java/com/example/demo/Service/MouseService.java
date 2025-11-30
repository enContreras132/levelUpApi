package com.example.demo.Service;

import com.example.demo.Model.MouseModel;
import com.example.demo.Repository.MouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class MouseService {

    @Autowired
    MouseRepository mouseRepository;

    //Listar
    public List<MouseModel> getAllMouse() {
        return mouseRepository.findAll();
    }

    public Optional<MouseModel> getMouseById(int id) {
        return mouseRepository.findById(id);
    }

    public MouseModel addMouse(MouseModel mouseModel){
        return mouseRepository.save(mouseModel);
    }

    public boolean deleteMouse(int id){
        if (mouseRepository.existsById(id)){
            mouseRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public Optional<MouseModel> updateMouse(int id, MouseModel nuevosDatosMouse){
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
            mouseExistente.setUrlImagen(nuevosDatosMouse.getUrlImagen());

            return Optional.of(mouseRepository.save(mouseExistente));
        }
        else {
            return Optional.empty();
        }
    }
}
