package com.example.demo.Service;


import com.example.demo.Model.ClienteModel;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@SuppressWarnings("null")
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    //Listar
    public String getAllCliente() {
        String output = "";
        for (ClienteModel cm : clienteRepository.findAll()){
            output += "id: "+cm.getId()+"\n";
            output += "nombre: "+cm.getNombre()+"\n";
            output += "rol: "+cm.getRol()+"\n";
            output += "correo: "+cm.getCorreo()+"\n";
            output += "contraseña: "+cm.getContraseña()+"\n";
        }
        if (output.isEmpty()){
            return "Agregar cliente!";
        }
        else {
            return output;
        }
    }

    //Listar por ID
    public String getClienteById(int id) {
        String output = "";
        if (clienteRepository.existsById(id)){
            ClienteModel cm  = clienteRepository.findById(id).get();
            output += "id: "+cm.getId()+"\n";
            output += "nombre: "+cm.getNombre()+"\n";
            output += "rol: "+cm.getRol()+"\n";
            output += "correo: "+cm.getCorreo()+"\n";
            output += "contraseña: "+cm.getContraseña()+"\n";
            return output;
        }
        else {
            return "Cliente no encontrado";
        }
    }

    //Agregar
    public String addCliente(ClienteModel clienteModel){
        clienteRepository.save(clienteModel);
        return "Audifono agregegado";
    }

    //Delete
    public String deleteCliente(int id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return "Cliente eliminado";
        }else{
            return "Cliente no encontrado";
        }
    }

    //Update
    public String updateCliente(int id, ClienteModel nuevosDatosCliente){
        if (clienteRepository.existsById(id)){

            ClienteModel clienteExistente = clienteRepository.findById(id).get();

            clienteExistente.setNombre(nuevosDatosCliente.getNombre());
            clienteExistente.setRol(nuevosDatosCliente.getRol());
            clienteExistente.setCorreo(nuevosDatosCliente.getCorreo());
            clienteExistente.setContraseña(nuevosDatosCliente.getContraseña());

            clienteRepository.save(clienteExistente);

            return "Cliente actualizado exitosamente";
        }
        else {
            return "Cliente no encontrado con ID: " + id;
        }
    }

}
