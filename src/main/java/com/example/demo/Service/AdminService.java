package com.example.demo.Service;


import com.example.demo.Model.AdminModel;
import com.example.demo.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("null")
public class AdminService {


    @Autowired
    AdminRepository adminRepository;

    //Listar

    public String getAllAdmin() {
        String output = "";
        for (AdminModel am : adminRepository.findAll()){
            output += "id: "+am.getId()+"\n";
            output += "nombre: "+am.getNombre()+"\n";
            output += "rol: "+am.getRol()+"\n";
            output += "correo: "+am.getCorreo()+"\n";
            output += "contraseña: "+am.getContraseña()+"\n";

        }
        if (output.isEmpty()){
            return "Agregar Administrador!";
        }
        else {
            return output;
        }
    }

    //Listar por id
    public String getAdminById(int id) {
        String output = "";
        if (adminRepository.existsById(id)){
            AdminModel am  = adminRepository.findById(id).get();
            output += "id: "+am.getId()+"\n";
            output += "nombre: "+am.getNombre()+"\n";
            output += "rol: "+am.getRol()+"\n";
            output += "correo: "+am.getCorreo()+"\n";
            output += "contraseña: "+am.getContraseña()+"\n";

            return output;
        }
        else {
            return "Administrador no encontrado";
        }
    }

    //Agregar
    public String addAdmin(AdminModel adminModel){
        adminRepository.save(adminModel);
        return "admin agregegado";
    }

    //Eliminar
    public String deleteAdmin(int id){
        if (adminRepository.existsById(id)){
            adminRepository.deleteById(id);
            return "Admin eliminado";
        }else{
            return "Admin no encontrado";
        }
    }

    //Actualizar/Update
    public String updateAdmin(int id, AdminModel nuevosDatosAdmin){
        if (adminRepository.existsById(id)){

            AdminModel adminExistente = adminRepository.findById(id).get();


            adminExistente.setNombre(nuevosDatosAdmin.getNombre());
            adminExistente.setRol(nuevosDatosAdmin.getRol());
            adminExistente.setCorreo(nuevosDatosAdmin.getCorreo());
            adminExistente.setContraseña(nuevosDatosAdmin.getContraseña());


            adminRepository.save(adminExistente);

            return "Administrador actualizado exitosamente";
        }
        else {
            return "Administrador no encontrado con ID: " + id;
        }
    }


}
