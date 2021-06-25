package gestion_autobuces;

import java.util.Random;

public class GenerarPasajero {

	public static Pasajero[] generar(int cantidad) {
		String[] nombres = { "Diaz", "Garcia", "Noriega", "Melendez", "Ardila", "Carbajal" };
		String[] apellidos = { "Pedro", "Pablo", "Jacinto", "José", "Pepe", "Juan" };
		Pasajero[] pasajeros = new Pasajero[cantidad];

		for (int i = 0; i < cantidad; i++) {
			Random r = new Random();
			int iNombre = r.nextInt(nombres.length);
			int iApellido = r.nextInt(apellidos.length);

			Pasajero p = new Pasajero(nombres[iNombre], apellidos[iApellido]);
			pasajeros[i] = p;
		}

		return pasajeros;
	}
	
}
