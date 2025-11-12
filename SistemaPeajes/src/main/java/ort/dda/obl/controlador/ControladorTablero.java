package ort.dda.obl.controlador;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import observador.Observable;
import observador.Observador;
import ort.dda.obl.SistemaTransitoException;
import ort.dda.obl.dto.PropietarioDTO;
import ort.dda.obl.modelo.Fachada;
import ort.dda.obl.modelo.Propietario;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/tablero")
public class ControladorTablero implements Observador {

  @PostMapping("/vistaConectada")
  public List<Respuesta> inicializarVista(@SessionAttribute(name = "usuarioPropietario") Propietario prop)
      throws SistemaTransitoException {
    Fachada.getInstancia().agregarObservador(this);
    if (!prop.puedeIngresar()) {
      return Respuesta.lista(
          new Respuesta("error", "El usuario no puede ingresar al sistema"));
    }
    PropietarioDTO dto = new PropietarioDTO(prop);
    return Respuesta.lista(
        new Respuesta("nombreCompleto", dto.getNombreCompleto()),
        new Respuesta("estado", dto.getEstado()),
        new Respuesta("saldoactual", dto.getSaldoActual()),
        new Respuesta("bonificaciones", dto.getAsignaciones()),
        new Respuesta("vehiculos", dto.getVehiculos()),
        new Respuesta("transitos", dto.getTransitos()),
        new Respuesta("notificaciones", dto.getNotificaciones()));
  }

  @PostMapping("/vistaCerrada")
  public void vistaCerrada() {
    Fachada.getInstancia().quitarObservador(this);
  }

  @PostMapping("/borrarNotificaciones")
  public List<Respuesta> borrarNotificaciones(@SessionAttribute(name = "usuarioPropietario") Propietario prop) {
    Fachada.getInstancia().agregarObservador(this);

    if (prop.getNotificaciones().isEmpty()) {
      return Respuesta.lista(
          new Respuesta("error", "No hay notificaciones para borrar"));
    }
    Fachada.getInstancia().borrarNotificacionesPropietario(prop);
    PropietarioDTO dto = new PropietarioDTO(prop);
    return Respuesta.lista(
        new Respuesta("notificaciones", prop.getNotificaciones()));

  }

  @Override
  public void actualizar(Object evento, Observable origen) {
    System.out.println("FFFFFFFFFFFFFFFFFFFF ANDAAA");
  }

}