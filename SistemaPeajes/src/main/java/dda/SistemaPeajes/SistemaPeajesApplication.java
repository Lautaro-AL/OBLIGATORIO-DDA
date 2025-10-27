package dda.SistemaPeajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dda.SistemaPeajes.modelo.DatosPrueba;

@SpringBootApplication
public class SistemaPeajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPeajesApplication.class, args);
		DatosPrueba.cargarDatos();
	}

}
