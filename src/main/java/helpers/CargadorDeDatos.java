package helpers;

import entities.Alumno;
import entities.Carrera;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;

@Component
public class CargadorDeDatos {
    //private final AlumnoRepositorio alumnoRep;
    //private final CarreraRepositorio carreraRep;
    @Autowired
    public CargadorDeDatos() {
        //this.alumnoRep = ;
        //this.carreraRep = ;
    }

    public void cargarDatosCSV() throws IOException {
        cargarDatosCSVAlumno();
        cargarDatosCSVCarrera();
    }

    public void cargarDatosCSVAlumno() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/csv/alumnos.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Alumno a = new Alumno();
                a.setNombre(csvRecord.get("nombre"));
                a.setApellido(csvRecord.get("apellido"));
                a.setFechaNacimiento(Date.valueOf(csvRecord.get("fechaNacimiento")));
                a.setGenero(csvRecord.get("genero"));
                a.setDni(Long.parseLong(csvRecord.get("dni")));
                a.setCiudad(csvRecord.get("ciudad"));
                a.setLegajo(Long.parseLong(csvRecord.get("legajo")));
                //alumnoRep.save(a);
            }
        }
    }

    public void cargarDatosCSVCarrera() throws IOException {
        File archivoCSV = ResourceUtils.getFile("src/main/java/csv/carreras.csv");

        try (FileReader reader = new FileReader(archivoCSV);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader)) {

            for (CSVRecord csvRecord : csvParser) {
                Carrera c = new Carrera();
                c.setNombre(csvRecord.get("nombre"));
                //carreraRep.save(c);
            }
        }
    }
}
