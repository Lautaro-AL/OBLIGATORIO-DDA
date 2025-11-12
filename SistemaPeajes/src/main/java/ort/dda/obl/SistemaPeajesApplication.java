package ort.dda.obl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ort.dda.obl.modelo.DatosPrueba;

@SpringBootApplication
public class SistemaPeajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemaPeajesApplication.class, args);
		DatosPrueba.cargarDatos();
	}

}
