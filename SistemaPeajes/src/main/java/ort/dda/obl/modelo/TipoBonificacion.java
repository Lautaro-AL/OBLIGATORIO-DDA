package ort.dda.obl.modelo;

public abstract class TipoBonificacion {
    private String nombre;

    public TipoBonificacion(String nombre) {
        this.nombre = nombre;
    }

    public abstract double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado, Propietario propietario); 
                                                                                            

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
