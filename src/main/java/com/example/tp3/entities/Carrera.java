package com.example.tp3.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carrera {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String nombre;

    public Carrera() {
        super();
    }

    public Carrera(String nombre) {
        super();
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        Carrera c1 = (Carrera) o;
        if (this.id == c1.id) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
