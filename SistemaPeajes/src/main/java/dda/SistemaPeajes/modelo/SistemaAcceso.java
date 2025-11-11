package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

import dda.SistemaPeajes.UsuarioException;

public class SistemaAcceso {
    private ArrayList<Propietario> propietarios = new ArrayList<>();
    private ArrayList<Administrador> administradores = new ArrayList();

    public void agregarUsuarioPropietario(String cedula, String password, String nombreCompleto, int saldoActual,
            int saldoAlerta) {
        propietarios.add(new Propietario(cedula, password, nombreCompleto, saldoActual, saldoAlerta,
                new ArrayList<Transito>(), new ArrayList<Vehiculo>(), new ArrayList<Notificacion>()));
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        administradores.add(new Administrador(cedula, password, nombreCompleto));
    }

    public ArrayList<Propietario> getPropietarios() {
        return propietarios;
    }

    public Propietario loginPropetario(String cedula, String password) throws UsuarioException {
        Propietario user = (Propietario) Login(cedula, password, propietarios);
        return user;
    }

    public Administrador loginAdministrador(String cedula, String password) throws UsuarioException {
        Administrador admin = (Administrador) Login(cedula, password, administradores);
        if (admin == null)
            throw new UsuarioException("Login incorrecto");
        return admin;
    }

    private Usuario Login(String cedula, String password, ArrayList lista) throws UsuarioException {
        Usuario usuario;
        for (Object u : lista) {
            usuario = (Usuario) u;
            if (usuario.getCedula().equals(cedula) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        throw new UsuarioException("Usuario o contraseña incorrectos");
    }

    public void logout(Administrador s) {
        administradores.remove(s);

    }
}
