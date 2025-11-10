package dda.SistemaPeajes.modelo;

public class Exonerados extends Bonificacion {
    
    public Exonerados() {
        super("Exonerados");
    }
    @Override
    public double aplicarDescuento(Transito t) {
        return t.getMonto(); // No se aplica descuento, en los exonerados
    }
    
}
