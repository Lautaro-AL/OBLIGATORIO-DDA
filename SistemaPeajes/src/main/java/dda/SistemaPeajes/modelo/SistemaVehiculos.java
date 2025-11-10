package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

public class SistemaVehiculos {

    private ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private ArrayList<Tarifa> tarifas = new ArrayList<Tarifa>();

    public void agregarCategoria(String tipo) {
        categorias.add(new Categoria(tipo));
    }

    public void agregarTarifas(double monto, Categoria categoria) {
        tarifas.add(new Tarifa(monto, categoria));
    }

    public void agregarVehiculo(String matricula, String modelo, String color, Categoria categoria) {
        vehiculos.add(new Vehiculo(matricula, modelo, color, categoria));
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Tarifa> getTarifas() {
        return tarifas;
    }
}
