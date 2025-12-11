package com.example.demo.Controller;

import com.example.demo.Model.ComunaModel;
import com.example.demo.Service.ComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comuna")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})
public class ComunaController {

    @Autowired
    ComunaService comunaService;

    @GetMapping
    public List<ComunaModel> getAllComuna(){
        return comunaService.getAllComuna();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComunaModel> getComunaById(@PathVariable int id){
        Optional<ComunaModel> comuna = comunaService.getComunaById(id);
        return comuna.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComunaModel addComuna(@RequestBody ComunaModel comunaModel){
        return comunaService.addComuna(comunaModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComuna(@PathVariable int id){
        boolean deleted = comunaService.deleteComuna(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComunaModel> updateComuna(@PathVariable int id, @RequestBody ComunaModel comuna){
        Optional<ComunaModel> updated = comunaService.updateComuna(id, comuna);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
