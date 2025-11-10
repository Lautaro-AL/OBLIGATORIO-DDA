package dda.SistemaPeajes.modelo;

public enum EstadoPropietario {
    HABILITADO("Habilitado"),
    DESHABILITADO("Deshabilitado"),
    SUSPENDIDO("Suspendido"),
    PENALIZADO("Penalizado");

    private String nombre;

    EstadoPropietario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    // Métodos de comportamiento de los estados
    public boolean puedeIngresar() {
        return this != DESHABILITADO;
    }

    public boolean puedeTransitar() {
        return this == HABILITADO || this == PENALIZADO;
    }

    public boolean puedeRecibirBonificaciones() {
        return this == HABILITADO;
    }

    public boolean recibeNotificaciones() {
        return this != PENALIZADO;
    }
}
