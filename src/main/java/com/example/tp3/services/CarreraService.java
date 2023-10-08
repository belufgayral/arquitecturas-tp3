package com.example.tp3.services;

import com.example.tp3.entities.Carrera;
import com.example.tp3.repositories.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CarreraService {

    @Autowired
    private CarreraRepository carreraRepository;

    public ArrayList<Carrera> getCarreras() {
        return (ArrayList<Carrera>) this.carreraRepository.findAll();
    }

}
