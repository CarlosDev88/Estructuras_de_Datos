package pila;

public interface Apilable<E> {
	public void Push(E elemento);

	public void Pop();

	public int Zise();

	public boolean isEmpty();

	public E Top();
}
