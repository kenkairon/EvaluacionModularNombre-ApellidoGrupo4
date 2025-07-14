package com.codewave.reservas.excepciones;

public class HorarioOcupadoException extends RuntimeException {
    public HorarioOcupadoException(String mensaje) {
        super(mensaje);
    }
}