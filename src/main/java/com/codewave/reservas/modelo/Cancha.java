package com.codewave.reservas.modelo;

import java.util.List;

public class Cancha {
    // Atributo id con contador
    private static int contador = 0;
    private int id;
    // Atributos de la cancha
    private String nombre;
    private String tipoDeporte;
    private List<String> horariosDisponibles;

    // Constructor
    public Cancha(String nombre, String tipoDeporte, List<String> horariosDisponibles) {
        this.id = ++contador;
        this.nombre = nombre;
        this.tipoDeporte = tipoDeporte;
        this.horariosDisponibles = horariosDisponibles;
    }

    // Métodos Getters
    public int getId() {
        return id;
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