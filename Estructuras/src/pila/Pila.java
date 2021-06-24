package pila;

public class Pila<E> implements Apilable<E> {
	int size;
	NodoPila<E> cima;

	public Pila() {
		this.size = 0;
		this.cima = null;
	}

	@Override
	public void Push(E elemento) {
		if (this.isEmpty()) {
			NodoPila<E> pl = new NodoPila<E>();
			pl.setElemento(elemento);
			pl.setPrev(null);
			this.cima = pl;
			this.size = 1;
		} else {
			NodoPila<E> pl = new NodoPila<E>();
			pl.setElemento(elemento);
			pl.setPrev(this.cima);
			this.cima = pl;
			this.size += 1;
		}
	}

	@Override
	public void Pop() {
		if (this.isEmpty()) {
			System.out.println("la pila esta vacia");
		} else {
			this.cima = this.cima.getPrev();
			this.size--;
		}
	}

	@Override
	public int Zise() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public E Top() {
		E elemento;
		if (this.isEmpty()) {
			elemento = null;
			System.out.println("la pila esta vacia");
		} else {
			elemento = cima.getElemento();
		}
		return elemento;
	}
}
