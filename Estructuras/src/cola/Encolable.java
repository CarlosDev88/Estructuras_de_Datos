package cola;

public interface Encolable<E> {
	public int Size();
	public boolean isEmpty();
	public E Front();
	public E Tail();
	public void Enqueue(E elemento); 
	public void Dequeue();
	
}
