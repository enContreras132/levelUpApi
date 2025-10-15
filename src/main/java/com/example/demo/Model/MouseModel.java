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

public class MouseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMouse;

    private String nombre;
    private String marca;
    private int precio;
    private int stock;
    private Boolean inalambrico;
    private String color;
    private int botonesCant;
    private int dpiMin;
    private int dpiMax;
    private String descripcion;

    public int getIdMouse() {
        return idMouse;
    }

    public void setIdMouse(int idModel) {
        this.idMouse = idModel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Boolean getInalambrico() {
        return inalambrico;
    }

    public void setInalambrico(Boolean inalambrico) {
        this.inalambrico = inalambrico;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getBotonesCant() {
        return botonesCant;
    }

    public void setBotonesCant(int botonesCant) {
        this.botonesCant = botonesCant;
    }

    public int getDpiMin() {
        return dpiMin;
    }

    public void setDpiMin(int dpiMin) {
        this.dpiMin = dpiMin;
    }

    public int getDpiMax() {
        return dpiMax;
    }

    public void setDpiMax(int dpiMax) {
        this.dpiMax = dpiMax;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
