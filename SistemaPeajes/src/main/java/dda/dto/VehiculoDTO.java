package dda.dto;

import dda.SistemaPeajes.modelo.Vehiculo;

public class VehiculoDTO {
    private String matricula;
    private String modelo;
    private String color;
    private String tipoCategoria;

    public VehiculoDTO(Vehiculo v) {
        this.matricula = v.getMatricula();
        this.modelo = v.getModelo();
        this.color = v.getColor();
        this.tipoCategoria = v.getCategoria().getTipo();
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
        return tipoCategoria;
    }
}
