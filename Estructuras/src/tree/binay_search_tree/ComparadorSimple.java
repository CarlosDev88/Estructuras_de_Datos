package tree.binay_search_tree;

import java.util.Comparator;

public class ComparadorSimple<E> implements Comparator<E>{

	
	public int compare(E a, E b) {		
		return ((Comparable<E>) a).compareTo(b);
	}

}
