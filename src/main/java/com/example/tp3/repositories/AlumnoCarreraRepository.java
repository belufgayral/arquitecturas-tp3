package com.example.tp3.repositories;

import com.example.tp3.DTO.ReporteCarreraDTO;
import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.entities.AlumnoCarreraId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumnoCarreraRepository extends JpaRepository<AlumnoCarrera, AlumnoCarreraId> {

    @Query(value="""
    			SELECT nombre, anio, MAX(cant_inscriptos) as inscriptos, MAX(cant_graduados) as graduados 
    				FROM (
							SELECT c.nombre as nombre, ac.fecha_graduacion as anio, 0 AS cant_inscriptos, COUNT(ac.fecha_graduacion) AS cant_graduados
							FROM carrera c LEFT JOIN alumno_carrera ac ON ac.id_carrera = c.id
							WHERE ac.fecha_graduacion IS NOT NULL
							GROUP BY c.id, ac.fecha_graduacion
							UNION (
									SELECT c.nombre, ac.fecha_inscripcion, COUNT(ac.fecha_inscripcion) AS cant_inscriptos, 0
									FROM carrera c LEFT JOIN alumno_carrera ac ON ac.id_carrera = c.id
									GROUP BY c.id, ac.fecha_inscripcion)) graduados_inscriptos
					GROUP BY nombre, anio
					HAVING anio IS NOT NULL
					ORDER BY nombre, anio""",
	nativeQuery = true)
    public abstract List<ReporteCarreraDTO> getReporteCarreras();


}
