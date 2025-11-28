package com.example.demo.Controller;

import com.example.demo.Model.NotebookModel;
import com.example.demo.Service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notebook")
public class NotebookController {
    @Autowired
    NotebookService NotebookService;

    @GetMapping
    public String getAllNotebooks(){
        return NotebookService.getAllNotebooks();
    }

    @GetMapping("/{id}")
    public String getNotebook(@PathVariable int id){
        return NotebookService.getAudifonoById(id);
    }

    @PostMapping
    public  String addNotebook(@RequestBody NotebookModel notebookModel){
        return NotebookService.addNotebook(notebookModel);
    }

    @DeleteMapping("/{id}")
    public String deleteNotebook(@PathVariable int id){
        return NotebookService.deleteNotebook(id); // Llama al servicio con el ID
    }

    @PutMapping("/{id}")
    public String updateNotebook(@PathVariable int id, @RequestBody NotebookModel notebook){
        return NotebookService.updateNotebook(id, notebook);
    }
}
