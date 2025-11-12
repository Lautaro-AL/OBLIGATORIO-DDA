package ort.dda.obl.dto;

import ort.dda.obl.modelo.Vehiculo;

public class VehiculoDTO {
    private String matricula;
    private String modelo;
    private String color;
    private String tipoCategoria;
    private int cantTransitos;
    private double montoTotal;

    public VehiculoDTO(Vehiculo v) {
        this.matricula = v.getMatricula();
        this.modelo = v.getModelo();
        this.color = v.getColor();
        this.tipoCategoria = v.getCategoria().getTipo();
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

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public int getCantTransitos() {
        return cantTransitos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }
}
