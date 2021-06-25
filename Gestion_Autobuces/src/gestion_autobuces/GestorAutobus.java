package gestion_autobuces;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Scanner;

public class GestorAutobus {
	Autobus[] autobuses;
	private String nombre;
	Hashtable<String, ArrayList<Autobus>> tablaOrigenes = new Hashtable<String, ArrayList<Autobus>>();
	Hashtable<String, ArrayList<Autobus>> tablaDestinos = new Hashtable<String, ArrayList<Autobus>>();

	public GestorAutobus() {
		this.pasarOrigenes();
		this.pasarDestinos();
	}

	public GestorAutobus(Autobus[] autobuses, String nombre) {

		this.autobuses = autobuses;
		this.nombre = nombre;
		this.pasarOrigenes();
		this.pasarDestinos();

	}

	public void pasarOrigenes() {
		for (int i = 0; i < autobuses.length; i++) {
			ArrayList<Autobus> lista = tablaOrigenes.get(autobuses[i].getOrigen());

			if (lista==null) {
				lista = new ArrayList<Autobus>();
				lista.add(autobuses[i]);
				tablaOrigenes.put(autobuses[i].getOrigen(), lista);

			} else {
				lista.add(autobuses[i]);
				tablaOrigenes.put(autobuses[i].getOrigen(), lista);
			}
		}

	}

	public void pasarDestinos() {
		for (int i = 0; i < autobuses.length; i++) {
			ArrayList<Autobus> lista = tablaDestinos.get(autobuses[i].getDestino());

			if (lista==null) {
				lista = new ArrayList<Autobus>();
				lista.add(autobuses[i]);
				tablaDestinos.put(autobuses[i].getDestino(), lista);

			} else {
				lista.add(autobuses[i]);
				tablaDestinos.put(autobuses[i].getDestino(), lista);
			}
		}
	}

	public void imprimeInformacion() {
		Iterator<ArrayList<Autobus>> it = tablaOrigenes.values().iterator();

		while (it.hasNext()) {
			ArrayList<Autobus> lista = it.next();
			Iterator<Autobus> it2 = lista.iterator();

			while (it2.hasNext()) {
				Autobus a = it2.next();
				System.out.println(a.toString());
			}
		}
	}

	public ArrayList<Autobus> filtarOrigen(String ciudad) {
		ArrayList<Autobus> lista = tablaOrigenes.get(ciudad);
		Iterator<Autobus> it = lista.iterator();

		while (it.hasNext()) {
			Autobus a = it.next();
			System.out.println(a.toString());
		}

		return lista;
	}

	public ArrayList<Autobus> filtarDestino(String destino) {
		ArrayList<Autobus> lista = tablaDestinos.get(destino);
		Iterator<Autobus> it = lista.iterator();

		while (it.hasNext()) {
			Autobus a = it.next();
			System.out.println(a.toString());
		}

		return lista;
	}

	public void imprimeDuracion() {
		int sumaTotal = 0;

		for (int i = 0; i < autobuses.length; i++) {
			sumaTotal += autobuses[i].getDuracion();
		}

		System.out.println("La duracion de los recorridos: " + sumaTotal);
	}

	public void BuscarPasajero() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Escribe el nombre del pasajero: ");
		String nombre = sc.nextLine();

		System.out.println("Escribe el apellido del pasajero: ");
		String apellido = sc.nextLine();

		System.out.println("Escribe el destino del pasajero: ");
		String destino = sc.nextLine();

		ArrayList<Autobus> lista = tablaDestinos.get(destino);
		boolean encontrado = false;

		Iterator<Autobus> it = lista.iterator();

		while (it.hasNext()) {
			Autobus a = it.next();
			Pasajero[] listaPasajeros = a.getPasajeros();
			int i = 0;

			while ((encontrado == false) && (i < listaPasajeros.length)) {
				if (listaPasajeros[i].getNombre().compareToIgnoreCase(nombre) == 0
						&& (listaPasajeros[i].getApellido().compareToIgnoreCase(apellido) == 0)) {
					Pasajero p = listaPasajeros[i];
					encontrado = true;
					System.out.println("-----------------------------------");
					System.out.println("pasajero encontrado" + p.toString());
					System.out.println(" informacion adicional " + a.toString());
				}
				i++;
			}
		}
	}

	public Autobus[] getAutobuses() {
		return autobuses;
	}

	public void setAutobuses(Autobus[] autobuses) {
		this.autobuses = autobuses;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
