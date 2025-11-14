package ort.dda.obl.controlador;

import ort.dda.obl.ConexionNavegador;
import ort.dda.obl.UsuarioException;
import ort.dda.obl.modelo.Administrador;
import ort.dda.obl.modelo.Fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import observador.Observable;
import observador.Observador;

import java.util.*;

@Scope("session")
@RestController
@RequestMapping("/admin/transito")
public class ControladorEmularTransito implements Observador {
    private final ConexionNavegador conexionNavegador;

    public ControladorEmularTransito(@Autowired ConexionNavegador conexionNavegador) {
        this.conexionNavegador = conexionNavegador;
    }

    @PostMapping("/vistaConectada")
    public List<Respuesta> inicializarVista(@SessionAttribute(name = "usuarioAdmin") Administrador admin)
            throws UsuarioException {
        Fachada.getInstancia().agregarObservador(this);
        return Respuesta.lista();

    }

    @PostMapping("/vistaCerrada")
    public void vistaCerrada() {
        Fachada.getInstancia().quitarObservador(this);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        conexionNavegador.enviarJSON(Respuesta.lista()); // enviar las respuestas cambiantes en la misma ejecucion
    }

}