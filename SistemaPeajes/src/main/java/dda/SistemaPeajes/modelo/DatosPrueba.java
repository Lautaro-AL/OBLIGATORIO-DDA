package dda.SistemaPeajes.modelo;

public class DatosPrueba {

    public static void cargarDatos() {
        Fachada fachada = Fachada.getInstancia();

        // Administradores
        fachada.agregarAdministrador("a", "a", "Juan Pérez");
        fachada.agregarAdministrador("a2", "a2", "María González");

        // Propietarios
        fachada.agregarUsuarioPropietario("b", "b", "Carlos López");
        fachada.agregarUsuarioPropietario("c", "c", "Ana Martínez");

        // Casos especiales para testing
        fachada.agregarAdministrador("test", "", "Usuario Test Vacío"); // Contraseña vacía
        fachada.agregarUsuarioPropietario("user123", "pass", "Usuario Contraseña Corta"); // Contraseña simple

    }
}
