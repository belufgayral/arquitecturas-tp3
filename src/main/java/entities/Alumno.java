package entities;

import lombok.Data;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Data
public class Alumno {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private Date fechaNacimiento;
    @Column
    private String genero;
    @Column
    private long dni;
    @Column
    private String ciudad;
    @Column
    private long legajo;

    public Alumno() {
        super();
    }

    public Alumno(String nombre, String apellido, Date fechaNacimiento, String genero, long dni, String ciudad,
                  long legajo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.dni = dni;
        this.ciudad = ciudad;
        this.legajo = legajo;
    }
}