package dda.SistemaPeajes.modelo;

import java.sql.Date;

public class Asignacion {
    private Date fecha;

    public Asignacion(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
