package com.example.tp3.repositories;

import com.example.tp3.DTO.AlumnoDTO;
import com.example.tp3.entities.Alumno;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    public abstract boolean deleteAlumnoById (Integer id);
    public abstract List<Alumno> findByApellido (String apellido);

    public abstract Optional<Alumno> findByLegajo (long legajo);

    public abstract List<Alumno> findByGenero(String genero);

    @Query("SELECT new com.example.tp3.DTO.AlumnoDTO(a.legajo, a.dni, a.nombre, a.apellido, a.ciudad) " + "FROM Alumno a WHERE a.ciudad = :ciudad")
    public abstract List<AlumnoDTO> findByCiudad(String ciudad);

    @Query("SELECT new com.example.tp3.DTO.AlumnoDTO(a.legajo, a.dni, a.nombre, a.apellido, a.ciudad) " + "FROM Alumno a")
    public abstract List<AlumnoDTO> findAllDTO(Sort sort);

    @Query("SELECT new com.example.tp3.DTO.AlumnoDTO(a.legajo, a.dni, a.nombre, a.apellido, a.ciudad) " + "FROM AlumnoCarrera ac JOIN ac.id.alumno a JOIN ac.id.carrera c WHERE c.id = :carrera AND a.ciudad  = :ciudad ")
    public abstract List<AlumnoDTO> findAlumnoByCarreraAndCiudad(String ciudad, int carrera);

    @Query("SELECT new com.example.tp3.DTO.AlumnoDTO(a.legajo, a.dni, a.nombre, a.apellido, a.ciudad) " + "FROM AlumnoCarrera ac JOIN ac.id.alumno a JOIN ac.id.carrera c WHERE c.id = :carrera")
    public abstract List<AlumnoDTO> findAlumnoByCarrera(int carrera);

}
