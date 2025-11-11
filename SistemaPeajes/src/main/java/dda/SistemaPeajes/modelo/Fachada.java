package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

import dda.SistemaPeajes.UsuarioException;

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

    public ArrayList<Propietario> obtenerPropietarios() {
        return sAcceso.getPropietarios();
    }

    public Propietario loginPropetario(String cedula, String password) throws UsuarioException {
        return sAcceso.loginPropetario(cedula, password);
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        sAcceso.agregarAdministrador(cedula, password, nombreCompleto);
    }

    public Administrador loginAdministrador(String cedula, String password) throws UsuarioException {
        return sAcceso.loginAdministrador(cedula, password);
    }

    public void logout(Administrador s) {
        sAcceso.logout(s);
    }

    // DELEGACIONES SISTEMA TRANSITO
    public void agregarPuesto(String nombre, String direccion) {
        sTransito.agregarPuesto(nombre, direccion);
    }

    public ArrayList<PuestoPeaje> getPuestosPeaje() {
        return sTransito.getPuestosPeaje();
    }

    public void registrarTransito(Vehiculo vehiculo, PuestoPeaje puesto, Tarifa tarifa, Propietario propietario) {
        try {
            sTransito.registrarTransito(vehiculo, puesto, tarifa, propietario);
        } catch (Exception e) {
            System.err.println("Error al registrar tránsito: " + e.getMessage());
        }
    }

    // DELEGACIONES SISTEMA VEHICULOS
    public void agregarCategoria(String tipo) {
        sVehiculos.agregarCategoria(tipo);
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return sVehiculos.getVehiculos();
    }

    public void agregarTarifa(double monto, Categoria categoria) {
        sVehiculos.agregarTarifas(monto, categoria);
    }

    public void agregarVehiculo(String matricula, String modelo, String color, Categoria categoria,
            Propietario propietario) {
        sVehiculos.agregarVehiculo(matricula, modelo, color, categoria, propietario);
    }

    public ArrayList<Categoria> getCategorias() {
        return sVehiculos.getCategorias();
    }

    public ArrayList<Tarifa> getTarifas() {
        return sVehiculos.getTarifas();
    }

}
