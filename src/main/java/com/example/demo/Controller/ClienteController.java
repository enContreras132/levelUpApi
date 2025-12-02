package com.example.demo.Controller;


import com.example.demo.Model.ClienteModel;
import com.example.demo.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})

public class ClienteController {


    @Autowired
    ClienteService ClienteService;

    @GetMapping
    public List<ClienteModel> getAllCliente(){
        return ClienteService.getAllCliente();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> getClientebyId(@PathVariable int id){
        Optional<ClienteModel> cliente = ClienteService.getClienteById(id);
        return cliente.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClienteModel addCliente(@RequestBody ClienteModel clienteModel){
        return ClienteService.addCliente(clienteModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable int id){
        boolean deleted = ClienteService.deleteCliente(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteModel> updateCliente(@PathVariable int id, @RequestBody ClienteModel cliente){
        Optional<ClienteModel> updated = ClienteService.updateCliente(id, cliente);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

}
