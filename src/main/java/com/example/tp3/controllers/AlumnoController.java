package com.example.tp3.controllers;

import com.example.tp3.DTO.AlumnoCarreraDTO;
import com.example.tp3.DTO.AlumnoDTO;
import com.example.tp3.services.AlumnoService;
import com.example.tp3.entities.Alumno;
import com.example.tp3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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


    //Recuperar todos los alumnos y especificar algún criterio de ordenamiento simple.
    @GetMapping()
    public ResponseEntity<?> getAlumnos(@RequestParam(required = false ) String ciudad, @RequestParam(required = false ) String carrera){
        //  carrera = "tudai"
        //  ciudad = "tandil"
        //  ENDPOINT: alumnos?carrera=tudai&ciudad=tandil

        // probar con el POSTMAN en GET con esta url

        //  http://localhost:8080/alumnos?carrera=tudai&ciudad=tandil
        //  http://localhost:8080/alumnos?carrera=sistemas&ciudad=tandil
        Sort sort = Sort.by(Sort.Direction.ASC, "nombre");
        try{
            if(carrera!=null){
                if(ciudad!=null){
                    return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getByCarreraAndCiudad(carrera,ciudad,sort));
                    //lista.addAll(this.alumnoService.getByCarreraAndCiudad(carrera,ciudad,sort));
                } else {
                    return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getByCarrera(carrera, sort));
                    //lista.addAll(this.alumnoService.getByCarrera(carrera, sort));
                }
            } else if(ciudad!=null) {
                return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getByCiudad(ciudad, sort));
                //lista.addAll(this.alumnoService.getByCiudad(ciudad, sort));
            } else{
                return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getAlumnos(sort));
                //lista.addAll(this.alumnoService.getAlumnos(sort));
            }
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }


    //agregar alumno
    @PostMapping()
    public ResponseEntity<?> addAlumno(@RequestBody Alumno a){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.addAlumno(a));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }

    //recuperar Alumno por ID
    @GetMapping( path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    // recuperar un estudiante, en base a su número de libreta universitaria.
    @GetMapping(path = "/legajo/{legajo}")
    public ResponseEntity<?>  getByLegajo(@PathVariable("legajo") Long legajo){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getByLegajo(legajo));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    //Recuperar un estudiante en base a su apellido
    @GetMapping( path = "/apellido/{apellido}")
    public ResponseEntity<?> getByApellido(@PathVariable("apellido") String apellido){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getByApellido(apellido));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    //recuperar los estudiantes en base a su genero
    @GetMapping( path = "/genero/{genero}")
    public ResponseEntity<?> getByGenero(@PathVariable("genero") String genero){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(alumnoService.getByGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    @PostMapping("/matricular")
    public ResponseEntity<?> matricularAlumno(@RequestBody AlumnoCarreraDTO acDTO) {
        try{
            return ResponseEntity.status(200).body(alumnoService.matricularAlumno(acDTO));
        }catch (Exception error){
            return ResponseEntity.status(404).body(error.getMessage());
        }
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(alumnoService.deleteAlumno(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. no se pudo eliminar el alumno con id  \"" + id + ". intente nuevamente.\"}");
        }
    }


}
