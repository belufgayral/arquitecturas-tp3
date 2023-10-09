package com.example.tp3.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AlumnoDTO {
    private long legajo;
    private long dni;
    private String nombreCompleto;
    private String ciudad;

    public AlumnoDTO(long legajo, long dni, String nombre,String apellido, String ciudad) {
        this.legajo = legajo;
        this.dni = dni;
        this.nombreCompleto = nombre+' '+apellido;
        this.ciudad = ciudad;
    }

    public long getLegajo() {
        return legajo;
    }

    public long getDni() {
        return dni;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCiudad() {
        return ciudad;
    }


    @Override
    public String toString() {
        return "AlumnoDTO{" +
                "legajo=" + legajo +
                ", dni=" + dni +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}