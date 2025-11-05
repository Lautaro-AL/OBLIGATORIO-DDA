package dda.SistemaPeajes.modelo;

import java.util.ArrayList;
import java.util.List;

public class Propietarios {
    private int saldoActual;
    private int saldoAlerta;
    private ArrayList<Transito> transitos;

    public Propietarios(int saldoActual, int saldoAlerta, ArrayList<Transito> transitos) {
        this.saldoActual = saldoActual;
        this.saldoAlerta = saldoAlerta;
        this.transitos = transitos;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }

    public List<Transito> getTransitos() {
        return transitos;
    }

    public void setTransitos(ArrayList<Transito> transitos) {
        this.transitos = transitos;
    }

    public int getSaldoAlerta() {
        return saldoAlerta;
    }

    public void setSaldoAlerta(int saldoAlerta) {
        this.saldoAlerta = saldoAlerta;
    }

}
