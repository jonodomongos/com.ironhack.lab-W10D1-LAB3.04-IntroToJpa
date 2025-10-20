package com.ironhack.aeropuerto.repository;

import com.ironhack.aeropuerto.model.Cliente;
import com.ironhack.aeropuerto.model.EstadoCliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ClienteRepositoryTest {

    @Autowired
    ClienteRepository clienteRepository;

    @BeforeEach
    void limpiar() {
        clienteRepository.deleteAll();
        clienteRepository.save(new Cliente("Agustine Riviera", EstadoCliente.PLATA, 115235));
        clienteRepository.save(new Cliente("Tom Jones", EstadoCliente.ORO, 205767));
        clienteRepository.save(new Cliente("Sam Rio", EstadoCliente.NINGUNA, 2653));
    }

    @Test
    @DisplayName("crearNuevoCliente")
    void crearNuevoCliente(){
        Cliente cliente = new Cliente("Agustine Riviera", EstadoCliente.PLATA, 115235);
        Cliente nuevoCliente = clienteRepository.save(cliente);

        assertThat(nuevoCliente.getIdCliente()).isNotNull();

        assertThat(nuevoCliente.getNombreCliente()).isEqualTo("Agustine Riviera");
        assertThat(nuevoCliente.getEstadoCliente()).isEqualTo(EstadoCliente.PLATA);
        assertThat(nuevoCliente.getMillasTotalesCliente()).isEqualTo(115235);

        Optional<Cliente> encontrado = clienteRepository.findById(nuevoCliente.getIdCliente());
        assertThat(encontrado).isPresent();
        assertThat(encontrado.get().getNombreCliente()).isEqualTo("Agustine Riviera");
    }

    @Test
    @DisplayName("findByNombreCliente")
    void findByNombreCliente() {
        Optional<Cliente> encontrado = clienteRepository.findByNombreCliente("Tom Jones");

        assertThat(encontrado)
                .as("Debe existir un cliente con ese nombre")
                .isPresent();

        assertThat(encontrado.get())
                .extracting(Cliente::getEstadoCliente, Cliente::getMillasTotalesCliente)
                .containsExactly(EstadoCliente.ORO, 205767);
    }

    @Test
    @DisplayName("findByEstadoCliente")
    void findByEstadoCliente() {
        List<Cliente> estadoCliente = clienteRepository.findByEstadoCliente(EstadoCliente.NINGUNA);

        assertThat(estadoCliente)
                .hasSize(1)
                .extracting(Cliente::getNombreCliente)
                .containsExactly("Sam Rio");
    }

}