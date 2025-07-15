package com.codewave.reservas.servicio;

import com.codewave.reservas.modelo.Reserva;

import java.util.List;

// Es una interface llamada Repositorio de Reserva es fundamental para el patrón de diseño llamado Repositorio
public interface RepositorioReserva {
    void guardar(Reserva reserva); // Métodos Guardar Reservas
    // Verifica si ya esta reservada

    boolean estaReservado(String fecha, String hora, String nombreCancha);

    // Obtener las reservas por fecha
    List<Reserva> obtenerReservasPorFecha(String fecha);
}
