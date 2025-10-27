package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

public class SistemaAcceso {
    private ArrayList<UsuarioPropetario> usuariosPropetarios = new ArrayList();
    private ArrayList<Administrador> administradores = new ArrayList();
    private ArrayList<Sesion> sesiones = new ArrayList();

    public void agregarUsuarioPropietario(String cedula, String password, String nombreCompleto) {
        usuariosPropetarios.add(new UsuarioPropetario(cedula, password, nombreCompleto));
    }

    public void agregarAdministrador(String cedula, String password, String nombreCompleto) {
        administradores.add(new Administrador(cedula, password, nombreCompleto));
    }

    public Sesion loginPropetario(String cedula, String password) throws PeajeException {
        Sesion sesion = null;
        UsuarioPropetario user = (UsuarioPropetario) Login(cedula, password, usuariosPropetarios);
        if (user != null) {
            sesion = new Sesion(user);
            sesiones.add(sesion);
            return sesion;
        }
        throw new PeajeException("Usuario o contraseña incorrectos");
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
        return null;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public void logout(Sesion s) {
        sesiones.remove(s);

    }
}
