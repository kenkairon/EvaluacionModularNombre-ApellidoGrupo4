````java
package com.codewave.reservas.servicio;

import com.codewave.reservas.modelo.Reserva;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioReservaImpl implements RepositorioReserva {

    private List<Reserva> reservas = new ArrayList<>();

    @Override
    public void guardar(Reserva reserva) {
        reservas.add(reserva);
    }

    @Override
    public boolean estaReservado(String fecha, String hora, String nombreCancha) {
        return reservas.stream().anyMatch(r -> r.getFecha().equals(fecha) &&
                r.getHora().equals(hora) &&
                r.getCancha().getNombre().equals(nombreCancha));
    }

    @Override
    public List<Reserva> obtenerReservasPorFecha(String fecha) {
        return reservas.stream()
                .filter(r -> r.getFecha().equals(fecha))
                .collect(Collectors.toList());
    }
}
