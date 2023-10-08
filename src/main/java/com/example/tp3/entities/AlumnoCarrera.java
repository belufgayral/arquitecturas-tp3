package com.example.tp3.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Data;

import java.sql.Date;

@Entity
@Data
public class AlumnoCarrera {
    @EmbeddedId
    private AlumnoCarreraId id;
    @Column
    private int fechaInscripcion;
    @Column
    private boolean graduado;
    @Column
    private int fechaGraduacion;

    public AlumnoCarrera() {
        super();
    }

    public AlumnoCarrera(AlumnoCarreraId id, int fechaInscripcion, boolean graduado) {
        super();
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.graduado = graduado;
    }

    public AlumnoCarrera(AlumnoCarreraId id, int fechaInscripcion, boolean graduado, int fechaGraduacion) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.graduado = graduado;
        this.fechaGraduacion = fechaGraduacion;
    }
}
