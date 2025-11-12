package ort.dda.obl.controlador;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import ort.dda.obl.dto.PropietarioDTO;
import ort.dda.obl.modelo.Propietario;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@RestController
@RequestMapping("/tablero")
public class ControladorTablero {

  @PostMapping("/vistaConectada")
  public List<Respuesta> inicializarVista(@SessionAttribute(name = "usuarioPropietario") Propietario prop) {

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

  @PostMapping("/borrarNotificaciones")
  public List<Respuesta> borrarNotificaciones(@SessionAttribute(name = "usuarioPropietario") Propietario prop) {
    if (prop.getNotificaciones().isEmpty()) {
      return Respuesta.lista(
          new Respuesta("error", "No hay notificaciones para borrar"));
    }
    prop.getNotificaciones().clear();
    return Respuesta.lista(
        new Respuesta("exito", "Notificaciones borradas correctamente"),
        new Respuesta("notificaciones", new ArrayList<>()));

  }

  // private SistemaAcceso sistemaAcceso;
  // private Sesion sesionActual;

  // public ControladorTablero(SistemaAcceso sistemaAcceso, Sesion sesionActual) {
  // this.sistemaAcceso = sistemaAcceso;
  // this.sesionActual = sesionActual;
  // }

  // public SistemaAcceso getSistemaAcceso() {
  // return sistemaAcceso;
  // }

  // public Sesion getSesionActual() {
  // return sesionActual;
  // }
  // // CU- Ingresar a la app del propietario

  // public Propietario loginPropietario(String cedula, String password) throws
  // AccesoDenegadoException {
  // Propietario encontrado = null;

  // for (Propietario p : sistemaAcceso.getPropietarios()) {
  // if (p.getCedula().equals(cedula) && p.getPassword().equals(password)) {
  // encontrado = p;
  // break;
  // }
  // }
  // if (encontrado == null) {
  // throw new AccesoDenegadoException("No existe el usuario");
  // }

  // if (!encontrado.getPassword().equals(password)) {
  // throw new AccesoDenegadoException("La contraseña es incorrecta");
  // }
  // // a implementar estado de usuario
  // if (encontrado.getEstado() == EstadoPropietario.DESHABILITADO) {
  // throw new AccesoDenegadoException("Usuario deshabilitado, no puede ingresar
  // al sistema");
  // }
  // if (!encontrado.puedeIngresar()) {
  // throw new AccesoDenegadoException("Usuario deshabilitado, no puede ingresar
  // al sistema");
  // }
  // return encontrado;
  // }

  // public TableroDTO obtenerTablero(Propietario p) {
  // TableroDTO dto = new TableroDTO();
  // dto.setNombre(p.getNombreCompleto());
  // dto.setEstado(p.getEstado().getNombre());
  // dto.setSaldo(p.getSaldoActual());
  // dto.setBonificaciones(p.getAsignaciones());
  // dto.setVehiculos(p.getVehiculos());
  // dto.setTransitos(p.getTransitos());
  // dto.setNotificaciones(p.getNotificaciones());
  // return dto;
  // }

}