package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

import dda.SistemaPeajes.UsuarioException;

public class SistemaAcceso {
    private ArrayList<Propietario> propietarios = new ArrayList<>();
    private ArrayList<Administrador> administradores = new ArrayList();
    private ArrayList<Sesion> sesiones = new ArrayList();

    public void agregarUsuarioPropietario(String cedula, String password, String nombreCompleto, int saldoActual,
            int saldoAlerta) {
        propietarios.add(new Propietario(cedula, password, nombreCompleto, saldoActual, saldoAlerta, null, null, null));
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        administradores.add(new Administrador(cedula, password, nombreCompleto));
    }

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public Propietario loginPropetario(String cedula, String password) throws PeajeException {
        Propietario user = (Propietario) Login(cedula, password, propietarios);
        return user;
    }

    public Administrador loginAdministrador(String cedula, String password) throws PeajeException {
        Administrador admin = (Administrador) Login(cedula, password, administradores);
        if (admin == null)
            throw new PeajeException("Login incorrecto");
        return admin;
    }

    private Usuario Login(String cedula, String password, ArrayList lista) {
        Usuario usuario;
        for (Object u : lista) {
            usuario = (Usuario) u;
            if (usuario.getCedula().equals(cedula) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        throw new UsuarioException("Usuario o contraseña incorrectos");
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void logout(Sesion s) {
        sesiones.remove(s);

    }
}
