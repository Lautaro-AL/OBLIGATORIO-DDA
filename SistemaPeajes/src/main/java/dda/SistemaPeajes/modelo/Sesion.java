package dda.SistemaPeajes.modelo;

import java.util.Date;

public class Sesion {
    private Propietario usuario;
    private Date fechaInicio = new Date();

    public Sesion(Propietario usuario) {
        this.usuario = usuario;
    }

    public Propietario getUsuario() {
        return usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
}
