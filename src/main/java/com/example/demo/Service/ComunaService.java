package com.example.demo.Service;

import com.example.demo.Model.ComunaModel;
import com.example.demo.Repository.ComunaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class ComunaService {

    @Autowired
    ComunaRepository comunaRepository;

    //Listar
    public List<ComunaModel> getAllComuna() {
        return comunaRepository.findAll();
    }

    //Listar por ID
    public Optional<ComunaModel> getComunaById(int id) {
        return comunaRepository.findById(id);
    }

    //Agregar
    public ComunaModel addComuna(ComunaModel comunaModel){
        return comunaRepository.save(comunaModel);
    }

    //Delete
    public boolean deleteComuna(int id){
        if (comunaRepository.existsById(id)){
            comunaRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Update
    public Optional<ComunaModel> updateComuna(int id, ComunaModel nuevosDatosComuna){
        if (comunaRepository.existsById(id)){

            ComunaModel comunaExistente = comunaRepository.findById(id).get();

            comunaExistente.setNombre(nuevosDatosComuna.getNombre());
            comunaExistente.setRegion(nuevosDatosComuna.getRegion());

            return Optional.of(comunaRepository.save(comunaExistente));
        }else{
            return Optional.empty();
        }
    }
}
