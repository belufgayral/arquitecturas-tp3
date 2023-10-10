package com.example.tp3.controllers;


import com.example.tp3.entities.Carrera;
import com.example.tp3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping()
    public ResponseEntity<?> getCarreras() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.getCarreras());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    @GetMapping(path =  "/{carrera}")
    public ResponseEntity<?> getCarrera(@PathVariable("carrera") int id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.findById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    @GetMapping(path =  "/reporte")
    public ResponseEntity<?> getReporteCarreras(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.getReporteCarreras());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se encuentra el objeto buscado");
        }
    }

    @PostMapping()
    public ResponseEntity<?> addAlumno(@RequestBody Carrera c){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(carreraService.addCarrera(c));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. No se pudo ingresar, revise los campos e intente nuevamente.\"}");
        }
    }

    @GetMapping(path = "/inscriptos")
    public ResponseEntity<?> listarCarrerasConAlumnosIncriptos(){
        try{
            return ResponseEntity.status(200).body(carreraService.listarCarrerasConAlumnosIncriptos());
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

}
