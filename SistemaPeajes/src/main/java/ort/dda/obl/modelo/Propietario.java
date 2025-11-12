package ort.dda.obl.modelo;

import java.util.ArrayList;

public class Propietario extends Usuario {

    public enum Eventos {
        eliminarNotificaciones
    }

    private double saldoActual;
    private int saldoAlerta;
    private ArrayList<Transito> transitos = new ArrayList<>();
    private ArrayList<Asignacion> asignaciones = new ArrayList<>();
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Notificacion> notificaciones = new ArrayList<>();
    private EstadoPropietario estado = EstadoPropietario.HABILITADO; // por default esta habilitado el estado del
                                                                     // propietario

    public Propietario(String cedula, String password, String nombreCompleto, double saldoActual, int saldoAlerta,
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

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
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

    public void agregarVehiculo(Vehiculo v) throws Exception {
        if (v.getPropietario() != null) {
            throw new Exception("El vehículo ya tiene un propietario registrado.");
        }
        v.setPropietario(this);
        vehiculos.add(v);
    }

    public int getCantidadTransitos() {
        return transitos.size();
    }

    public void borrarNotificaciones() {
        if (this.notificaciones != null) {
            this.notificaciones.clear();
            avisar(Eventos.eliminarNotificaciones);
        } else {
            this.notificaciones = new ArrayList<>();
        }
    }

}
