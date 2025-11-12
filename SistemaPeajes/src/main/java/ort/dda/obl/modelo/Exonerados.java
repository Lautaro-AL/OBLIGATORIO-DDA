package ort.dda.obl.modelo;
public class Exonerados extends Bonificacion {

    public Exonerados() {
        super("Exonerados");
    }

    @Override
    public double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado, Propietario propietario) {
        if (!transito.getPuestoPeaje().getNombre().equals(puestoAsignado.getNombre())) { 
            return transito.getMonto();
        }
        return 0; // Exonerados: No pagan el tránsito en un determinado puesto.
    }
}
