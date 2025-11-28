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
            output += "id: "+cm.getClass()+"\n";
            output+="nombre:"+cm.getClass()+"\n";
            //**terminar en la casa porque me pique**


        }
        if (output.isEmpty()){
            return "Agregar mouses!";
        }
        else {
            return output;
        }
    }

}
