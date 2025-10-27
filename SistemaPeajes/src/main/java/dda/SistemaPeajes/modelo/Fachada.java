package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

public class Fachada {
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaTransito sTransito = new SistemaTransito();
    private SistemaVehiculos sVehiculos = new SistemaVehiculos();

    // SINGLETON
    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    private Fachada() {
    }

    // DELEGACIONES SISTEMA ACCESO
    public void agregarUsuarioPropietario(String cedula, String pwd, String nombreCompleto) {
        sAcceso.agregarUsuarioPropietario(cedula, pwd, nombreCompleto);
    }

    public Sesion loginPropetario(String cedula, String password) throws PeajeException {
        return sAcceso.loginPropetario(cedula, password);
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        sAcceso.agregarAdministrador(cedula, password, nombreCompleto);
    }

    public Administrador loginAdministrador(String cedula, String password) throws PeajeException {
        return sAcceso.loginAdministrador(cedula, password);
    }

    public ArrayList<Sesion> getSesiones() {
        return sAcceso.getSesiones();
    }

    public void logout(Sesion s) {
        sAcceso.logout(s);
    }

}
