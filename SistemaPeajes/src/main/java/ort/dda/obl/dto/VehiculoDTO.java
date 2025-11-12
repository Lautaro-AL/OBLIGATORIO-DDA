package ort.dda.obl.dto;

import ort.dda.obl.modelo.Vehiculo;

public class VehiculoDTO {
    private String matricula;
    private String modelo;
    private String color;
    private String categoria;
    private int cantTransitos;
    private double montoTotal;

    public VehiculoDTO(Vehiculo v) {
        this.matricula = v.getMatricula();
        this.modelo = v.getModelo();
        this.color = v.getColor();
        this.categoria = v.getCategoria() != null ? v.getCategoria().getTipo() : "Sin categoría";
        this.cantTransitos = v.getPropietario().getCantidadTransitos();
        this.montoTotal = 0; // hacer luego monto total de esos transitos
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantTransitos() {
        return cantTransitos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
