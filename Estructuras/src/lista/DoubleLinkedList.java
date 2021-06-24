package lista;

public class DoubleLinkedList<E> implements Listable<E> {

	int size;
	NodoLista<E> head;
	NodoLista<E> tail;

	public DoubleLinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

	@Override
	public boolean isEmpty() {
		if (this.size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void addFirst(E elemento) {
		if (isEmpty()) {
			NodoLista<E> nodo = new NodoLista<E>();
			nodo.setElemento(elemento);
			nodo.setNext(null);
			nodo.setPrev(null);
			this.head = nodo;
			this.tail = nodo;
			this.size = 1;

		} else {
			NodoLista<E> nodo = new NodoLista<E>();
			nodo.setElemento(elemento);
			nodo.setNext(this.head);
			nodo.setPrev(null);
			this.head.setPrev(nodo);
			this.head = nodo;
			this.size += 1;

		}

	}

	@Override
	public void addLast(E elemento) {
		if (isEmpty()) {
			NodoLista<E> nodo = new NodoLista<E>();
			nodo.setElemento(elemento);
			nodo.setNext(null);
			nodo.setPrev(null);
			this.head = nodo;
			this.tail = nodo;
			this.size = 1;

		} else {
			NodoLista<E> nodo = new NodoLista<E>();
			nodo.setElemento(elemento);
			nodo.setNext(null);
			nodo.setPrev(this.tail);
			this.tail.setNext(nodo);
			this.tail = nodo;
			this.size += 1;

		}

	}

	@Override
	public void add(E elemento, int index) {
		if (index == 0) {
			this.addFirst(elemento);

		} else if (index == this.size) {
			this.addLast(elemento);

		} else if (index > this.size) {
			System.out.println("el indice es incorrecto");

		} else {
			DoubleLinkedList<E> lista = new DoubleLinkedList<>();
			int contador = 0;
			while (this.isEmpty() == false) {
				if (index == contador) {
					lista.addLast(elemento);
					contador++;

				} else {
					lista.addLast(this.getFirst());
					this.removeFirst();
					contador++;
				}
			}
			this.head = lista.head;
			this.tail = lista.tail;
			this.size = lista.size;
		}

	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("la lista está vacia");
		} else {
			this.head = head.getNext();
			this.size--;
		}

	}

	@Override
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("la lista está vacia");
		} else {
			this.tail = tail.getPrev();
			this.size--;
		}

	}

	@Override
	public void remove(int index) {
		if (index == 0) {
			this.removeFirst();

		} else if (index == this.size - 1) {
			this.removeLast();

		} else if (index > this.size) {
			System.out.println("el indice es incorrecto");

		} else {
			DoubleLinkedList<E> lista = new DoubleLinkedList<>();
			int contador = 0;
			while (this.isEmpty() == false) {
				if (index == contador) {
					this.removeFirst();
					contador++;

				} else {
					lista.addLast(this.getFirst());
					this.removeFirst();
					contador++;
				}
			}
			this.head = lista.head;
			this.tail = lista.tail;
			this.size = lista.size;
		}

	}

	@Override
	public E getFirst() {
		E elemento;
		if (isEmpty()) {
			elemento = null;
			System.out.println("la lista esta vacia");
		} else {
			elemento = head.getElemento();
		}
		return elemento;
	}

	@Override
	public E getLast() {
		E elemento;
		if (isEmpty()) {
			elemento = null;
			System.out.println("la lista esta vacia");
		} else {
			elemento = tail.getElemento();
		}
		return elemento;
	}

	@Override
	public boolean contains(E elemento) {
		// TODO Auto-generated method stub
		return false;
	}

}
