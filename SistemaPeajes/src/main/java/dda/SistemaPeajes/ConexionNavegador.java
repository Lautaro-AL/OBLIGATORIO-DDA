package dda.SistemaPeajes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 *
 * @author PC
 */

@Component
@Scope("session")
public class ConexionNavegador {

    private SseEmitter conexionSSE;

    public void conectarSSE() {
        if (conexionSSE != null) { // si hay hay una conexion la cierro
            cerrarConexion();
        }
        long timeOut = 30 * 60 * 1000; // 30 minutos de timeOut (igual al valor por defecto de la sesion)
        conexionSSE = new SseEmitter(timeOut);

    }

    public void cerrarConexion() {
        try {
            if (conexionSSE != null) {
                conexionSSE.complete();
                conexionSSE = null;
            }
        } catch (Exception e) {
        }
    }

    public SseEmitter getConexionSSE() {
        return conexionSSE;
    }

    public void enviarJSON(Object informacion) {
        try {
            String json = new ObjectMapper().writeValueAsString(informacion);
            enviarMensaje(json);

        } catch (JsonProcessingException e) {
            System.out.println("Error al convertir a JSON:" + e.getMessage());

        }

    }

    public void enviarMensaje(String mensaje) {

        if (conexionSSE == null)
            return;
        try {
            conexionSSE.send(mensaje);

        } catch (Throwable e) {
            System.out.println("Error al enviar mensaje:" + e.getMessage());
            cerrarConexion();
        }
    }

}
