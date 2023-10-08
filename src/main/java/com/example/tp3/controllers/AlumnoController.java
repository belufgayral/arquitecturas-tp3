package com.example.tp3.controllers;

import com.example.tp3.services.AlumnoService;
import com.example.tp3.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping()
    public ArrayList<Alumno> getAlumnos(){
        return this.alumnoService.getAlumnos();
    }

    @PostMapping()
    public Alumno addAlumno(@RequestBody Alumno a){
        return this.alumnoService.addAlumno(a);
    }


    @GetMapping( path = "/{id}")
    public Optional<Alumno> getById(@PathVariable("id") Integer id){
        return this.alumnoService.getById(id);
    }

    @GetMapping( path = "/apellido/{apellido}")
    public List<Alumno> getByApellido(@PathVariable("apellido") String apellido){
        return this.alumnoService.getByApellido(apellido);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteByID(@PathVariable("id") Integer id){
        boolean ok = this.alumnoService.deleteAlumno(id);
        if(ok){
            return "Eliminado con exito";
        } else {
            return "No se pudo eliminar el alumno con id " + id;
        }
    }


}
