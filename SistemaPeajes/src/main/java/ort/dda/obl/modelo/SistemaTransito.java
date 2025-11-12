package ort.dda.obl.modelo;

import java.util.ArrayList;

import ort.dda.obl.SistemaTransitoException;

public class SistemaTransito {
    private ArrayList<PuestoPeaje> puestosPeaje = new ArrayList<PuestoPeaje>();
    private ArrayList<Bonificacion> bonificaciones = new ArrayList<Bonificacion>();
    private ArrayList<Transito> transitos = new ArrayList<Transito>();

    public void agregarPuesto(String nombre, String direccion) {
        puestosPeaje.add(new PuestoPeaje(nombre, direccion));
    }

    public void registrarTransito(Vehiculo vehiculo, PuestoPeaje puesto, Tarifa tarifa, Propietario propietario)
            throws SistemaTransitoException {
        if (vehiculo == null || puesto == null || tarifa == null || propietario == null) {
            throw new SistemaTransitoException("Error - Campos nulos");
        }
        double monto = tarifa.getMonto();

        if (propietario.getSaldoActual() < monto) {
            throw new SistemaTransitoException("Saldo Insuficente");
        }

        Transito transito = new Transito(vehiculo, puesto, tarifa);
        transitos.add(transito);

        if (propietario.getTransitos() == null) {
            propietario.setTransitos(new ArrayList<Transito>());
        }
        propietario.getTransitos().add(transito);
        propietario.setSaldoActual((propietario.getSaldoActual() - monto));
    }

    // public void agregarBonificacion(String nombre) {
    // bonificaciones.add(new Bonificacion(nombre));
    // }

    public ArrayList<PuestoPeaje> getPuestosPeaje() {
        return puestosPeaje;
    }

    public ArrayList<Transito> getTransitos() {
        return transitos;
    }

}
