package com.example.demo.Service;

import com.example.demo.Model.AudifonoModel;
import com.example.demo.Repository.AudifonoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class AudifonoService {

    @Autowired
    AudifonoRepository audifonoRepository;

    public List<AudifonoModel> getAllAudifono() {
        return audifonoRepository.findAll();
    }
    
    //Listar por ID
    public Optional<AudifonoModel> getAudifonoById(int id) {
        return audifonoRepository.findById(id);
    }
    //Agregar
    public AudifonoModel addAudifono(AudifonoModel audifonoModel){
        return audifonoRepository.save(audifonoModel);
    }

    //Delete
    public boolean deleteAudifono(int id){
        if (audifonoRepository.existsById(id)){
            audifonoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Update
    public Optional<AudifonoModel> updateAudifono(int id, AudifonoModel nuevosDatosAudifonos){
        if (audifonoRepository.existsById(id)){

            AudifonoModel audifonoExistente = audifonoRepository.findById(id).get();

            audifonoExistente.setNombre(nuevosDatosAudifonos.getNombre());
            audifonoExistente.setCategoria(nuevosDatosAudifonos.getCategoria());
            audifonoExistente.setMarca(nuevosDatosAudifonos.getMarca());
            audifonoExistente.setPrecio(nuevosDatosAudifonos.getPrecio());
            audifonoExistente.setStock(nuevosDatosAudifonos.getStock());
            audifonoExistente.setInalambrico(nuevosDatosAudifonos.getInalambrico());
            audifonoExistente.setColor(nuevosDatosAudifonos.getColor());
            audifonoExistente.setBotonesCant(nuevosDatosAudifonos.getBotonesCant());
            audifonoExistente.setDescripcion(nuevosDatosAudifonos.getDescripcion());
            audifonoExistente.setUrlImagen(nuevosDatosAudifonos.getUrlImagen());

            return Optional.of(audifonoRepository.save(audifonoExistente));
        }
        else {
            return Optional.empty();
        }
    }




}
