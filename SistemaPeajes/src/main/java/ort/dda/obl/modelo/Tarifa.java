package ort.dda.obl.modelo;

public class Tarifa {
    private double monto;
    private Categoria categoria;

    
    public Tarifa(double monto, Categoria categoria) {
        this.monto = monto;
        this.categoria = categoria;
    }
    
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
}
