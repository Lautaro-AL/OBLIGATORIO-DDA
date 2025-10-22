package dda.SistemaPeajes.modelo;

public class Propietarios extends Usuario{
    private int saldoActual;
    private int saldoAlerta;
    
    public Propietarios(String cedula, String password, String nombreCompleto, int saldoActual, int saldoAlerta) {
        super(cedula, password, nombreCompleto);
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
