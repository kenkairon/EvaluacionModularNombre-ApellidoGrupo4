package com.codewave.reservas.servicio;

import com.codewave.reservas.modelo.Reserva;

import java.util.List;

public interface RepositorioReserva {
    void guardar(Reserva reserva);

    boolean estaReservado(String fecha, String hora, String nombreCancha);

    List<Reserva> obtenerReservasPorFecha(String fecha);
}
