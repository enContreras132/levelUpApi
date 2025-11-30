package com.example.demo.Controller;

import com.example.demo.Model.TecladoModel;
import com.example.demo.Service.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/teclado")
public class TecladoController {

    @Autowired
    TecladoService TecladoService;

    @GetMapping
    public List<TecladoModel> getAllTeclado(){
        return TecladoService.getAllTeclado();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecladoModel> getTecladobyId(@PathVariable int id){
        Optional<TecladoModel> teclado = TecladoService.getTecladoById(id);
        return teclado.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TecladoModel addTeclado(@RequestBody TecladoModel tecladoModel){
        return TecladoService.addTeclado(tecladoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeclado(@PathVariable int id){
        boolean deleted = TecladoService.deleteTeclado(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TecladoModel> updateTeclado(@PathVariable int id, @RequestBody TecladoModel teclado){
        Optional<TecladoModel> updated = TecladoService.updateTeclado(id, teclado);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }






}
