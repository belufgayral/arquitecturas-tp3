package com.example.tp3.services;

import com.example.tp3.DTO.CarrerasInscriptosDTO;
import com.example.tp3.entities.Carrera;
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

    public Optional<Carrera> findByNombre(String nombre){
        return this.carreraRepository.findByNombre(nombre);
    }

}
