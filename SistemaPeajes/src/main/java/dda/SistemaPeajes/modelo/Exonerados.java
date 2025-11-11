package dda.SistemaPeajes.modelo;

public class Exonerados extends Bonificacion {

    public Exonerados() {
        super("Exonerados");
    }

    @Override
    public double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado) {
        if (!transito.getPuestoPeaje().getNombre().equals(puestoAsignado.getNombre())) { // verifica el puesto (por
                                                                                         // nombre, despues ver si se
                                                                                         // compara con eso)
            return transito.getMonto();
        }
        return 0; // Exonerados: No pagan el tránsito en un determinado puesto.
    }
}
