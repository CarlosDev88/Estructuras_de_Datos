package tablas_hash;

import java.util.ArrayList;
import java.util.Iterator;

public class MainTablaHash {
	
public static void main(String[] args) {
	Producto []prodcutos = new Producto[5];
	
	Producto p1 = new Producto("120",500.1,25,true,"A");
	Producto p2 = new Producto("121",255.2,32,true,"B");
	Producto p3 = new Producto("122",355.2,42,true,"C");
	Producto p4 = new Producto("123",155.2,23,true,"A");
	Producto p5 = new Producto("124",265.2,12,true,"B");
	
	prodcutos[0]=p1;
	prodcutos[1]=p2;
	prodcutos[2]=p3;
	prodcutos[3]=p4;
	prodcutos[4]=p5;
	
	TablaHash tabla = new TablaHash();
	tabla.pasarTabla(prodcutos);
	ArrayList<Producto> listaProdcuto = tabla.listaProd();
	Iterator<Producto>it= listaProdcuto.iterator();
	
	while(it.hasNext()) {
		Producto p= it.next();
		p.imprime();
	}
	
	System.out.println("------------Rescatado por Key-------------------");	
	tabla.getProducto("123").imprime();
	
	
	System.out.println("------------prueva con una linked list------------------------");
	DiccionarioHash dic = new DiccionarioHash();
	dic.pasarTabla(prodcutos);
	
	
}
}
