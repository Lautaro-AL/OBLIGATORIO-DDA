package dda.SistemaPeajes.modelo;

import java.util.Date;

public class Notificacion {
    private Date fechaHora = new Date();
    private String mensaje;

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }
}