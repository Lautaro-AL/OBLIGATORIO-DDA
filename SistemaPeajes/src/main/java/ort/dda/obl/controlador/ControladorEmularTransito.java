package ort.dda.obl.controlador;

import ort.dda.obl.SistemaTransitoException;
import ort.dda.obl.UsuarioException;
import ort.dda.obl.dto.PropietarioDTO;
import ort.dda.obl.modelo.Administrador;
import ort.dda.obl.modelo.Fachada;
import ort.dda.obl.modelo.Propietario;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import observador.Observable;
import observador.Observador;

import java.util.*;

@Scope("session")
@RestController
@RequestMapping("/admin/transito")
public class ControladorEmularTransito implements Observador {

    @PostMapping("/vistaConectada")
    public List<Respuesta> inicializarVista(@SessionAttribute(name = "usuarioAdmin") Administrador admin)
            throws UsuarioException {
        Fachada.getInstancia().agregarObservador(this);
        return Respuesta.lista();

    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

}