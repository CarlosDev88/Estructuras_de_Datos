package tree.binary_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.Position;
import tree.exceptions.BadPosition;
import tree.exceptions.EmptyTree;
import tree.exceptions.Inaccessible;

public class BinaryTree<E> implements BinaryTreeMethods<E> {
	BinaryNode<E> root;
	int size;

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	@Override
	public Iterator iterator() {
		Iterable<Position<E>> pos = (Iterable<Position<E>>) positions();
		List<Position<E>> resultado = new ArrayList<Position<E>>();

		for (Position<E> position : pos) {
			resultado.add(position);
		}
		return resultado.iterator();
	}

	@Override
	public Iterable positions() {
		List<Position<E>> lista = new ArrayList<Position<E>>();

		this.preorden(this.root, lista);
		return (Iterable) lista;
	}

	@Override
	public Position<E> root() throws EmptyTree {
		if (this.isEmpty()) {
			throw new EmptyTree("El arbol esta vacio");
		}
		return this.root;
	}

	@Override
	public Position<E> parent(Position<E> p) {

		BinaryNode<E> nodo = this.checkPosition(p);
		BinaryNode<E> parent;

		if (nodo.equals(root)) {
			throw new Inaccessible("el nodo es raiz no tiene hijos");
		} else {
			parent = nodo.getParent();
		}
		return parent;

	}

	@Override
	public Iterable children(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);
		List<Position<E>> hijos = new ArrayList<Position<E>>();

		if (nodo.getLeft() != null) {
			hijos.add((Position<E>) nodo.getLeft());
		}

		if (nodo.getRight() != null) {
			hijos.add((Position<E>) nodo.getRight());
		}
		return hijos;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);

		if (nodo.getLeft() == null && nodo.getRight() == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		return !this.isLeaf(p);
	}

	@Override
	public boolean isRoot(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);
		return nodo.equals(root);
	}

	@Override
	public E replace(Position<E> p, E elemento) {
		BinaryNode<E> nodo = this.checkPosition(p);
		E element = nodo.getElemento();
		nodo.setElemento(elemento);
		return element;
	}

	@Override
	public Position<E> left(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);
		BinaryNode<E> left;

		if (this.HasLeft(p)) {
			left = nodo.getLeft();
		} else {
			throw new Inaccessible("no existe hijo izquierdo");
		}
		return left;
	}

	@Override
	public Position<E> right(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);
		BinaryNode<E> right;

		if (this.HasRight(p)) {
			right = nodo.getRight();
		} else {
			throw new Inaccessible("no existe hijo izquierdo");
		}
		return right;
	}

	@Override
	public boolean HasRight(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);

		if (nodo.getRight() == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public boolean HasLeft(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);

		if (nodo.getLeft() == null) {
			return false;
		} else {
			return true;
		}
	}

	protected BinaryNode<E> checkPosition(Position<E> p) throws BadPosition {
		if ((p == null) || !(p instanceof BinaryNode)) {
			throw new BadPosition("Posicion no valida");
		}
		BinaryNode<E> node = (BinaryNode<E>) p;
		return node;

	}

	protected BinaryNode<E> createNode(E elemento, BinaryNode<E> right, BinaryNode<E> left, BinaryNode<E> parent) {
		return new BinaryNode<E>(elemento, right, left, parent);
	}

	public BinaryNode<E> addRight(Position<E> p, E elemento) {
		BinaryNode<E> nodo = this.checkPosition(p);		
		BinaryNode<E> nuevoNodo = this.createNode(elemento, null, null, nodo);

		if (nodo.getRight() == null) {
			nodo.setRight(nuevoNodo);
			this.size++;
		} else {
			throw new Inaccessible("Ya tiene un hijo derecho");
		}
		return nuevoNodo;
	}

	public BinaryNode<E> addLeft(Position<E> p, E elemento) {
		BinaryNode<E> nodo = this.checkPosition(p);
		BinaryNode<E> nuevoNodo = this.createNode(elemento, null, null, nodo);

		if (nodo.getLeft() == null) {
			nodo.setLeft(nuevoNodo);
			this.size++;
		} else {
			throw new Inaccessible("Ya tiene un hijo izquierdo");
		}
		return nuevoNodo;
	}

	public BinaryNode<E> addRoot(E elemento) {
		BinaryNode<E> nuevoNodo = this.createNode(elemento, null, null, null);
		if (this.root == null) {
			this.root = nuevoNodo;
		} else {
			throw new BadPosition("posicion no valida");
		}

		return nuevoNodo;
	}

	public E remove(Position<E> p) {
		BinaryNode<E> nodo = this.checkPosition(p);
		BinaryNode<E> nodoLeft = nodo.getLeft();
		BinaryNode<E> nodoRight = nodo.getRight();
		E element = nodo.getElemento();

		if (nodoLeft != null && nodoRight != null) {
			throw new BadPosition("no se puede borrar un nodo con 2 hijos");
		} else {
			BinaryNode<E> hijo;
			if (nodoRight != null) {
				hijo = nodoRight;
			}
			if (nodoLeft != null) {
				hijo = nodoLeft;
			} else {
				hijo = null;
			}

			if (nodo.equals(root)) {
				if (hijo == null) {
					root = null;
					size = 0;
				} else {
					hijo.setParent(null);
					root = hijo;
				}
			} else {
				BinaryNode<E> abuelo = nodo.getParent();

				if (nodo.equals(abuelo.getLeft())) {
					abuelo.setLeft(hijo);					
					
				} else if (nodo.equals(abuelo.getRight())) {
					abuelo.setRight(hijo);					
				}
				
				if(hijo!=null) {
					hijo.setParent(abuelo);
				}
			}
			
			this.size--;
		}

		return element;

	}
	
	protected void preorden(Position<E>p,List<Position<E>>lista) {
		lista.add(p);
		
		if(this.HasLeft(p)) {
			preorden(this.left(p), lista);
		}
		
		if(this.HasRight(p)) { 
			preorden(this.right(p),lista);
		}
		
	}

}
