package com.example.tp3.utils;

import com.example.tp3.entities.Alumno;
import com.example.tp3.entities.AlumnoCarrera;
import com.example.tp3.entities.Carrera;
import com.example.tp3.repositories.AlumnoCarreraRepository;
import com.example.tp3.repositories.AlumnoRepository;

import com.example.tp3.repositories.CarreraRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(@Qualifier("alumnoRepository") AlumnoRepository repository, @Qualifier("carreraRepository") CarreraRepository carreraRepository, @Qualifier("alumnoCarreraRepository") AlumnoCarreraRepository acRep) {
    Carrera c1 = new Carrera("tudai");
    Carrera c2 = new Carrera("sistemas");
    Carrera c3 = new Carrera("economicas");

    Alumno a1 = new Alumno("Agustin", "Menchon", new Date(1999-1900,07-1,12), "masculino", 41873051, "tandil",1234);
    Alumno a2 = new Alumno("belen", "Fernandez", new Date(1998-1900,3-1,8), "femenino", 51239817, "tandil", 12345);
    Alumno a3 = new Alumno("Ezequiel", "Martinez", new Date(1998-1900,3-1,8), "masculino", 51239817, "tandil", 123456);
    Alumno a4 = new Alumno("Tano", "Mengarelli Yespersen", new Date(2000-1900,3-1,8), "masculino", 51239817, "necochea", 1234567);
        return args -> {
            log.info("Preloading " + repository.save(a1));
            log.info("Preloading " + repository.save(a2));
            log.info("Preloading " + repository.save(a3));
            log.info("Preloading " + repository.save(a4));

            log.info("Preloading " + carreraRepository.save(c1));
            log.info("Preloading " + carreraRepository.save(c2));
            log.info("Preloading " + carreraRepository.save(c3));



            log.info("Preloading " + acRep.save(new AlumnoCarrera(a1, c1, 1999, 2005)));
            log.info("Preloading " + acRep.save(new AlumnoCarrera(a2, c1, 1998, 2002)));
            log.info("Preloading " + acRep.save(new AlumnoCarrera(a3, c2, 1998, 2002)));
            log.info("Preloading " + acRep.save(new AlumnoCarrera(a4, c1, 1998, 2002)));
        };
    }

}
