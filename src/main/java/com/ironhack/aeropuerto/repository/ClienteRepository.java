package com.ironhack.aeropuerto.repository;

import com.ironhack.aeropuerto.model.Cliente;
import com.ironhack.aeropuerto.model.EstadoCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByNombreCliente(String nombreCliente);
    List<Cliente> findByEstadoCliente(EstadoCliente estadoCliente);

}
