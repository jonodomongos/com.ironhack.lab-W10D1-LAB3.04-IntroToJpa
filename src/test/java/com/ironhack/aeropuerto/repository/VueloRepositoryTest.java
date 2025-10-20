package com.ironhack.aeropuerto.repository;

import com.ironhack.aeropuerto.model.Vuelo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VueloRepositoryTest {

    @Autowired
    VueloRepository vueloRepository;

    @BeforeEach
    void limpiar() {
        vueloRepository.deleteAll();
        vueloRepository.save(new Vuelo("DL143", "Boeing 747", 400, 135));
        vueloRepository.save(new Vuelo("DL122", "Airbus A330", 236, 4370));
        vueloRepository.save(new Vuelo("DL053", "Boeing 777", 264, 2078));
    }

    @Test
    @DisplayName("crearNuevoVuelo")
    void crearNuevoVuelo(){
        Vuelo vuelo = new Vuelo("DL143", "Boeing 747", 400, 135);
        Vuelo nuevoVuelo = vueloRepository.save(vuelo);

        assertAll(
                () -> assertThat(nuevoVuelo.getNumeroVuelo()).as("numeroVuelo").isEqualTo("DL143"),
                () -> assertThat(nuevoVuelo.getAeronave()).as("aeronave").isEqualTo("Boeing 747"),
                () -> assertThat(nuevoVuelo.getTotalAsientosAeronave()).as("asientos").isEqualTo(400),
                () -> assertThat(nuevoVuelo.getMillasVuelo()).as("millas").isEqualTo(135)
        );

        Optional<Vuelo> encontrado = vueloRepository.findById(nuevoVuelo.getIdVuelo());
        assertThat(encontrado)
                .as("El vuelo debería poder recuperarse desde la base de datos")
                .isPresent();

        assertThat(encontrado.get().getNumeroVuelo())
                .as("El vuelo recuperado debería tener el mismo número")
                .isEqualTo("DL143");
    }

    @Test
    @DisplayName("findByNumeroVuelo")
    void findByNumeroVuelo() {
        Optional<Vuelo> numeroVuelo = vueloRepository.findByNumeroVuelo("DL122");

        assertThat(numeroVuelo)
                .as("Debe existir un vuelo con número DL122")
                .isPresent();

        assertThat(numeroVuelo.get())
                .extracting(Vuelo::getAeronave, Vuelo::getTotalAsientosAeronave, Vuelo::getMillasVuelo)
                .containsExactly("Airbus A330", 236, 4370);
    }

    @Test
    @DisplayName("findByAeronaveContainingIgnoreCase")
    void findByAeronaveContaining() {
        List<Vuelo> boeings = vueloRepository.findByAeronaveContainingIgnoreCase("Boeing");

        assertThat(boeings)
                .as("Debe devolver exactamente los vuelos con aeronave que contiene 'Boeing'")
                .hasSize(2)
                .extracting(Vuelo::getNumeroVuelo, Vuelo::getAeronave)
                .containsExactlyInAnyOrder(
                        org.assertj.core.api.Assertions.tuple("DL143", "Boeing 747"),
                        org.assertj.core.api.Assertions.tuple("DL053", "Boeing 777")
                );
    }

    @Test
    @DisplayName("findByMillasVueloGreaterThan")
    void findByMillasVueloGreaterThan() {
       List<Vuelo> vueloGreaterThan = vueloRepository.findByMillasVueloGreaterThan(500);

        assertThat(vueloGreaterThan)
                .as("Debe devolver exactamente los vuelos con millas > 500")
                .hasSize(2)
                .extracting(Vuelo::getNumeroVuelo, Vuelo::getMillasVuelo)
                .containsExactlyInAnyOrder(
                        org.assertj.core.api.Assertions.tuple("DL122", 4370),
                        org.assertj.core.api.Assertions.tuple("DL053", 2078)
                );
    }
}