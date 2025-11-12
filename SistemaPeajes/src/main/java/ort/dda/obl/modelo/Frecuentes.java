package ort.dda.obl.modelo;

import java.util.Date;

public class Frecuentes extends Bonificacion {

    public Frecuentes() {
        super("Frecuentes");
    }

    @Override
    public double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado, Propietario propietario) {
        // Verificar que el tránsito sea por el puesto asignado
        if (!transito.getPuestoPeaje().getNombre().equals(puestoAsignado.getNombre())) {
            return transito.getMonto(); // Sin descuento si no es el puesto asignado
        }

        Date fechaHoy = transito.getFecha();
        
        // Contar cuántos tránsitos con el mismo vehículo y puesto son de hoy
        int transitosHoy = 0;
        for (Transito tr : propietario.getTransitos()) {
            // Verificar que sea el mismo vehículo y el mismo puesto
            if (tr.getVehiculo().equals(transito.getVehiculo()) &&
                tr.getPuestoPeaje().equals(puestoAsignado)) {
                
                // Comparar si es el mismo día 
                if (fechaHoy.toString().equals(tr.getFecha().toString())) {
                    transitosHoy++;
                }
            }
        }

        // Si ya hubo al menos un tránsito hoy → este sería el segundo transito o mas
        // Aplicar 50% de descuento
        if (transitosHoy >= 1) {
            return transito.getMonto() * 0.5;
        }

        // si es el primer tránsito del día → no hay descuento
        return transito.getMonto();
    }

}
