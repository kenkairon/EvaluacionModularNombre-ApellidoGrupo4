````java
package com.codewave.reservas;

import com.codewave.reservas.modelo.*; // modelo reservas 
import com.codewave.reservas.excepciones.*; // excepciones: debe contener excepciones personalizadas como HorarioOcupadoException.
import com.codewave.reservas.servicio.*; //servicio: donde está la clase principal GestorReservas y la interfaz RepositorioReserva.
import org.junit.jupiter.api.BeforeEach; // Se ejecuta en cada prueba
import org.junit.jupiter.api.Test; // marca un método como una prueba unitaria.

import java.util.List;

import static org.junit.jupiter.api.Assertions.*; // validaciones típicas.
import static org.mockito.Mockito.*; //mock(), when(), verify(): funciones de Mockito para simular dependencias.

public class GestorReservasTest {

    private RepositorioReserva repositorioMock;
    private GestorReservas gestor;
    private Cancha cancha;

    @BeforeEach // Prepara los objetos antes de cada prueba.
    void setUp() {
        repositorioMock = mock(RepositorioReserva.class); // crea un objeto simulado (falso)
        gestor = new GestorReservas(repositorioMock); // inyecta el mock en el gestor
        cancha = new Cancha("Cancha Norte", "Fútbol", List.of("10:00", "11:00"));
    }

    @Test // Prueba 1: Reservar si horario está libre
    void debeCrearReservaSiHorarioLibre() {
        Reserva reserva = new Reserva("Carlos", cancha, "2025-07-14", "10:00");
        when(repositorioMock.estaReservado("2025-07-14", "10:00", "Cancha Norte")).thenReturn(false);

        gestor.crearReserva(reserva);

        verify(repositorioMock).guardar(reserva); // verifica que se haya llamado a guardar()
    }

    @Test // Prueba 2: Lanza excepción si el horario está ocupado
    void debeLanzarExcepcionSiHorarioOcupado() {
        Reserva reserva = new Reserva("Ana", cancha, "2025-07-14", "10:00");
        when(repositorioMock.estaReservado("2025-07-14", "10:00", "Cancha Norte")).thenReturn(true);

        assertThrows(HorarioOcupadoException.class, () -> gestor.crearReserva(reserva));
    }

    @Test // Prueba 3: Contar reservas por día
    void debeContarReservasPorDia() {
        when(repositorioMock.obtenerReservasPorFecha("2025-07-14"))
                .thenReturn(List.of(
                        new Reserva("Carlos", cancha, "2025-07-14", "10:00"),
                        new Reserva("Ana", cancha, "2025-07-14", "11:00")));

        int total = gestor.contarReservasPorDia("2025-07-14");
        assertEquals(2, total);
    }

    @Test // Prueba 4 No debe guardar si esta reservado
    void debeRetornarFalseSiNoHayReservasEseDia() {
        when(repositorioMock.obtenerReservasPorFecha("2025-07-15")).thenReturn(List.of());

        int total = gestor.contarReservasPorDia("2025-07-15");

        assertEquals(0, total);
    }

    @Test // Prueba 5 (comportamiento natural sin validación)
    void debeLanzarExcepcionSiReservaEsNula() {
        assertThrows(NullPointerException.class, () -> gestor.crearReserva(null));
    }

}