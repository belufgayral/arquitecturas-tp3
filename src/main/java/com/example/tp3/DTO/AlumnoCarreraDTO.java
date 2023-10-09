package com.example.tp3.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
public class AlumnoCarreraDTO {
    private Integer id_Alumno;
    private Integer id_Carrera;
    private Integer fechaInscripcion;
    private Integer fechaGraduacion;

    public AlumnoCarreraDTO(Integer id_alumno, Integer id_carrera, Integer fechaInscripcion, Integer fechaGraduacion) {
        this.id_Alumno = id_alumno;
        this.id_Carrera = id_carrera;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaGraduacion = fechaGraduacion;
    }

    public AlumnoCarreraDTO(Integer id_alumno, Integer id_carrera, Integer fechaInscripcion) {
        this.id_Alumno = id_alumno;
        this.id_Carrera = id_carrera;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaGraduacion = null;
    }

    public int getId_Alumno() {
        return id_Alumno;
    }

    public int getId_Carrera() {
        return id_Carrera;
    }

    public Integer getFechaInscripcion() {
        return fechaInscripcion;
    }

    public Integer getFechaGraduacion() {
        return fechaGraduacion;
    }

    @Override
    public String toString() {
        return "AlumnoCarreraDTO{" +
                "id_alumno=" + id_Alumno +
                ", id_carrera=" + id_Carrera +
                ", fechaInscripcion=" + fechaInscripcion +
                ", fechaGraduacion=" + fechaGraduacion +
                '}';
    }
//
//    {
//        id_alumno: 1
//        id_carrera: 2
//        fechaInscripcion: 1999,
//        fechaGraduacion: null
//    }
}
