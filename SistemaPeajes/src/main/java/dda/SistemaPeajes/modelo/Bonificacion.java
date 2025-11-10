package dda.SistemaPeajes.modelo;

public abstract class Bonificacion {
    private String nombre;
    
    public Bonificacion(String nombre) {
        this.nombre = nombre;
    }
 
    public abstract double aplicarDescuento(Transito transito);

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
}
