package dda.SistemaPeajes.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dda.SistemaPeajes.modelo.Administrador;
import dda.SistemaPeajes.modelo.Fachada;
import dda.SistemaPeajes.modelo.PeajeException;
import dda.SistemaPeajes.modelo.Propietario;
import dda.SistemaPeajes.modelo.Sesion;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class ControladorLogin {

    @PostMapping("/loginPropietario")
    public List<Respuesta> loginPropetario(HttpSession sesionHttp, @RequestParam String cedula,
            @RequestParam String password) throws PeajeException {

        // login al modelo
        Propietario sesion = Fachada.getInstancia().loginPropetario(cedula, password);

        // si hay una sesion activa la cierro
        logoutPropietarios(sesionHttp);

        // guardo la sesion de la logica en la sesionHttp
        sesionHttp.setAttribute("usuarioPropietario", sesion);
        return Respuesta.lista(new Respuesta("loginExitoso", "tablero.html"));// completar html al controlador de
                                                                              // tablero
    }

    @PostMapping("/loginAdmin")
    public List<Respuesta> loginAdministrador(HttpSession sesionHttp,
            @RequestParam String cedula, @RequestParam String password) throws PeajeException {
        // login al modelo
        Administrador admin = Fachada.getInstancia().loginAdministrador(cedula,
                password);

        // guardo el admin en la sesionHttp
        sesionHttp.setAttribute("usuarioAdmin", admin);
        return Respuesta.lista(new Respuesta("loginExitoso",
                "emularTransito.html")); // completar html admin
    }

    @PostMapping("/logout") // SOlo admin
    public List<Respuesta> logoutPropietarios(HttpSession sesionHttp) throws PeajeException {
        Sesion sesion = (Sesion) sesionHttp.getAttribute("usuarioPropietario");
        if (sesion != null) {
            Fachada.getInstancia().logout(sesion);
            sesionHttp.removeAttribute("usuarioPropietario");
        }
        return Respuesta.lista(new Respuesta("paginaLogin", "login.html"));

    }
}
