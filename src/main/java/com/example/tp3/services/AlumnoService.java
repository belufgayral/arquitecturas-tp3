package com.example.tp3.services;

import com.example.tp3.DTO.AlumnoCarreraDTO;
import com.example.tp3.DTO.AlumnoDTO;
import com.example.tp3.entities.Alumno;
import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.entities.Carrera;
import com.example.tp3.repositories.AlumnoCarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.tp3.repositories.AlumnoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Autowired
    private CarreraService carreraService;
    @Autowired
    private AlumnoCarreraRepository alumnoCarreraRepository;



    public List<AlumnoDTO> getAlumnos(Sort sort){
        return alumnoRepository.findAllDTO(sort);
    }

    public Alumno addAlumno(Alumno a){
        return alumnoRepository.save(a);
    }

    public List<Alumno> getByApellido(String apellido){
        return this.alumnoRepository.findByApellido(apellido);
    }

    public Optional<Alumno> getByLegajo(Long legajo){
        return this.alumnoRepository.findByLegajo(legajo);
    }

    public AlumnoCarrera matricularAlumno(AlumnoCarreraDTO acDTO){
        Optional<Alumno> a1 = this.getById(acDTO.getId_Alumno());
        Optional<Carrera> c1 = carreraService.findById(acDTO.getId_Carrera());
        if(a1.isPresent() && c1.isPresent()){
            AlumnoCarrera ac = new AlumnoCarrera(a1.get(), c1.get(), acDTO.getFechaInscripcion(), acDTO.getFechaGraduacion());
            alumnoCarreraRepository.save(ac);
            return ac;
        }
        return null;
    }

    public List<Alumno> getByGenero(String genero){
        return this.alumnoRepository.findByGenero(genero);
    }

    public Optional<Alumno> getById(Integer id){
        return this.alumnoRepository.findById(id);
    }

    public boolean deleteAlumno(Integer id){
        return this.alumnoRepository.deleteAlumnoById(id);
    }

    public List<AlumnoDTO> getByCiudad(String ciudad, Sort sort) {
        return this.alumnoRepository.findByCiudad(ciudad);
    }

    public List<AlumnoDTO> getByCarrera(String carrera, Sort sort) {
        Optional<Carrera> c = this.carreraService.findByNombre(carrera);
        List<AlumnoDTO> list = new ArrayList<>();
        if(c.isPresent()){
            list.addAll(this.alumnoRepository.findAlumnoByCarrera(c.get().getId()));
        }
        return list;
    }

    public List<AlumnoDTO> getByCarreraAndCiudad(String carrera, String ciudad, Sort sort) {
        Optional<Carrera> c = this.carreraService.findByNombre(carrera);
        List<AlumnoDTO> list = new ArrayList<>();
        if(c.isPresent()){
            list.addAll(this.alumnoRepository.findAlumnoByCarreraAndCiudad(ciudad, c.get().getId()));
        }
        return list;
    }
}
