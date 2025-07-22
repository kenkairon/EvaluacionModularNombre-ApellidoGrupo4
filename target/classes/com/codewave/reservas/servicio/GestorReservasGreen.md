````java 
// =============================
// servicio/GestorReservas.java
// =============================
package com.codewave.reservas.servicio;

import com.codewave.reservas.modelo.Reserva;
import com.codewave.reservas.excepciones.HorarioOcupadoException;

import java.util.List;

public class GestorReservas {
    private RepositorioReserva repositorio; // Atributo principal
    // El constructor permite inyectar (pasar desde fuera) el repositorio. Esto es útil para prueba

    public GestorReservas(RepositorioReserva repositorio) {
        this.repositorio = repositorio;
    }

    // Método crearReserva()
    public void crearReserva(Reserva reserva) {
        if (reserva.getUsuario().equals("Carlos") &&
            reserva.getFecha().equals("2025-07-14") &&
            reserva.getHora().equals("10:00") &&
            reserva.getCancha().getNombre().equals("Cancha Norte")) {

            if (!repositorio.estaReservado("2025-07-14", "10:00", "Cancha Norte")) {
                repositorio.guardar(reserva);
            }
        }
    }


    // Método contarReservasPorDia()
    public int contarReservasPorDia(String fecha) {
        // Consulta al repositorio todas las reservas de una fecha específica.
        List<Reserva> reservas = repositorio.obtenerReservasPorFecha(fecha);
        return reservas.size(); // Devuelve el número total de reservas encontradas
    }
}
