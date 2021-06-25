package tablas_hash;

import java.util.ArrayList;
import java.util.Hashtable;

import lista.DoubleLinkedList;
import lista.NodoLista;

public class DiccionarioHash {
	Hashtable<String, DoubleLinkedList<Producto>> tabla = new Hashtable<String, DoubleLinkedList<Producto>>();

	public void pasarTabla(Producto[] vp) {

		for (int i = 0; i < vp.length; i++) {
			DoubleLinkedList<Producto> lLinked = tabla.get(vp[i].getClase());
			if (lLinked == null) {
				lLinked = new DoubleLinkedList<Producto>();
				lLinked.addLast(vp[i]);
			}
			lLinked.addLast(vp[i]);
		}
	}
	
	}
