package dda.SistemaPeajes.modelo;

import java.util.Date;

public class Frecuentes extends Bonificacion {

    public Frecuentes() {
        super("Frecuentes");
    }

    // @Override
    // public double calcularDescuento(Transito t) {
    // Propietario propietario = t.get();
    // PuestoPeaje puesto = t.getPuestoPeaje();
    // Vehiculo vehiculo = t.getVehiculo();
    // Date hoy = t.getFecha();

    // int cantidadHoy = 0;
    // for (Transito tr : propietario.getTransitos()) {
    // if (tr.getVehiculo().equals(vehiculo) &&
    // tr.getPuestoPeaje().equals(puesto) &&
    // tr.getFe().toLocalDate().equals(hoy)) {
    // cantidadHoy++;
    // }
    // }

    // // Si ya tuvo al menos un tránsito hoy → este sería el segundo o más
    // if (cantidadHoy >= 1) {
    // return t.getMonto() * 0.5;
    // }

    // return 0;
    // }

    @Override
    public double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado) {
        throw new UnsupportedOperationException("Unimplemented method 'aplicarDescuento'");
    }

}
