package com.example.demo.Controller;

import com.example.demo.Model.AudifonoModel;
import com.example.demo.Service.AudifonoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/audifono")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name ="Audifonos", description = "Producto del sistema")

public class AudifonoController {

    @Autowired
    AudifonoService AudifonoService;

    @GetMapping
    @Operation(summary = "obtener todos los audifonos del sistema", description = "una lista con los datos de los audifonos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "se muestra la lista de audifonos"),
            @ApiResponse(responseCode = "400", description = "No se ha podido obtener todos los audifonos del sistema")

    })
    public List<AudifonoModel> getAllAudifono(){
        return AudifonoService.getAllAudifono();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AudifonoModel> getAudifonoById(@PathVariable int id){
        Optional<AudifonoModel> audifono = AudifonoService.getAudifonoById(id);
        return audifono.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public AudifonoModel addAudifono(@RequestBody AudifonoModel audifonoModel){
        return AudifonoService.addAudifono(audifonoModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAudifono(@PathVariable int id){
        boolean deleted = AudifonoService.deleteAudifono(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AudifonoModel> updateAudifono(@PathVariable int id, @RequestBody AudifonoModel audifono){
        Optional<AudifonoModel> updated = AudifonoService.updateAudifono(id, audifono);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
