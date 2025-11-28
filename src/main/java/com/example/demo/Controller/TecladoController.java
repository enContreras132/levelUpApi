package com.example.demo.Controller;

import com.example.demo.Model.TecladoModel;
import com.example.demo.Service.TecladoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teclado")
public class TecladoController {

    @Autowired
    TecladoService TecladoService;

    @GetMapping
    public String getAllTeclado(){
        return TecladoService.getAllTeclado();
    }

    @GetMapping("/{id}")
    public String getTecladobyId(@PathVariable int id){
        return TecladoService.getTecladoById(id);
    }

    @PostMapping
    public  String addTeclado(@RequestBody TecladoModel tecladoModel){
        return TecladoService.addTeclado(tecladoModel);
    }

    @DeleteMapping("/{id}")
    public String deleteTeclado(@PathVariable int id){
        return TecladoService.deleteTeclado(id); // Llama al servicio con el ID
    }
    @PutMapping("/{id}")
    public String updateTeclado(@PathVariable int id, @RequestBody TecladoModel teclado){
        return TecladoService.updateTeclado(id, teclado);
    }






}
