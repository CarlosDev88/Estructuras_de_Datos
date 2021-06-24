package tree.linked_tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tree.Position;
import tree.TreeMethods;
import tree.exceptions.BadPosition;
import tree.exceptions.EmptyTree;
import tree.exceptions.Inaccessible;

public class LinkedTree<E> implements TreeMethods<E> {
	private TreeNode<E> root;
	private int size;

	public LinkedTree() {
		root = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
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

		this.preOrdern(this.root, lista);
		return (Iterable) lista;
	}

	@Override
	public Position<E> root() throws EmptyTree {
		if (root == null) {
			throw new EmptyTree("El arbol esta vacion");
		}
		return (Position<E>) this.root;
	}

	@Override
	public Position<E> parent(Position<E> p) throws Inaccessible {
		TreeNode<E> node = this.castPosition(p);
		TreeNode<E> padre = node.getPadre();

		if (padre == null) {
			throw new Inaccessible("No tiene padre");
		}

		return (Position<E>) padre;
	}

	@Override
	public Iterable children(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		TreeNode<E> node = this.castPosition(p);
		boolean isLeaf = false;
		List<TreeNode<E>> hijos = node.getHijos();

		if (hijos == null || hijos.isEmpty()) {
			isLeaf = false;
		} else {
			isLeaf = true;
		}
		return isLeaf;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		boolean isInternal = false;
		if (this.isLeaf(p)) {
			isInternal = false;
		} else {
			isInternal = true;
		}
		return isInternal;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		TreeNode<E> node = this.castPosition(p);
		return node == this.root;
	}

	@Override
	public E replace(Position<E> p, E elemento) {
		TreeNode<E> node = this.castPosition(p);
		E aux = node.element();
		return aux;
	}

	public Position<E> add(Position<E> padre, E elemento) {
		TreeNode<E> nodopadre = this.castPosition(padre);
		TreeNode<E> node = this.createNode(nodopadre, elemento, new ArrayList<TreeNode<E>>());

		List<TreeNode<E>> children = nodopadre.getHijos();
		children.add(node);
		this.size++;
		return (Position<E>) node;
	}

	public Position<E> addRoot(E elemento) {
		TreeNode<E> node = this.createNode(null, elemento, new ArrayList<TreeNode<E>>());
		this.root = node;
		this.size++;
		return (Position<E>) node;
	}

	public Position<E> remove(Position<E> p) {
		TreeNode<E> node = this.castPosition(p);
		TreeNode<E> padre = node.getPadre();

		List<TreeNode<E>> children = padre.getHijos();
		children.remove(node);

		List<Position<E>> list = new ArrayList<Position<E>>();
		this.preOrdern(padre, list);
		this.size = this.size - list.size();

		return (Position<E>) node;
	}

	// cast position to TreeNode

	protected TreeNode<E> castPosition(Position<E> p) throws BadPosition {
		if ((p == null) || !(p instanceof TreeNode)) {
			throw new BadPosition("posicion no valida");
		}
		TreeNode<E> node = (TreeNode<E>) p;
		return node;
	}

	protected TreeNode<E> createNode(TreeNode<E> padre, E elemento, List<TreeNode<E>> hijos) {
		TreeNode<E> node = new TreeNode(padre, elemento, hijos);
		return node;
	}

	public void preOrdern(Position<E> p, List<Position<E>> lista) {
		lista.add(p);
		TreeNode<E> nodo = this.castPosition(p);
		if (!this.isLeaf(p)) {
			for (Position<E> position : nodo.getHijos()) {
				preOrdern(position, lista);
			}
		}
	}
}
