package com.ironhack.aeropuerto.repository;

import com.ironhack.aeropuerto.model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {
    Optional<Vuelo> findByNumeroVuelo(String numeroVuelo);
    List<Vuelo> findByAeronaveContainingIgnoreCase(String texto);
    List<Vuelo> findByMillasVueloGreaterThan(int millas);
}
