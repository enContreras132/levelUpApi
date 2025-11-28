package com.example.demo.Controller;

import com.example.demo.Model.AudifonoModel;
import com.example.demo.Service.AudifonoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/audifono")
public class AudifonoController {

    @Autowired
    AudifonoService AudifonoService;

    @GetMapping
    public String getAllAudifono(){
        return AudifonoService.getAllAudifono();
    }

    @GetMapping("/{id}")
    public String getAudifonoById(@PathVariable int id){
        return AudifonoService.getAudifonoById(id);
    }

    @PostMapping
    public  String addAudifono(@RequestBody AudifonoModel audifonoModel){
        return AudifonoService.addAudifono(audifonoModel);
    }

    @DeleteMapping("/{id}")
    public String deleteAudifono(@PathVariable int id){
        return AudifonoService.deleteAudifono(id); // Llama al servicio con el ID
    }

    @PutMapping("/{id}")
    public String updateAudifono(@PathVariable int id, @RequestBody AudifonoModel audifono){
        return AudifonoService.updateAudifono(id, audifono);
    }
}
