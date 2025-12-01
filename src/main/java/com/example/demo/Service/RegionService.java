package com.example.demo.Service;

import com.example.demo.Model.Region;
import com.example.demo.Repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class RegionService {

    @Autowired
    RegionRepository regionRepository;

    //Listar
    public List<Region> getAllRegion() {
        return regionRepository.findAll();
    }

    //Listar por ID
    public Optional<Region> getRegionById(int id) {
        return regionRepository.findById(id);
    }

    //Agregar
    public Region addRegion(Region regionModel){
        return regionRepository.save(regionModel);
    }

    //Delete
    public boolean deleteRegion(int id){
        if (regionRepository.existsById(id)){
            regionRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Update
    public Optional<Region> updateRegion(int id, Region nuevosDatosRegion){
        if (regionRepository.existsById(id)){

            Region regionExistente = regionRepository.findById(id).get();

            regionExistente.setNombre(nuevosDatosRegion.getNombre());

            return Optional.of(regionRepository.save(regionExistente));
        }
        else {
            return Optional.empty();
        }
    }
}
