package ort.dda.obl.dto;

import java.util.Date;

import ort.dda.obl.modelo.Asignacion;

public class AsignacionDTO {
    private String bonificacion;
    private String puesto;
    private Date fechaAsignada;

    public AsignacionDTO(Asignacion a) {
        bonificacion = a.getBonificacion().getNombre();
        puesto = a.getPuesto().getNombre();
        fechaAsignada = a.getFechaAsignada();
    }

    public String getBonificacion() {
        return bonificacion;
    }

    public String getPuesto() {
        return puesto;
    }

    public Date getFechaAsignada() {
        return fechaAsignada;
    }

}
