package com.example.demo.Service;

import com.example.demo.Model.TecladoModel;
import com.example.demo.Repository.TecladoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@SuppressWarnings("null")
@Service

public class TecladoService {

    @Autowired
    TecladoRepository TecladoRepository;

    //Listar
    public List<TecladoModel> getAllTeclado() {
        return TecladoRepository.findAll();
    }

    //Listar por ID
    public Optional<TecladoModel> getTecladoById(int id) {
        return TecladoRepository.findById(id);
    }

    //Agregar
    public TecladoModel addTeclado(TecladoModel tecladoModel){
        return TecladoRepository.save(tecladoModel);
    }

    //Delete
    public boolean deleteTeclado(int id){
        if (TecladoRepository.existsById(id)){
            TecladoRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }


    //Update
    public Optional<TecladoModel> updateTeclado(int id, TecladoModel nuevosDatosTeclado){
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

            return Optional.of(TecladoRepository.save(tecladoExistente));
        }
        else {
            return Optional.empty();
        }
    }

}
