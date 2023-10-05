package entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class AlumnoCarreraId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idAlumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private Carrera carrera;

    public AlumnoCarreraId() {
        super();
    }

    public AlumnoCarreraId(Alumno alumno, Carrera carrera) {
        super();
        this.alumno = alumno;
        this.carrera = carrera;
    }
}

