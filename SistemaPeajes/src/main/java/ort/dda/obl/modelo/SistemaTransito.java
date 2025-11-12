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
        double montoBase = tarifa.getMonto();
        // Crear el transito con el monto base (antes de aplicar bonificaciones)
        Transito transito = new Transito(vehiculo, puesto, tarifa);
        // Calcular monto final aplicando las asignaciones/bonificaciones del
        // propietario
        double montoFinal = montoBase;
        if (propietario.getAsignaciones() != null) {
            for (Asignacion a : propietario.getAsignaciones()) {
                try {
                    double pago = a.calcularDescuento(transito); // devuelve el monto a pagar según la bonificación
                    // elegir el menor (mejor descuento)
                    if (pago >= 0 && pago < montoFinal) {
                        montoFinal = pago;
                    }
                } catch (Exception ex) {
                    // ignorar asignaciones mal implementadas
                }
            }
        }

        // Verificar saldo contra el montoFinal
        if (propietario.getSaldoActual() < montoFinal) {
            throw new SistemaTransitoException("Saldo Insuficente");
        }

        // Ajustar monto del tránsito y registrarlo
        transito.setMonto(montoFinal);
        transitos.add(transito);

        if (propietario.getTransitos() == null) {
            propietario.setTransitos(new ArrayList<Transito>());
        }
        propietario.getTransitos().add(transito);
        propietario.setSaldoActual((propietario.getSaldoActual() - montoFinal));
    }

    public ArrayList<PuestoPeaje> getPuestosPeaje() {
        return puestosPeaje;
    }

    public ArrayList<Transito> getTransitos() {
        return transitos;
    }

}
