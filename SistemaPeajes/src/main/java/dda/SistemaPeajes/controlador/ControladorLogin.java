package dda.SistemaPeajes.controlador;

import java.util.List;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dda.SistemaPeajes.UsuarioException;
import dda.SistemaPeajes.modelo.Administrador;
import dda.SistemaPeajes.modelo.Fachada;
import dda.SistemaPeajes.modelo.Propietario;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class ControladorLogin {

    @PostMapping("/loginPropietario")
    public List<Respuesta> loginPropetario(HttpSession sesionHttp, @RequestParam String cedula,
            @RequestParam String password) throws UsuarioException {

        Propietario sesion;
        try {
            sesion = Fachada.getInstancia().loginPropetario(cedula, password);
        } catch (UsuarioException e) {
            return Respuesta.lista(new Respuesta("error", e.getMessage()));
        }

        // Si hay una sesión activa, la cierro
        logoutAdmin(sesionHttp);
        // Guardo la sesión del propietario
        sesionHttp.setAttribute("usuarioPropietario", sesion);
        // Devuelvo la respuesta de login exitoso
        return Respuesta.lista(new Respuesta("loginExitoso", "tablero.html"));
    }

    @PostMapping("/loginAdmin")
    public List<Respuesta> loginAdministrador(HttpSession sesionHttp,
            @RequestParam String cedula, @RequestParam String password) throws UsuarioException {
        // login al modelo
        Administrador admin = Fachada.getInstancia().loginAdministrador(cedula,
                password);

        // guardo el admin en la sesionHttp
        sesionHttp.setAttribute("usuarioAdmin", admin);
        return Respuesta.lista(new Respuesta("loginExitoso",
                "emularTransito.html")); // completar html admin
    }

    @PostMapping("/logout") // SOlo admin
    public List<Respuesta> logoutAdmin(HttpSession sesionHttp) throws UsuarioException {
        Administrador sesion = (Administrador) sesionHttp.getAttribute("administrador");
        if (sesion != null) {
            Fachada.getInstancia().logout(sesion);
            sesionHttp.removeAttribute("usuarioPropietario");
        }
        return Respuesta.lista(new Respuesta("paginaLogin", "login.html"));

    }
}
