package tree.binary_tree;

import tree.Position;
import tree.TreeMethods;

public interface BinaryTreeMethods<E> extends TreeMethods<E> {
	public Position<E> left(Position<E> p);

	public Position<E> right(Position<E> p);

	public boolean HasRight(Position<E> p);

	public boolean HasLeft(Position<E> p);
}
