// Paquete que agrupa todas las excepciones personalizadas del sistema
package com.codewave.reservas.excepciones;

// Clase que define una excepción personalizada llamada HorarioOcupadoException
// Hereda de RuntimeException, lo que la convierte en una excepción no comprobada (unchecked)
public class HorarioOcupadoException extends RuntimeException {

    // Constructor que recibe un mensaje personalizado como argumento
    public HorarioOcupadoException(String mensaje) {
        // Llama al constructor de la clase padre (RuntimeException) y le pasa el
        // mensaje
        super(mensaje);
    }
}
