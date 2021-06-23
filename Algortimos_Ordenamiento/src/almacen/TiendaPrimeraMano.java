package almacen;

public class TiendaPrimeraMano {
    String nombre;
    Producto[] Stock;

    public TiendaPrimeraMano(String nombre, Producto[] Stock) {
        this.nombre = nombre;
        this.Stock = Stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Producto[] getStock() {
        return Stock;
    }

    public void setStock(Producto[] Stock) {
        this.Stock = Stock;
    }
    
    public void imprimeEstadisticas(){
        System.out.println("-------------------------------------------");
        System.out.println("----------------Lista de producto de la tienda del Centro--------");
        double beneficio=0.0;
        for(int i=0;i<Stock.length;i++){
            Stock[i].imprime();
            beneficio += Stock[i].getValor();
        }
        System.out.println("El beneficio de la tienda del centro es:"+beneficio);
        System.out.println("-------------------------------------------");
    }


    
    
}
