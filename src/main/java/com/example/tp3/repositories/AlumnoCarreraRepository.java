package com.example.tp3.repositories;

import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.entities.AlumnoCarreraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoCarreraRepository extends JpaRepository<AlumnoCarrera, AlumnoCarreraId> {

}
