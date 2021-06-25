package gestion_autobuces;

public class GestorAutobus {
	Autobus[] autobuses;
	private String nombre;
	
	public GestorAutobus() {	
	}

	public GestorAutobus(Autobus[] autobuses, String nombre) {		
		this.autobuses = autobuses;
		this.nombre = nombre;
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
