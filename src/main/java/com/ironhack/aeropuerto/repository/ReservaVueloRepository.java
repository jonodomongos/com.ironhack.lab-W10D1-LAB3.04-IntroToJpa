package com.ironhack.aeropuerto.repository;

import com.ironhack.aeropuerto.model.ReservaVuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaVueloRepository extends JpaRepository<ReservaVuelo, Integer> {
}
