package dda.SistemaPeajes.modelo;

import java.sql.Date;

public class Transito {
    private Date fecha;
    private Vehiculo vehiculo;
    private PuestoPeaje puestoPeaje;

    
    public Transito(Date fecha, Vehiculo vehiculo, PuestoPeaje puestoPeaje) {
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.puestoPeaje = puestoPeaje;
    }
    
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public PuestoPeaje getPuestoPeaje() {
        return puestoPeaje;
    }
    public void setPuestoPeaje(PuestoPeaje puestoPeaje) {
        this.puestoPeaje = puestoPeaje;
    }
    
}
