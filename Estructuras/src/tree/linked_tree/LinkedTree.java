package tree.linked_tree;

import java.util.Iterator;

import tree.Position;
import tree.TreeMethods;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Position<E> root() {
		if(root==null) {
			
		}else {
			
		}
		return null;
	}

	@Override
	public Position<E> parent(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable children(Position<E> p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isLeaf(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInternal(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoot(Position<E> p) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E replace(Position<E> p, E elemento) {
		// TODO Auto-generated method stub
		return null;
	}
}
