package com.example.tp3;

import helpers.CargadorDeDatos;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Tp3Application {

    @Autowired
    private CargadorDeDatos helper; //necesita los repos
    public static void main(String[] args) {
        SpringApplication.run(Tp3Application.class, args);
    }

    @PostConstruct
    public void init() throws IOException {
        helper.cargarDatosCSV();
    }

}
