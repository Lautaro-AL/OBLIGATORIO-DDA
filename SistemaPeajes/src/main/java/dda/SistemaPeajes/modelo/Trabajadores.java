package dda.SistemaPeajes.modelo;

import java.sql.Date;
import java.time.DayOfWeek;

public class Trabajadores extends Bonificacion {
 
    public Trabajadores() {
        super("Trabajadores");
    }
    @Override
    public double aplicarDescuento(Transito t) {
        Date dia = t.getFecha();
        DayOfWeek dayOfWeek = dia.toLocalDate().getDayOfWeek();
        if(dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY) {
            return t.getMonto() * 0.8;
        }
        return 0;
    }
    
}
