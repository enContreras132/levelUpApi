package com.example.demo.Service;


import com.example.demo.Model.ClienteModel;
import com.example.demo.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;


    //Listar
    public List<ClienteModel> getAllCliente() {
        return clienteRepository.findAll();
    }

    //Listar por ID
    public Optional<ClienteModel> getClienteById(int id) {
        return clienteRepository.findById(id);
    }

    //Agregar
    public ClienteModel addCliente(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    //Delete
    public boolean deleteCliente(int id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Update
    public Optional<ClienteModel> updateCliente(int id, ClienteModel nuevosDatosCliente){
        if (clienteRepository.existsById(id)){

            ClienteModel clienteExistente = clienteRepository.findById(id).get();

            clienteExistente.setNombre(nuevosDatosCliente.getNombre());
            clienteExistente.setRol(nuevosDatosCliente.getRol());
            clienteExistente.setCorreo(nuevosDatosCliente.getCorreo());
            clienteExistente.setContraseña(nuevosDatosCliente.getContraseña());

            return Optional.of(clienteRepository.save(clienteExistente));
        }
        else {
            return Optional.empty();
        }
    }

}
