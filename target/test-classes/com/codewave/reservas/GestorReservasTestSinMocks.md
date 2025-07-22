````java
package com.codewave.reservas;

import com.codewave.reservas.excepciones.HorarioOcupadoException;
import com.codewave.reservas.modelo.Cancha;
import com.codewave.reservas.modelo.Reserva;
import com.codewave.reservas.servicio.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorReservasTestSinMocks {

    private RepositorioReserva repositorio;
    private GestorReservas gestor;
    private Cancha cancha;

    @BeforeEach
    void setUp() {
        repositorio = new RepositorioReservaImpl();
        gestor = new GestorReservas(repositorio);
        cancha = new Cancha("Cancha Norte", "Fútbol", List.of("10:00", "11:00"));
    }

    @Test
    void debeCrearReservaSiHorarioLibre() {
        Reserva reserva = new Reserva("Carlos", cancha, "2025-07-14", "10:00");
        gestor.crearReserva(reserva);
        assertEquals(1, repositorio.obtenerReservasPorFecha("2025-07-14").size());
    }

    @Test
    void debeLanzarExcepcionSiHorarioOcupado() {
        Reserva r1 = new Reserva("Carlos", cancha, "2025-07-14", "10:00");
        gestor.crearReserva(r1);
        Reserva r2 = new Reserva("Ana", cancha, "2025-07-14", "10:00");
        assertThrows(HorarioOcupadoException.class, () -> gestor.crearReserva(r2));
    }

    @Test
    void debeContarReservasPorDia() {
        gestor.crearReserva(new Reserva("Carlos", cancha, "2025-07-14", "10:00"));
        gestor.crearReserva(new Reserva("Ana", cancha, "2025-07-14", "11:00"));
        assertEquals(2, gestor.contarReservasPorDia("2025-07-14"));
    }

    @Test
    void debeRetornarFalseSiNoHayReservasEseDia() {
        assertEquals(0, gestor.contarReservasPorDia("2025-07-15"));
    }

    @Test
    void debeLanzarExcepcionSiReservaEsNula() {
        assertThrows(NullPointerException.class, () -> gestor.crearReserva(null));
    }
}
