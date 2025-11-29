package com.example.demo.Controller;


import com.example.demo.Model.ClienteModel;
import com.example.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    ClienteService ClienteService;

    @GetMapping
    public String getAllCliente(){
        return ClienteService.getAllCliente();
    }

    @GetMapping("/{id}")
    public String getClientebyId(@PathVariable int id){
        return ClienteService.getClienteById(id);
    }

    @PostMapping
    public  String addCliente(@RequestBody ClienteModel clienteModel){
        return ClienteService.addCliente(clienteModel);
    }

    @DeleteMapping("/{id}")
    public String deleteCliente(@PathVariable int id){
        return ClienteService.deleteCliente(id); // Llama al servicio con el ID
    }

    @PutMapping("/{id}")
    public String updateCliente(@PathVariable int id, @RequestBody ClienteModel cliente){
        return ClienteService.updateCliente(id, cliente);
    }

}
