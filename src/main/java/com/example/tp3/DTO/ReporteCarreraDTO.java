package com.example.tp3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

//@Getter
//@NoArgsConstructor
public interface ReporteCarreraDTO {
    String getNombre();
    Integer getAnio();
    Long getInscriptos();
    Long getGraduados();

    @Override
    public String toString();


//    private String nombreCarrera;
//    private Integer anio;
//    private Integer inscriptos;
//    private Integer egresados;

//    public ReporteCarreraDTO(String nombre, Integer anio, Integer inscriptos, Integer egresados){
//        this.nombreCarrera = nombre;
//        this.anio = anio;
//        this.inscriptos = inscriptos;
//        this.egresados = egresados;
//    }


//    public String getNombreCarrera() {
//        return nombreCarrera;
//    }
//
//    public Integer getAnio() {
//        return anio;
//    }
//    public Integer getEgresados() {
//        return egresados;
//    }
//
//    public Integer getInscriptos() {
//        return inscriptos;
//    }
//
//    public void setNombreCarrera(String nombreCarrera) {
//        this.nombreCarrera = nombreCarrera;
//    }
//
//    public void setAnio(int anio) {
//        this.anio = anio;
//    }
//
//    public void setEgresados(int egresados) {
//        this.egresados = egresados;
//    }
//
//    public void setInscriptos(int regulares) {
//        this.inscriptos = regulares;
//    }
//

}
