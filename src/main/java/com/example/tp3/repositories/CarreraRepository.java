package com.example.tp3.repositories;

import com.example.tp3.DTO.CarrerasInscriptosDTO;
import com.example.tp3.entities.Carrera;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Query("SELECT new com.example.tp3.DTO.CarrerasInscriptosDTO(c.nombre, COUNT(ac.id.carrera))" + "FROM AlumnoCarrera ac JOIN ac.id.carrera c GROUP BY c ORDER BY COUNT(ac.id.carrera) DESC")
    public Iterable<CarrerasInscriptosDTO> listarCarrerasConAlumnosIncriptos();

//    @Query("SELECT c.nombre, COUNT(ac.id.carrera)" + "FROM AlumnoCarrera ac JOIN ac.id.carrera c GROUP BY c")
//    public List<CarrerasInscriptosDTO> listarCarrerasConAlumnosIncriptos(Sort sort);

    public abstract Optional<Carrera> findByNombre(String nombre);
}
