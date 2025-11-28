package com.example.demo.Model;


import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String rol;
    @Column(nullable = false)
    private String correo;
    @Column(nullable = false)
    private String contraseña;
}
