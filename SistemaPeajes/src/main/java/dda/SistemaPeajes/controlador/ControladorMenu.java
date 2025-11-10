// package dda.SistemaPeajes.controlador;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Scope;
// import org.springframework.http.MediaType;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.SessionAttribute;
// import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

// public class ControladorMenu {
// private final ConexionNavegador conexionNavegador;

// public ControladorMenu(@Autowired ConexionNavegador conexionNavegador) {
// this.conexionNavegador = conexionNavegador;
// }
// @GetMapping(value = "/registrarSSE", produces =
// MediaType.TEXT_EVENT_STREAM_VALUE)
// public SseEmitter registrarSSE() {
// conexionNavegador.conectarSSE();
// return conexionNavegador.getConexionSSE();

// }

// @PostMapping("/vistaConectada")
// public List<Respuesta> inicializarVista(@SessionAttribute(name =
// "usuarioAgenda") Sesion sesion){

// return Respuesta.lista(new Respuesta("nombreCompleto",
// sesion.getUsuario().getNombreCompleto()));

// }
// }
