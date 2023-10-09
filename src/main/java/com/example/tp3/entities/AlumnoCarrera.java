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
    private Integer fechaInscripcion;
    @Column
    private Integer fechaGraduacion;

    public AlumnoCarrera() {
        super();
    }

    public AlumnoCarrera(AlumnoCarreraId id, Integer fechaInscripcion) {
        super();
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
    }

    public AlumnoCarrera(AlumnoCarreraId id, Integer fechaInscripcion, Integer fechaGraduacion) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaGraduacion = fechaGraduacion;
    }

    public AlumnoCarrera(Alumno a, Carrera c, Integer fechaInscripcion, Integer fechaGraduacion) {
        this.id = new AlumnoCarreraId(a,c);
        this.fechaInscripcion = fechaInscripcion;
        this.fechaGraduacion = fechaGraduacion;
    }

    @Override
    public String toString() {
        return "AlumnoCarrera{" +
                "id=" + id +
                ", fechaInscripcion=" + fechaInscripcion +
                ", fechaGraduacion=" + fechaGraduacion +
                '}';
    }
}
