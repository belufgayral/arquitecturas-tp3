package com.example.tp3.services;

import com.example.tp3.DTO.CarrerasInscriptosDTO;
import com.example.tp3.DTO.ReporteCarreraDTO;
import com.example.tp3.entities.Carrera;
import com.example.tp3.repositories.AlumnoCarreraRepository;
import com.example.tp3.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;

    public ArrayList<Carrera> getCarreras() {
        return (ArrayList<Carrera>) this.carreraRepository.findAll();
    }

    public Optional<Carrera> findById(Integer id){
        return this.carreraRepository.findById(id);
    }

    public Carrera addCarrera(Carrera c){
        return this.carreraRepository.save(c);
    }

    public Iterable<CarrerasInscriptosDTO> listarCarrerasConAlumnosIncriptos(){
        //Sort sort = Sort.by(Sort.Direction.DESC, "cantInscriptos");
        return this.carreraRepository.listarCarrerasConAlumnosIncriptos();
    }

    public List<ReporteCarreraDTO> getReporteCarreras(){
        List<ReporteCarreraDTO> list = this.alumnoCarreraRepository.getReporteCarreras();
        for(ReporteCarreraDTO r : list){
            System.out.println("--------------------");
            System.out.println("Reporte DTO => " +
                "Carrera: " + r.getNombre() + ", año:" + r.getAnio() + ", inscriptos:" + r.getInscriptos()
                + ", egresados:" + r.getGraduados());
        }
        return list;
    }
    public Optional<Carrera> findByNombre(String nombre){
        return this.carreraRepository.findByNombre(nombre);
    }

}
