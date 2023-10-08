package com.example.tp3.repositories;

import com.example.tp3.entities.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
    public abstract List<Alumno> findByApellido (String apellido);
    public abstract boolean deleteAlumnoById (Integer id);

    public abstract Optional<Alumno> findByLegajo (long legajo);

    public abstract List<Alumno> findByGenero(String genero);

}
