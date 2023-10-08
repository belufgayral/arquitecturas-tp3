package com.example.tp3.services;

import com.example.tp3.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.tp3.repositories.AlumnoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public ArrayList<Alumno> getAlumnos(){
        return (ArrayList<Alumno>) alumnoRepository.findAll();
    }

    public Alumno addAlumno(Alumno a){
        return alumnoRepository.save(a);
    }

    public List<Alumno> getByApellido(String apellido){
        return this.alumnoRepository.findByApellido(apellido);
    }

    public Optional<Alumno> getById(Integer id){
        return this.alumnoRepository.findById(id);
    }

    public boolean deleteAlumno(Integer id){
        return this.alumnoRepository.deleteAlumnoById(id);
    }
}
