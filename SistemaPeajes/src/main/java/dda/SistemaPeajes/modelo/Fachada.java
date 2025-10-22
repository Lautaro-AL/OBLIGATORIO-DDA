package dda.SistemaPeajes.modelo;

public class Fachada {
    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaTransito sTransito = new SistemaTransito();
    private SistemaVehiculos sVehiculos = new SistemaVehiculos();

    //SINGLETON
    private static Fachada instancia = new Fachada();
    public static Fachada getInstancia() {
        return instancia;
    }
    
    private Fachada(){}
    
}
