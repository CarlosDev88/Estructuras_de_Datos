package gestion_autobuces;

import java.util.ArrayList;
import java.util.Hashtable;

public class GestorAutobus {
	Autobus[] autobuses;
	private String nombre;
	Hashtable<String, ArrayList<Autobus>> tablaOrigenes = new Hashtable<String, ArrayList<Autobus>>();
	Hashtable<String, ArrayList<Autobus>> tablaDestinos = new Hashtable<String, ArrayList<Autobus>>();
	
	public GestorAutobus() {	
	}

	public GestorAutobus(Autobus[] autobuses, String nombre) {		
		this.autobuses = autobuses;
		this.nombre = nombre;
	}
	
	public void pasarOrigenes() {
		
		
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
