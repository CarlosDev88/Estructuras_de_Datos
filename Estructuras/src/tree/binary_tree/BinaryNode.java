package tree.binary_tree;

import tree.Position;

public class BinaryNode<E> implements Position<E> {
	private E elemento;
	private BinaryNode<E> right;
	private BinaryNode<E> left;
	private BinaryNode<E> parent;

	public BinaryNode() {
		elemento = null;
		right = null;
		left = null;
		parent = null;

	}
	
	

	public BinaryNode(E elemento, BinaryNode<E> right, BinaryNode<E> left, BinaryNode<E> parent) {
		
		this.elemento = elemento;
		this.right = right;
		this.left = left;
		this.parent = parent;
	}



	@Override
	public E element() {
		// TODO Auto-generated method stub
		return null;
	}

	public E getElemento() {
		return elemento;
	}

	public void setElemento(E elemento) {
		this.elemento = elemento;
	}

	public BinaryNode<E> getRight() {
		return right;
	}

	public void setRight(BinaryNode<E> right) {
		this.right = right;
	}

	public BinaryNode<E> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<E> left) {
		this.left = left;
	}

	public BinaryNode<E> getParent() {
		return parent;
	}

	public void setParent(BinaryNode<E> parent) {
		this.parent = parent;
	}

}
