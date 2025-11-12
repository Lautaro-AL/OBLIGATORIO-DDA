package ort.dda.obl.modelo;

import java.util.Calendar;
import java.util.Date;

public class Trabajadores extends Bonificacion {

    public Trabajadores() {
        super("Trabajadores");
    }

    @Override
    public double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado) {
        if (!transito.getPuestoPeaje().getNombre().equals(puestoAsignado.getNombre())) { // verifica el puesto (por
                                                                                         // nombre, despues ver si se
                                                                                         // compara con eso)
            return transito.getMonto();
        }

        Date fecha = transito.getFecha();
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int diaSemana = cal.get(Calendar.DAY_OF_WEEK);

        if (diaSemana >= 2 && diaSemana <= 6) {// entre lunes y viernes
            return transito.getMonto() * 0.2;
        }

        return transito.getMonto();
    }
}
