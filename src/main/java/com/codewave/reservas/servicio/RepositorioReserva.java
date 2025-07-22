// Paquete donde se encuentra esta interfaz, forma parte de la capa de servicio
package com.codewave.reservas.servicio;

// Se importa la clase Reserva desde el paquete modelo
import com.codewave.reservas.modelo.Reserva;

// Se importa la clase List para manejar listas de objetos
import java.util.List;

// Esta es una interfaz llamada RepositorioReserva
// Su propósito es definir el contrato para gestionar reservas
// Aplica el patrón de diseño llamado "Repositorio"
// Este patrón separa la lógica de acceso a datos del resto de la aplicación
public interface RepositorioReserva {

    // Método para guardar una reserva en el sistema
    // Recibe un objeto de tipo Reserva
    void guardar(Reserva reserva);

    // Método para verificar si una cancha ya está reservada
    // Recibe la fecha, la hora y el nombre de la cancha
    // Devuelve true si está ocupada, false si está libre
    boolean estaReservado(String fecha, String hora, String nombreCancha);

    // Método para obtener todas las reservas de una fecha específica
    // Recibe una fecha como String y devuelve una lista de reservas
    List<Reserva> obtenerReservasPorFecha(String fecha);
}
