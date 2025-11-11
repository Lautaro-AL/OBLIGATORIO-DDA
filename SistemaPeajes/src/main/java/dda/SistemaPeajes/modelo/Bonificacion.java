package dda.SistemaPeajes.modelo;

public abstract class Bonificacion {
    private String nombre;

    public Bonificacion(String nombre) {
        this.nombre = nombre;
    }

    public abstract double aplicarDescuento(Transito transito, PuestoPeaje puestoAsignado); // tiene un puesto asignado
                                                                                            // ej: Trabajadores: Tienen
                                                                                            // un 80% de descuento si el
                                                                                            // tránsito por el !puesto
                                                                                            // asignado! se realiza en
                                                                                            // un día de semana.

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
