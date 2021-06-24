package tree.binay_search_tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import tree.Position;
import tree.binary_tree.BinaryTree;

public class BinaySearchTree<E> {
	int size;
	BinaryTree<E> tree;
	Comparator<E> comparador;

	public BinaySearchTree() {
		size = 0;
		tree = new BinaryTree<E>();
		tree.addRoot(null);
		comparador = new ComparadorSimple<E>();
	}

	public BinaySearchTree(Comparator<E> comparador) {
		size = 0;
		tree = null;
		this.comparador = comparador;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public Position<E> busquedaEnArbol(Position<E> p, E value) {
		if (tree.isLeaf(p)) {
			return p;
		} else {
			E valueActual = p.element();
			int comparacion = comparador.compare(value, valueActual);

			if (comparacion < 0) {
				return busquedaEnArbol(tree.left(p), value);
			} else if (comparacion > 0) {
				return busquedaEnArbol(tree.right(p), value);
			} else {
				return p;
			}
		}

	}

	public Position<E> expandirHoja(Position<E> p, E value1, E value2) {
		tree.addLeft(p, value1);
		tree.addRight(p, value2);
		return p;
	}

	public Position<E> insertarEnHoja(Position<E> p, E value) {

		this.expandirHoja(p, null, null);
		this.replace(p, value);
		this.size++;

		return p;
	}

	public Position<E> replace(Position<E> p, E value) {
		tree.replace(p, value);
		return p;
	}

	public Position<E> insert(E value) {
		Position<E> p = this.busquedaEnArbol(tree.root(), value);
		
		if(p.element()!=value) {
			this.insertarEnHoja(p, value);
		}	
		return p;
	}

	public Position<E> sucesor(Position<E> p) {
		Position<E> sucesor = p;
		if (!tree.isLeaf(tree.right(p))) {
			sucesor = tree.right(p);
		}

		while (tree.isInternal(tree.left(sucesor))) {
			sucesor = tree.left(sucesor);

		}

		return sucesor;
	}

	public Position<E> remove(E value) {
		Position<E> posrem = this.busquedaEnArbol(tree.root(), value);

		if (tree.left(posrem) == null && tree.right(posrem) == null) {
			posrem = null;
			this.size--;
		}

		if ((tree.left(posrem) != null && tree.right(posrem) == null)
				|| (posrem) == null && tree.right(posrem) != null) {
			tree.remove(posrem);
			this.size--;

		} else {
			Position<E> sucesor = this.sucesor(posrem);
			this.replace(posrem, sucesor.element());
			tree.remove(tree.left(sucesor));		
			tree.remove(sucesor);
			this.size--;
		}

		return posrem;
	}

	public void addLista(List<E> lista) {
		List<E> l = lista;
		Iterator<E> it = l.iterator();

		while (it.hasNext()) {
			E value = it.next();
			this.insert(value);
		}
	}

}
