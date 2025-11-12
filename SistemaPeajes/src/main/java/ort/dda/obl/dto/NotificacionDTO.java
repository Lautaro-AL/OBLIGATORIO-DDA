package ort.dda.obl.dto;

import java.util.Date;

import ort.dda.obl.modelo.Notificacion;

public class NotificacionDTO {
    private Date fechaHora;
    private String mensaje;

    public NotificacionDTO(Notificacion n) {
        fechaHora = n.getFechaHora();
        mensaje = n.getMensaje();
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

}
