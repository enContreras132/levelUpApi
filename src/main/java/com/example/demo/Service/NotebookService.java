package com.example.demo.Service;


import com.example.demo.Model.NotebookModel;
import com.example.demo.Repository.NotebookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@SuppressWarnings("null")
@Service
public class NotebookService {

    @Autowired
    NotebookRepository NotebookRepository;

    //Listar
    public String getAllNotebooks() {
        String output = "";
        for (NotebookModel nm : NotebookRepository.findAll()){
            output += "id: "+nm.getId()+"\n";
            output += "nombre: "+nm.getNombre()+"\n";
            output += "categoria: "+nm.getCategoria();
            output += "marca: "+nm.getMarca()+"\n";
            output += "precio: "+nm.getPrecio()+"\n";
            output += "stock: "+nm.getStock()+"\n";
            output += "color: "+nm.getColor()+"\n";
            output += "procesador: "+nm.getProcesador()+"\n";
            output += "ram: "+nm.getRam()+"\n";
            output += "memoria: "+nm.getMemoria()+"\n";
            output += "tarjeta video: "+nm.getTarjetaVideo()+"\n";
            output += "descripcion: "+nm.getDescripcion()+"\n";
            output += "url imagen: "+nm.getUrlImagen()+"\n";

        }
        if (output.isEmpty()){
            return "Agregar Notebook!";
        }
        else {
            return output;
        }
    }

    //Listar por ID
    public String getAudifonoById(int id) {
        String output = "";
        if (NotebookRepository.existsById(id)){
            NotebookModel nm = NotebookRepository.findById(id).get();
            output += "id: "+nm.getId()+"\n";
            output += "nombre: "+nm.getNombre()+"\n";
            output += "categoria: "+nm.getCategoria();
            output += "marca: "+nm.getMarca()+"\n";
            output += "precio: "+nm.getPrecio()+"\n";
            output += "stock: "+nm.getStock()+"\n";
            output += "color: "+nm.getColor()+"\n";
            output += "procesador: "+nm.getProcesador()+"\n";
            output += "ram: "+nm.getRam()+"\n";
            output += "memoria: "+nm.getMemoria()+"\n";
            output += "tarjeta video: "+nm.getTarjetaVideo()+"\n";
            output += "descripcion: "+nm.getDescripcion()+"\n";
            output += "url imagen: "+nm.getUrlImagen()+"\n";

            return output;
        }
        else {
            return "Notebook no encontrado";
        }
    }
    //Agregar
    public String addNotebook(NotebookModel notebookModel){
        NotebookRepository.save(notebookModel);
        return "Notebook agregegado";
    }

    //Delete
    public String deleteNotebook(int id){
        if (NotebookRepository.existsById(id)){
            NotebookRepository.deleteById(id);
            return "Notebook eliminado";
        }else{
            return "Notebook no encontrado";
        }
    }

    //Update
    public String updateNotebook(int id, NotebookModel nuevosDatosNotebook){
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

            NotebookRepository.save(notebookExistente);

            return "Notebook actualizado exitosamente";
        }
        else {
            return "Notebook no encontrado con ID: " + id;
        }
    }


}
