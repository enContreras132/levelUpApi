package com.example.demo.Controller;

import com.example.demo.Model.MouseModel;
import com.example.demo.Service.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mouse")
public class MouseController {

    @Autowired
    MouseService mouseService;

    @GetMapping
    public List<MouseModel> getAllMouse(){
        return mouseService.getAllMouse();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MouseModel> getMouseById(@PathVariable int id){
        Optional<MouseModel> mouse = mouseService.getMouseById(id);
        return mouse.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public MouseModel addMouse(@RequestBody MouseModel mouseModel){
        return mouseService.addMouse(mouseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMouse(@PathVariable int id){
        boolean deleted = mouseService.deleteMouse(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MouseModel> updateMouse(@PathVariable int id, @RequestBody MouseModel mouse) {
        Optional<MouseModel> updated = mouseService.updateMouse(id, mouse);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
