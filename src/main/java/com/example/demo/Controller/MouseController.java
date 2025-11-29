package com.example.demo.Controller;

import com.example.demo.Model.MouseModel;
import com.example.demo.Service.MouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mouse")
public class MouseController {

    @Autowired
    MouseService mouseService;

    @GetMapping
    public String getAllMouse(){
        return mouseService.getAllMouse();
    }

    @GetMapping("/{id}")
    public String getMouseById(@PathVariable int id){
        return mouseService.getMouseById(id);
    }

    @PostMapping
    public  String addMouse(@RequestBody MouseModel mouseModel){
        return mouseService.addMouse(mouseModel);
    }

    @DeleteMapping("/{id}")
    public String deleteMouse(@PathVariable int id){
        return mouseService.deleteMouse(id); // Llama al servicio con el ID
    }

    @PutMapping("/{id}")
    public String updateMouse(@PathVariable int id, @RequestBody MouseModel mouse) {
        return mouseService.updateMouse(id, mouse);
    }
}
