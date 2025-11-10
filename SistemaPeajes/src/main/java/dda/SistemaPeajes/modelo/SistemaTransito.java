package dda.SistemaPeajes.modelo;

import java.util.ArrayList;

public class SistemaTransito {
    private ArrayList<PuestoPeaje> puestosPeaje = new ArrayList<PuestoPeaje>();
    private ArrayList<Bonificacion> bonificaciones = new ArrayList<Bonificacion>();

    public void agregarPuesto(String nombre, String direccion) {
        puestosPeaje.add(new PuestoPeaje(nombre, direccion));
    }

    // public void agregarBonificacion(String nombre) {
    // bonificaciones.add(new Bonificacion(nombre));
    // }

    public ArrayList<PuestoPeaje> getPuestosPeaje() {
        return puestosPeaje;
    }

}
