package ort.dda.obl.dto;

import java.util.Date;

import ort.dda.obl.modelo.Transito;

public class TransitoDTO {
    private Date fecha;
    private String vehiculoMat;
    private String puestoPeajeNombre;
    private String categoria;
    private double tarifaMonto;
    private double monto;

    public TransitoDTO(Transito t) {
        this.fecha = t.getFecha();
        this.monto = t.getMonto();
        this.vehiculoMat = t.getVehiculo().getMatricula();
        this.puestoPeajeNombre = t.getPuestoPeaje().getNombre();
        this.categoria = t.getVehiculo().getCategoria().getTipo();
        this.tarifaMonto = t.getTarifa().getMonto();
    }

    public Date getFecha() {
        return fecha;
    }

    public String getVehiculoMat() {
        return vehiculoMat;
    }

    public String getPuestoPeajeNombre() {
        return puestoPeajeNombre;
    }

    public double getTarifaMonto() {
        return tarifaMonto;
    }

    public double getMonto() {
        return monto;
    }

}
