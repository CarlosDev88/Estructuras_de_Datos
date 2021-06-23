package cola;

public class Cola<E> implements Encolable<E> {
	NodoCola<E> head;
	NodoCola<E> tail;
	int size;

	public Cola() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int Size() {
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
	public E Front() {
		E elemento;
		if (isEmpty()) {
			elemento = null;
			System.out.println("La cola esta vacia");
		} else {
			elemento = this.head.getElemento();

		}
		return elemento;
	}

	@Override
	public E Tail() {
		E elemento;
		if (isEmpty()) {
			elemento = null;
			System.out.println("La cola esta vacia");
		} else {
			elemento = this.tail.getElemento();

		}
		return elemento;
	}

	@Override
	public void Enqueue(E elemento) {
		if (isEmpty()) {
			NodoCola<E> nodo = new NodoCola<E>();
			nodo.setElemento(elemento);
			nodo.setNext(null);
			nodo.setPrev(null);
			this.head = nodo;
			this.tail = nodo;
			this.size = 1;

		} else {
			NodoCola<E> nodo = new NodoCola<E>();
			nodo.setElemento(elemento);
			nodo.setNext(null);
			nodo.setPrev(this.tail);
			this.tail.setNext(nodo);
			this.tail = nodo;
			this.size += 1;
		}

	}

	@Override
	public void Dequeue() {
		if (isEmpty()) {
			System.out.println("la cola esta vacia");
		} else {
			this.head = head.getNext();
			this.size--;
		}

	}

}
