package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "mouse")

public class MouseModel {
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
    private String inalambrico;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private int botonesCant;
    @Column(nullable = false)
    private int dpiMin;
    @Column(nullable = false)
    private int dpiMax;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private String urlImagen;

}