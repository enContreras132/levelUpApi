package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "notebook")

public class NotebookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String categoria;
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private int precio;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String procesador;
    @Column(nullable = false)
    private String ram;
    @Column(nullable = false)
    private String memoria;
    @Column(nullable = false)
    private String tarjetaVideo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String urlImagen;


}
