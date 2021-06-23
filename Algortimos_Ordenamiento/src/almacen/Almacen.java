package almacen;

public class Almacen {

	public static void main(String[] args) {
		  Producto[] lp=GeneradorProductos.generarProdcutos(1000);
	        AlmacenGestion ag=new AlmacenGestion(lp);
	        Producto[] s1=ag.prepararPedidoTC(100);
	        Producto[] s2=ag.prepararPedidoSM(150);
	        TiendaPrimeraMano t1=new TiendaPrimeraMano("EmpresaSoftPlanet",s1);
	        TiendaSegundaMano t2=new TiendaSegundaMano("EmpresaSoftExpress",s2);
	        ag.imprimeListaProductos();
	        t1.imprimeEstadisticas();
	        t2.imprimeEstadisticas();

	}

}
