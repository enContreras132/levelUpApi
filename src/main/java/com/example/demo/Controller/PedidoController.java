package com.example.demo.Controller;

import com.example.demo.Model.Pedido;
import com.example.demo.Service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @GetMapping
    public List<Pedido> getAllPedidos(){
        return pedidoService.getAllPedidos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable int id){
        Optional<Pedido> pedido = pedidoService.getPedidoById(id);
        return pedido.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido addPedido(@RequestBody Pedido pedido){
        return pedidoService.addPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable int id){
        boolean deleted = pedidoService.deletePedido(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable int id, @RequestBody Pedido pedido){
        Optional<Pedido> updated = pedidoService.updatePedido(id, pedido);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
