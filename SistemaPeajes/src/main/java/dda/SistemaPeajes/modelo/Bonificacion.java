package dda.SistemaPeajes.modelo;

public abstract class Bonificacion {
    private String nombre;
 
 

    public abstract void aplicarDescuento();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
