package gestion_autobuces;

import java.util.Random;

public class GenerarAutobuses {

	public static Autobus[] generar(int cantidad) {
		String[] origenes = { "Bogota", "Cali", "Medellin", "Bucaramanga", "Sant Marta" };
		String[] destinos = { "Bogota", "Cali", "Medellin", "Bucaramanga", "Sant Marta" };
		Autobus[] autobuses = new Autobus[cantidad];

		for (int i = 0; i < cantidad; i++) {
			Random r = new Random();
			Autobus a = new Autobus();

			a.setOrigen(origenes[r.nextInt(origenes.length)]);
			a.setDestino(destinos[r.nextInt(destinos.length)]);
			a.setDuracion(r.nextInt(600));
			a.setPasajeros(GenerarPasajero.generar(20));

			autobuses[i] = a;
		}

		return autobuses;
	}
}
