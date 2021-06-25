package tablas_hash;

public class Producto {
	private String ID;
	private double valor;
	private double peso;
	boolean asiganado;
	String clase;

	public Producto() {

	}

	public Producto(String iD, double valor, double peso, boolean asiganado, String clase) {
		ID = iD;
		this.valor = valor;
		this.peso = peso;
		this.asiganado = asiganado;
		this.clase = clase;
	}

	public void imprime() {
		System.out.println("ID: " + getID() + "\nPeso: " + getPeso() + "\nClase: " + getClase() + "\n¿Esta Asignado? "
				+ isAsiganado());
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean isAsiganado() {
		return asiganado;
	}

	public void setAsiganado(boolean estaAsiganado) {
		this.asiganado = estaAsiganado;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

}
