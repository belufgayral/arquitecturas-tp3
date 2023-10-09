package com.example.tp3.controllers;

import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.services.AlumnoCarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/alumnos")
public class AlumnoCarreraController {
    @Autowired
    private AlumnoCarreraService acService;




}
