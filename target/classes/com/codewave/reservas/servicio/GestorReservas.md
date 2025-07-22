````java
package com.codewave.reservas.servicio;

import com.codewave.reservas.excepciones.HorarioOcupadoException;
import com.codewave.reservas.modelo.Reserva;

import java.util.Objects;

public class GestorReservas {
    private RepositorioReserva repositorio;

    public GestorReservas(RepositorioReserva repositorio) {
        this.repositorio = repositorio;
    }

    public void crearReserva(Reserva reserva) {
        Objects.requireNonNull(reserva, "La reserva no puede ser nula");
        boolean ocupado = repositorio.estaReservado(
                reserva.getFecha(),
                reserva.getHora(),
                reserva.getCancha().getNombre()
        );
        if (ocupado) {
            throw new HorarioOcupadoException("El horario ya está reservado.");
        }
        repositorio.guardar(reserva);
    }

    public int contarReservasPorDia(String fecha) {
        return repositorio.obtenerReservasPorFecha(fecha).size();
    }
}
