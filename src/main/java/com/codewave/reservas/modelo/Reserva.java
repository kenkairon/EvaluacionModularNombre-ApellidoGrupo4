package com.codewave.reservas.modelo;

public class Reserva {
    private String usuario;
    private Cancha cancha;
    private String fecha;
    private String hora;

    public Reserva(String usuario, Cancha cancha, String fecha, String hora) {
        this.usuario = usuario;
        this.cancha = cancha;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public Cancha getCancha() {
        return cancha;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }
}