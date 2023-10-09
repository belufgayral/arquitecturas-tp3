package com.example.tp3.services;

import com.example.tp3.DTO.AlumnoCarreraDTO;
import com.example.tp3.entities.Alumno;
import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.entities.AlumnoCarreraId;
import com.example.tp3.entities.Carrera;
import com.example.tp3.repositories.AlumnoCarreraRepository;
import com.example.tp3.repositories.AlumnoRepository;
import com.example.tp3.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoCarreraService {
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;
    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CarreraRepository carreraRepository;



}
