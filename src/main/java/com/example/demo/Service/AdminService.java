package com.example.demo.Service;


import com.example.demo.Model.AdminModel;
import com.example.demo.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class AdminService {


    @Autowired
    AdminRepository adminRepository;

    //Listar
    public List<AdminModel> getAllAdmin() {
        return adminRepository.findAll();
    }

    //Listar por id
    public Optional<AdminModel> getAdminById(int id) {
        return adminRepository.findById(id);
    }

    //Agregar
    public AdminModel addAdmin(AdminModel adminModel){
        return adminRepository.save(adminModel);
    }

    //Eliminar
    public boolean deleteAdmin(int id){
        if (adminRepository.existsById(id)){
            adminRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Actualizar/Update
    public Optional<AdminModel> updateAdmin(int id, AdminModel nuevosDatosAdmin){
        if (adminRepository.existsById(id)){

            AdminModel adminExistente = adminRepository.findById(id).get();


            adminExistente.setNombre(nuevosDatosAdmin.getNombre());
            adminExistente.setRol(nuevosDatosAdmin.getRol());
            adminExistente.setCorreo(nuevosDatosAdmin.getCorreo());
            adminExistente.setContraseña(nuevosDatosAdmin.getContraseña());

            return Optional.of(adminRepository.save(adminExistente));
        }
        else {
            return Optional.empty();
        }
    }


}
