package com.example.tp3.controllers;

import com.example.tp3.DTO.CarrerasInscriptosDTO;
import com.example.tp3.DTO.ReporteCarreraDTO;
import com.example.tp3.entities.Alumno;
import com.example.tp3.entities.Carrera;
import com.example.tp3.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraService carreraService;

    @GetMapping()
    public ArrayList<Carrera> getCarreras() {
        return this.carreraService.getCarreras();
    }

    @GetMapping(path =  "/{carrera}")
    public Optional<Carrera> getCarrera(@PathVariable("carrera") int id){
        return this.carreraService.findById(id);
    }

    @GetMapping(path =  "/reporte")
    public List<ReporteCarreraDTO> getReporteCarreras(){
        List<ReporteCarreraDTO> list = new ArrayList<>();
        list.addAll(this.carreraService.getReporteCarreras());
        return list;
    }

    @PostMapping()
    public Carrera addAlumno(@RequestBody Carrera c){
        return this.carreraService.addCarrera(c);
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
