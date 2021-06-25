package tablas_hash;

import java.util.ArrayList;
import java.util.Hashtable;

public class TablaHash {
	Hashtable<String, Producto>tabla = new Hashtable<String,Producto>(); 


	public void pasarTabla(Producto []vp){
		
		for (int i = 0; i < vp.length; i++) {
			tabla.put(vp[i].getID(), vp[i]);
		}
	}
	
	public ArrayList<Producto>listaProd(){
		Iterable<Producto> listaRes=  tabla.values();	
		ArrayList<Producto> resultado = new ArrayList<Producto>();
		
		for (Producto producto : listaRes) {
			resultado.add(producto);
		}
		
		return resultado;
	}
	
	public Producto getProducto(String key) {
		return tabla.get(key);
	}
	
	
	
	public Hashtable<String, Producto> getTabla() {
		return tabla;
	}

	public void setTabla(Hashtable<String, Producto> tabla) {
		this.tabla = tabla;
	}
}
