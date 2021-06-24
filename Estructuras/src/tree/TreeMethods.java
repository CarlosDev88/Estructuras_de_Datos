package tree;

import java.util.Iterator;

public interface TreeMethods<E> {
	public int size();

	public boolean isEmpty();

	Iterator iterator();

	Iterable positions();

	Position<E> root();

	Position<E> parent(Position<E> p);

	Iterable children(Position<E> p);

	boolean isLeaf(Position<E> p);

	boolean isInternal(Position<E> p);

	boolean isRoot(Position<E> p);

	E replace(Position<E> p, E elemento);
}
