package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate; // Importante para la fecha

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre; // Coincide con "Nombre Completo"

    @Column(nullable = false)
    private String rut;    // Nuevo campo

    @Column(nullable = false)
    private String telefono; // Nuevo campo

    @Column(nullable = false) // Agregué unique para que no se repitan correos
    private String correo;

    @Column(nullable = false)
    private LocalDate fechaNacimiento; // Nuevo campo (tipo Fecha)

    @Column(nullable = false)
    private String contraseña;

    private String rol; 

    @ManyToOne
    @JoinColumn(name = "id_comuna")
    private ComunaModel comuna;
}