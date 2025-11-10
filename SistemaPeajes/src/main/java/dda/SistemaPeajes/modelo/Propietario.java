package dda.SistemaPeajes.modelo;

import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario {
    private int saldoActual;
    private int saldoAlerta;
    private ArrayList<Transito> transitos;
    private ArrayList<Asignacion> asignaciones;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Notificacion> notificaciones;
    private EstadoPropietario estado = EstadoPropietario.HABILITADO; // por default esta habilitado el estado del
                                                                     // propietario

    public Propietario(String cedula, String password, String nombreCompleto, int saldoActual, int saldoAlerta,
            ArrayList<Transito> transitos, ArrayList<Vehiculo> vehiculos, ArrayList<Notificacion> notificaciones) {
        super(cedula, password, nombreCompleto);
        this.saldoActual = saldoActual;
        this.saldoAlerta = saldoAlerta;
        this.transitos = transitos;
        this.vehiculos = vehiculos;
        this.notificaciones = notificaciones;
    }

    public EstadoPropietario getEstado() {
        return estado;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void setEstado(EstadoPropietario estado) {
        this.estado = estado;
    }

    public boolean puedeIngresar() {
        return estado.puedeIngresar();
    }

    public boolean puedeTransitar() {
        return estado.puedeTransitar();
    }

    public boolean puedeRecibirBonificaciones() {
        return estado.puedeRecibirBonificaciones();
    }

    public boolean recibeNotificaciones() {
        return estado.recibeNotificaciones();
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }

    public ArrayList<Transito> getTransitos() {
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

    public ArrayList<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(ArrayList<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

}
