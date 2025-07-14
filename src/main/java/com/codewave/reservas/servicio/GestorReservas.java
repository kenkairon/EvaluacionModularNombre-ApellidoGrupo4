// =============================
// 📁 servicio/GestorReservas.java
// =============================
// package com.codewave.reservas.servicio;

// import com.codewave.reservas.modelo.Reserva;
// import com.codewave.reservas.excepciones.HorarioOcupadoException;

// import java.util.List;

// public class GestorReservas {
//     private RepositorioReserva repositorio;

//     public GestorReservas(RepositorioReserva repositorio) {
//         this.repositorio = repositorio;
//     }

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

// public int contarReservasPorDia(String fecha) {
// List<Reserva> reservas = repositorio.obtenerReservasPorFecha(fecha);
// return reservas.size();
// }
// }
