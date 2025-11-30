package com.example.demo.Service;


import com.example.demo.Model.NotebookModel;
import com.example.demo.Repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("null")
@Service
public class NotebookService {

    @Autowired
    NotebookRepository NotebookRepository;

    //Listar
    public List<NotebookModel> getAllNotebooks() {
        return NotebookRepository.findAll();
    }

    //Listar por ID
    public Optional<NotebookModel> getNotebookById(int id) {
        return NotebookRepository.findById(id);
    }
    //Agregar
    public NotebookModel addNotebook(NotebookModel notebookModel){
        return NotebookRepository.save(notebookModel);
    }

    //Delete
    public boolean deleteNotebook(int id){
        if (NotebookRepository.existsById(id)){
            NotebookRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    //Update
    public Optional<NotebookModel> updateNotebook(int id, NotebookModel nuevosDatosNotebook){
        if (NotebookRepository.existsById(id)){

            NotebookModel notebookExistente = NotebookRepository.findById(id).get();

            notebookExistente.setNombre(nuevosDatosNotebook.getNombre());
            notebookExistente.setCategoria(nuevosDatosNotebook.getCategoria());
            notebookExistente.setMarca(nuevosDatosNotebook.getMarca());
            notebookExistente.setPrecio(nuevosDatosNotebook.getPrecio());
            notebookExistente.setStock(nuevosDatosNotebook.getStock());
            notebookExistente.setColor(nuevosDatosNotebook.getColor());
            notebookExistente.setProcesador(nuevosDatosNotebook.getProcesador());
            notebookExistente.setRam(nuevosDatosNotebook.getRam());
            notebookExistente.setMemoria(nuevosDatosNotebook.getMemoria());
            notebookExistente.setTarjetaVideo(nuevosDatosNotebook.getTarjetaVideo());
            notebookExistente.setDescripcion(nuevosDatosNotebook.getDescripcion());
            notebookExistente.setUrlImagen(nuevosDatosNotebook.getUrlImagen());

            return Optional.of(NotebookRepository.save(notebookExistente));
        }
        else {
            return Optional.empty();
        }
    }


}
