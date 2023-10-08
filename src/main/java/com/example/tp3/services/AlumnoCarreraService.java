package com.example.tp3.services;

import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.repositories.AlumnoCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoCarreraService {
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;

    public AlumnoCarrera matricularAlumno(AlumnoCarrera ac){
        return this.alumnoCarreraRepository.save(ac);
    }

}
