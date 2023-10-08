package com.example.tp3.controllers;

import com.example.tp3.entities.Carrera;
import com.example.tp3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/carrera")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping()
    public ArrayList<Carrera> getCarreras() {
        return this.carreraService.getCarreras();
    }

}
