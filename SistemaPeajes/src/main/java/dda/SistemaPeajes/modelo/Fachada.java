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
    public void agregarUsuarioPropietario(String cedula, String pwd, String nombreCompleto, int saldoActual,
            int saldoAlerta) {
        sAcceso.agregarUsuarioPropietario(cedula, pwd, nombreCompleto, saldoActual, saldoAlerta);
    }

    public ArrayList<Propietario> obtenerprop() {
        return sAcceso.getPropietarios();
    }

    public Propietario loginPropetario(String cedula, String password) throws PeajeException {
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

    // DELEGACIONES SISTEMA TRANSITO
    public void agregarPuesto(String nombre, String direccion) {
        sTransito.agregarPuesto(nombre, direccion);
    }

    public ArrayList<PuestoPeaje> getPuestosPeaje() {
        return sTransito.getPuestosPeaje();
    }

    // DELEGACIONES SISTEMA VEHICULOS
    public void agregarCategoria(String tipo) {
        sVehiculos.agregarCategoria(tipo);
    }

    public void agregarTarifa(double monto, Categoria categoria) {
        sVehiculos.agregarTarifas(monto, categoria);
    }

    public void agregarVehiculo(String matricula, String modelo, String color, Categoria categoria) {
        sVehiculos.agregarVehiculo(matricula, modelo, color, categoria);
    }

    public ArrayList<Categoria> getCategorias() {
        return sVehiculos.getCategorias();
    }

    public ArrayList<Tarifa> getTarifas() {
        return sVehiculos.getTarifas();
    }

}
