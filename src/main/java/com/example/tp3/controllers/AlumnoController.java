package com.example.tp3.controllers;

import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.services.AlumnoCarreraService;
import com.example.tp3.services.AlumnoService;
import com.example.tp3.entities.Alumno;
import com.example.tp3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;
    @Autowired
    private CarreraService carreraService;
    @Autowired
    private AlumnoCarreraService alumnoCarreraService;


    //Recuperar todos los alumnos y especificar algún criterio de ordenamiento simple.
    @GetMapping()
    public ArrayList<Alumno> getAlumnos(){
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");
        return this.alumnoService.getAlumnos(sort);
    }


    //agregar alumno
    @PostMapping()
    public Alumno addAlumno(@RequestBody Alumno a){
        return this.alumnoService.addAlumno(a);
    }


    //recuperar Alumno por ID
    @GetMapping( path = "/{id}")
    public Optional<Alumno> getById(@PathVariable("id") Integer id){
        return this.alumnoService.getById(id);
    }

    // recuperar un estudiante, en base a su número de libreta universitaria.
    @GetMapping(path = "/legajo/{legajo}")
    public Optional<Alumno> getByLegajo(@PathVariable("legajo") Long legajo){
        return this.alumnoService.getByLegajo(legajo);
    }

    //Recuperar un estudiante en base a su apellido
    @GetMapping( path = "/apellido/{apellido}")
    public List<Alumno> getByApellido(@PathVariable("apellido") String apellido){
        return this.alumnoService.getByApellido(apellido);
    }


    //recuperar los estudiantes en base a su genero
    @GetMapping( path = "/genero/{genero}")
    public List<Alumno> getByGenero(@PathVariable("genero") String genero){
        return this.alumnoService.getByGenero(genero);
    }
//
//    @PostMapping()
//    public AlumnoCarrera matricularAlumno(@RequestBody AlumnoCarrera ac) {
//        return this.alumnoCarreraService.matricularAlumno(ac);
//    }

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
