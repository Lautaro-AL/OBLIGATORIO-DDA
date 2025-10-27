package dda.SistemaPeajes.modelo;

import java.util.Date;

public class Sesion {
    private UsuarioPropetario usuario;
    private Date fechaInicio = new Date();

    public Sesion(UsuarioPropetario usuario) {
        this.usuario = usuario;
    }

    public UsuarioPropetario getUsuario() {
        return usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
}
