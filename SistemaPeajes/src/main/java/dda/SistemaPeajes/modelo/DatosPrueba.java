package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

public class DatosPrueba {

    public static void cargarDatos() {
        Fachada fachada = Fachada.getInstancia();

        // ==========================
        // 1) ADMINISTRADORES (aprox. 5)
        // campos: cédula, contraseña, nombre completo
        // ==========================
        fachada.agregarAdministrador("a", "a", "Juan Pérez");
        fachada.agregarAdministrador("a2", "a2", "María González");
        // entrada sugerida en el enunciado
        fachada.agregarAdministrador("12345678", "admin.123", "Usuario Administrador");
        // adicionales para pruebas
        fachada.agregarAdministrador("87654321", "pass001", "Luis Fernández");
        fachada.agregarAdministrador("11223344", "adm!n", "Sofía Ramírez");

        // ==========================
        // 2) PROPIETARIOS (aprox. 5)
        // campos: cédula, contraseña, nombre completo, saldo actual, saldo mínimo
        // alerta
        // ==========================
        fachada.agregarUsuarioPropietario("b", "b", "Carlos López", 200, 500);
        fachada.agregarUsuarioPropietario("c", "c", "Ana Martínez", 0, 0);
        // entrada sugerida en el enunciado
        fachada.agregarUsuarioPropietario("23456789", "prop.123", "Usuario Propietario", 2000, 500);
        // adicionales para pruebas
        fachada.agregarUsuarioPropietario("34567890", "clave01", "Marcos Varela", 1500, 300);
        fachada.agregarUsuarioPropietario("98765432", "clave02", "Lucía Duarte", 50, 100);

        // ==========================
        // 3) PUESTOS DE PEAJE (aprox. 5)
        // campos: nombre, direccion
        // ==========================
        fachada.agregarPuesto("Puesto Centro", "Av. Principal 123");
        fachada.agregarPuesto("Puesto Norte", "Ruta 5 km 12");
        fachada.agregarPuesto("Puesto Sur", "Ruta 1 km 45");
        fachada.agregarPuesto("Puesto Este", "Camino Real 200");
        fachada.agregarPuesto("Puesto Oeste", "Boulevard 77");

        // ==========================
        // 4) CATEGORÍAS DE VEHÍCULOS (aprox. 5)
        // campos: nombre (ej. "Automóvil", "Camión")
        // ==========================
        fachada.agregarCategoria("Automóvil");
        fachada.agregarCategoria("Camión");
        fachada.agregarCategoria("Motocicleta");
        fachada.agregarCategoria("Bus");
        fachada.agregarCategoria("Tractor");

        // Obtener referencias a objetos Categoria recién creados
        ArrayList<Categoria> categorias = fachada.getCategorias();

        // pequeño helper local para buscar por nombre
        Categoria auto = buscarCategoria(categorias, "Automóvil");
        Categoria camion = buscarCategoria(categorias, "Camión");
        Categoria moto = buscarCategoria(categorias, "Motocicleta");
        Categoria bus = buscarCategoria(categorias, "Bus");
        Categoria tractor = buscarCategoria(categorias, "Tractor");

        // ==========================
        // 5) TARIFAS (monto y categoría)
        // Nota: el modelo actual guarda tarifas en SistemaVehiculos de forma global
        // (no están asociadas a un puesto individual en el modelo), por lo que
        // aquí se precargan tarifas por categoría que podrán usarse en la lógica.
        // ==========================
        fachada.agregarTarifa(50.0, auto);
        fachada.agregarTarifa(120.0, camion);
        fachada.agregarTarifa(20.0, moto);
        fachada.agregarTarifa(100.0, bus);
        fachada.agregarTarifa(80.0, tractor);

        // tarifas alternativas / variaciones para pruebas
        fachada.agregarTarifa(55.0, auto);
        fachada.agregarTarifa(140.0, camion);

        // ==========================
        // 6) VEHÍCULOS (aprox. 5)
        // campos: matricula, modelo, color, categoría
        // ==========================
        fachada.agregarVehiculo("ABC123", "Toyota Corolla", "Gris", auto);
        fachada.agregarVehiculo("TRK890", "Volvo FH", "Blanco", camion);
        fachada.agregarVehiculo("MOTO45", "Yamaha YBR", "Negro", moto);
        fachada.agregarVehiculo("BUS001", "Mercedes O500", "Azul", bus);
        fachada.agregarVehiculo("TRAC10", "John Deere", "Verde", tractor);

        // Impresión simple para verificar que propietarios y categorías quedaron
        // cargados
        System.out.println("Propietarios cargados: " + fachada.obtenerprop().size());
        System.out.println("Categorias cargadas: " + (categorias != null ? categorias.size() : 0));

    }

    // // Helper local para buscar una categoria por nombre en la lista
    private static Categoria buscarCategoria(ArrayList<Categoria> lista, String nombre) {
        if (lista == null)
            return null;
        for (Categoria c : lista) {
            if (c.getTipo().equalsIgnoreCase(nombre))
                return c;
        }
        return null;
    }

}
