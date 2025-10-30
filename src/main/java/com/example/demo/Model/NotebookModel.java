package com.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class NotebookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String categoria;
    private String marca;
    private int precio;
    private int stock;
    private String color;
    private String procesador;
    private String ram;
    private String memoria;
    private String tarjetaVideo;
    private String descripcion;
    private String urlImagen;


}
