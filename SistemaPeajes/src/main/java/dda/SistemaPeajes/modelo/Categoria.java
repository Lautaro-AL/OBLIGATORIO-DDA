package dda.SistemaPeajes.modelo;

import java.util.ArrayList;


public class Categoria {
    private String tipo;
    private ArrayList<Tarifa> tarifas;

    public Categoria(String tipo, ArrayList<Tarifa> tarifas) {
        this.tipo = tipo;
        this.tarifas = tarifas;
    }
    
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }
    public void setTarifas(ArrayList<Tarifa> tarifas) {
        this.tarifas = tarifas;
    }
}
