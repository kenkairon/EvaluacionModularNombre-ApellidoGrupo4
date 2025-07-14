package com.codewave.reservas.modelo;

import java.util.List;

public class Cancha {
    private String nombre;
    private String tipoDeporte;
    private List<String> horariosDisponibles;

    public Cancha(String nombre, String tipoDeporte, List<String> horariosDisponibles) {
        this.nombre = nombre;
        this.tipoDeporte = tipoDeporte;
        this.horariosDisponibles = horariosDisponibles;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public List<String> getHorariosDisponibles() {
        return horariosDisponibles;
    }
}