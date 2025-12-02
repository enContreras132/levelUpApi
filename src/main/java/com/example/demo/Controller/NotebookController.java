package com.example.demo.Controller;

import com.example.demo.Model.NotebookModel;
import com.example.demo.Service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notebook")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000", "https://reactlevelup2.netlify.app"})

public class NotebookController {
    @Autowired
    NotebookService NotebookService;

    @GetMapping
    public List<NotebookModel> getAllNotebooks(){
        return NotebookService.getAllNotebooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotebookModel> getNotebook(@PathVariable int id){
        Optional<NotebookModel> notebook = NotebookService.getNotebookById(id);
        return notebook.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotebookModel addNotebook(@RequestBody NotebookModel notebookModel){
        return NotebookService.addNotebook(notebookModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotebook(@PathVariable int id){
        boolean deleted = NotebookService.deleteNotebook(id);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotebookModel> updateNotebook(@PathVariable int id, @RequestBody NotebookModel notebook){
        Optional<NotebookModel> updated = NotebookService.updateNotebook(id, notebook);
        return updated.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }
}
