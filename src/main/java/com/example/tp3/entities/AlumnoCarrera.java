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
    private Date fechaInscripcion;
    @Column
    private boolean graduado;
    @Column
    private Date fechaGraduacion;

    public AlumnoCarrera() {
        super();
    }

    public AlumnoCarrera(AlumnoCarreraId id, Date fechaInscripcion, boolean graduado) {
        super();
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.graduado = graduado;
    }

    public AlumnoCarrera(AlumnoCarreraId id, Date fechaInscripcion, boolean graduado, Date fechaGraduacion) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
        this.graduado = graduado;
        this.fechaGraduacion = fechaGraduacion;
    }
}
