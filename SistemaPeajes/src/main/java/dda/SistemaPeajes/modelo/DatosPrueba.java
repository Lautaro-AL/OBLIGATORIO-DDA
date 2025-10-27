package dda.SistemaPeajes.modelo;

public class DatosPrueba {

    public static void cargarDatos() {
        Fachada fachada = Fachada.getInstancia();

        // Administradores
        fachada.agregarAdministrador("admin1", "Admin123!", "Juan Pérez");
        fachada.agregarAdministrador("admin2", "Admin456!", "María González");

        // Propietarios
        fachada.agregarUsuarioPropietario("prop1", "Prop123!", "Carlos López");
        fachada.agregarUsuarioPropietario("prop2", "Prop456!", "Ana Martínez");

        // Casos especiales para testing
        fachada.agregarAdministrador("test", "", "Usuario Test Vacío"); // Contraseña vacía
        fachada.agregarUsuarioPropietario("user123", "pass", "Usuario Contraseña Corta"); // Contraseña simple

    }
}
