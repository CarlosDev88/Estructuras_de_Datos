package lista;

public interface Listable<E> {
	public void addFirst(E elemento);

	public void addLast(E elemento);

	public void add(E elemento, int index);

	public void removeFirst();

	public void removeLast();

	public void remove(int index);

	public boolean isEmpty();

	public int size();

	public E getFirst();

	public E getLast();

	public boolean contains(E elemento);

}
