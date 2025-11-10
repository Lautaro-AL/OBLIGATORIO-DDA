package dda.dto;

import dda.SistemaPeajes.modelo.Asignacion;
import dda.SistemaPeajes.modelo.Notificacion;
import dda.SistemaPeajes.modelo.Transito;
import dda.SistemaPeajes.modelo.Vehiculo;
import java.util.ArrayList;

public class TableroDTO {
    private String nombre;
    private String estado;
    private double saldo;
    private ArrayList<Asignacion> bonificaciones;
    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Transito> transitos;
    private ArrayList<Notificacion> notificaciones;

    public ArrayList<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Asignacion> getBonificaciones() {
        return bonificaciones;
    }

    public void setBonificaciones(ArrayList<Asignacion> bonificaciones) {
        this.bonificaciones = bonificaciones;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public ArrayList<Transito> getTransitos() {
        return transitos;
    }

    public void setTransitos(ArrayList<Transito> transitos) {
        this.transitos = transitos;
    }
}