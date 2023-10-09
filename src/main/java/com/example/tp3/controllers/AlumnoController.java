package com.example.tp3.controllers;

import com.example.tp3.DTO.AlumnoCarreraDTO;
import com.example.tp3.DTO.AlumnoDTO;
import com.example.tp3.services.AlumnoService;
import com.example.tp3.entities.Alumno;
import com.example.tp3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
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


    //Recuperar todos los alumnos y especificar algún criterio de ordenamiento simple.
    @GetMapping()
    public ArrayList<AlumnoDTO> getAlumnos(@RequestParam(required = false ) String ciudad, @RequestParam(required = false ) String carrera){
        //  carrera = "tudai"
        //  ciudad = "tandil"
        //  ENDPOINT: alumnos?carrera=tudai&ciudad=tandil

        // probar con el POSTMAN en GET con esta url
        // /alumnos/carrera/{carrera}/ciudad/{ciudad}

        //  http://localhost:8080/alumnos?carrera=tudai&ciudad=tandil
        //  http://localhost:8080/alumnos?carrera=sistemas&ciudad=tandil
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");

        ArrayList<AlumnoDTO> lista = new ArrayList<>();
        if(carrera!=null){
            if(ciudad!=null){
                lista.addAll(this.alumnoService.getByCarreraAndCiudad(carrera,ciudad,sort));
            } else {
                lista.addAll(this.alumnoService.getByCarrera(carrera, sort));
            }
        } else if(ciudad!=null) {
            lista.addAll(this.alumnoService.getByCiudad(ciudad, sort));
        } else{
            lista.addAll(this.alumnoService.getAlumnos(sort));
        }

        return lista;
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

    //@RequestMapping(value="/matricular", method=RequestMethod.POST, produces= MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("/matricular")
    public ResponseEntity<?> matricularAlumno(@RequestBody AlumnoCarreraDTO acDTO) {
        //System.out.println(acDTO.toString());
        try{
            return ResponseEntity.status(200).body(alumnoService.matricularAlumno(acDTO));
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
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
