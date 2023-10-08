package com.example.tp3.utils;

import com.example.tp3.entities.Alumno;
import com.example.tp3.entities.Carrera;
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
    CommandLineRunner initDatabase(@Qualifier("alumnoRepository") AlumnoRepository repository, @Qualifier("carreraRepository") CarreraRepository carreraRepository) {
    Carrera c1 = new Carrera("tudai");
    Carrera c2 = new Carrera("sistemas");
    Carrera c3 = new Carrera("economicas");

        return args -> {
            log.info("Preloading " + repository.save(new Alumno("Agustin", "Menchon", new Date(1999-1900,07-1,12), "masculino", 41873051, "tandil",1234)));
            log.info("Preloading " + repository.save(new Alumno("belen", "Fernandez", new Date(1998-1900,3-1,8), "femenino", 51239817, "tandil", 12345)));
            log.info("Preloading " + repository.save(new Alumno("Ezequiel", "Martinez", new Date(1998-1900,3-1,8), "masculino", 51239817, "tandil", 123456)));
            log.info("Preloading " + repository.save(new Alumno("Tano", "Mengarelli Yespersen", new Date(2000-1900,3-1,8), "masculino", 51239817, "tandil", 1234567)));
            log.info("Preloading " + carreraRepository.save(c1));
            log.info("Preloading " + carreraRepository.save(c2));
            log.info("Preloading " + carreraRepository.save(c3));

        };
    }

}
