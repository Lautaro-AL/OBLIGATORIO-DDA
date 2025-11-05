package dda.SistemaPeajes.modelo;

public class PuestoPeaje {
    private String nombre;
    private String direccion;
    
    public PuestoPeaje(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

