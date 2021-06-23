package almacen;

import java.util.Random;

public class GeneradorProductos {

	public static Producto[] generarProdcutos(int cantidad) {
		Random r = new Random();
		String[] listaClases = { "A", "B", "C" };
		Producto[] inventario = new Producto[cantidad];

		for (int i = 0; i < cantidad; i++) {
			Producto producto = new Producto();
			producto.setID(Integer.toString((int)(Math.random() * 1000000)));
			producto.setValor(r.nextDouble() * 1000);
			producto.setPeso(r.nextDouble() * 10);
			producto.setAsiganado(false);
			producto.setClase(listaClases[r.nextInt(listaClases.length)]);

			inventario[i] = producto;
		}

		return inventario;
	}
}
