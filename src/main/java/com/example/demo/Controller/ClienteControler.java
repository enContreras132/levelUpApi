package com.example.demo.Controller;


import com.example.demo.Model.ClienteModel;
import com.example.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteControler {


    @Autowired
    ClienteService clienteService;

    @GetMapping
    public String getAllCliente(){
        return clienteService.getAllCliente();
    }

    @GetMapping("/{id}")
    public String getClienteById(@PathVariable int id){
        return clienteService.getClienteById(id);
    }

    @PostMapping
    public  String addcliente(@RequestBody ClienteModel mouseModel){
        return clienteService.addcliente(mouseModel);
    }

    @DeleteMapping("/{id}")
    public String deleteCliete(@PathVariable int id){
        return clienteService.deleteCliete(id); // Llama al servicio con el ID
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable int id, @RequestBody ClienteModel cliente){
        return clienteService.updateCliente(id, cliente);
    }
}
