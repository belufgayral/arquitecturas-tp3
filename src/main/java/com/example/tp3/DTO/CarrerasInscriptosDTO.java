package com.example.tp3.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CarrerasInscriptosDTO {
    @JsonProperty("nombreCarrera")
    private String nombreCarrera;
    @JsonProperty("cantInscriptos")
    private Long cantInscriptos;

    public CarrerasInscriptosDTO(String nombreCarrera, Long cantInscriptos) {
        this.nombreCarrera = nombreCarrera;
        this.cantInscriptos = cantInscriptos;
    }

    public String getNombre() {
        return nombreCarrera;
    }

    public Long getCantInscriptos() {
        return cantInscriptos;
    }
}
