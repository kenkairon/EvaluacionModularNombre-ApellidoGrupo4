package com.codewave.reservas;

import com.codewave.reservas.modelo.*;
import com.codewave.reservas.excepciones.*;
import com.codewave.reservas.servicio.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GestorReservasTest {

    private RepositorioReserva repositorioMock;
    private GestorReservas gestor;
    private Cancha cancha;

    @BeforeEach
    void setUp() {
        repositorioMock = mock(RepositorioReserva.class);
        gestor = new GestorReservas(repositorioMock);
        cancha = new Cancha("Cancha Norte", "Fútbol", List.of("10:00", "11:00"));
    }

    @Test
    void debeCrearReservaSiHorarioLibre() {
        Reserva reserva = new Reserva("Carlos", cancha, "2025-07-14", "10:00");
        when(repositorioMock.estaReservado("2025-07-14", "10:00", "Cancha Norte")).thenReturn(false);

        gestor.crearReserva(reserva);

        verify(repositorioMock).guardar(reserva);
    }

    @Test
    void debeLanzarExcepcionSiHorarioOcupado() {
        Reserva reserva = new Reserva("Ana", cancha, "2025-07-14", "10:00");
        when(repositorioMock.estaReservado("2025-07-14", "10:00", "Cancha Norte")).thenReturn(true);

        assertThrows(HorarioOcupadoException.class, () -> gestor.crearReserva(reserva));
    }

    @Test
    void debeContarReservasPorDia() {
        when(repositorioMock.obtenerReservasPorFecha("2025-07-14"))
                .thenReturn(List.of(
                        new Reserva("Carlos", cancha, "2025-07-14", "10:00"),
                        new Reserva("Ana", cancha, "2025-07-14", "11:00")));

        int total = gestor.contarReservasPorDia("2025-07-14");
        assertEquals(2, total);
    }
}
