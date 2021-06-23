package lista;

public class NodoLista<E> {
	E elemento;
	NodoLista<E> prev;
	NodoLista<E> next;

	public NodoLista() {
		elemento = null;
		prev = null;
		next = null;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public NodoLista<E> getPrev() {
		return prev;
	}

	public void setPrev(NodoLista<E> prev) {
		this.prev = prev;
	}

	public NodoLista<E> getNext() {
		return next;
	}

	public void setNext(NodoLista<E> next) {
		this.next = next;
	}
	
	
}
