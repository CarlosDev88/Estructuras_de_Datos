package gestion_autobuces;

public class Ejecutar {

	public static void main(String[] args) {
		GestorAutobus ga = new GestorAutobus(GenerarAutobuses.generar(20), "bus");
		ga.imprimeInformacion();
		System.out.println("---------Filtrado por ciudad ------------");
		ga.filtarDestino("Bogota");
		ga.BuscarPasajero();

	}

}
