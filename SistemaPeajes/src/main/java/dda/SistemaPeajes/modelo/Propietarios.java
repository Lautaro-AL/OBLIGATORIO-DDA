package dda.SistemaPeajes.modelo;

public class Propietarios {
    private int saldoActual;
    private int saldoAlerta;

    public Propietarios(int saldoActual, int saldoAlerta) {
        this.saldoActual = saldoActual;
        this.saldoAlerta = saldoAlerta;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }

    public int getSaldoAlerta() {
        return saldoAlerta;
    }

    public void setSaldoAlerta(int saldoAlerta) {
        this.saldoAlerta = saldoAlerta;
    }

}
