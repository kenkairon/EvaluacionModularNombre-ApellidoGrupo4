package com.codewave.reservas.excepciones; // errores personalizados del sistema.

//  Constructor
public class HorarioOcupadoException extends RuntimeException {
    public HorarioOcupadoException(String mensaje) {
        super(mensaje);
    }
}