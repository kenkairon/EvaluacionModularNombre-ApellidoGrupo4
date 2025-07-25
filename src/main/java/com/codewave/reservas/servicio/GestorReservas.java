// =============================
// servicio/GestorReservas.java
// =============================
package com.codewave.reservas.servicio;

import com.codewave.reservas.modelo.Reserva;
import com.codewave.reservas.excepciones.HorarioOcupadoException;

import java.util.List;

public class GestorReservas {
    private RepositorioReserva repositorio; // Atributo principal
    // El constructor permite inyectar (pasar desde fuera) el repositorio. Esto es
    // útil para prueba

    public GestorReservas(RepositorioReserva repositorio) {
        this.repositorio = repositorio;
    }

    // Método crearReserva()
    public void crearReserva(Reserva reserva) {
        boolean ocupado = repositorio.estaReservado(
                reserva.getFecha(),
                reserva.getHora(),
                reserva.getCancha().getNombre());
        if (ocupado) {
            throw new HorarioOcupadoException("La cancha ya está reservada en ese horario.");
        }
        repositorio.guardar(reserva);
    }

    // Método contarReservasPorDia()
    public int contarReservasPorDia(String fecha) {
        // Consulta al repositorio todas las reservas de una fecha específica.
        List<Reserva> reservas = repositorio.obtenerReservasPorFecha(fecha);
        return reservas.size(); // Devuelve el número total de reservas encontradas
    }
}
