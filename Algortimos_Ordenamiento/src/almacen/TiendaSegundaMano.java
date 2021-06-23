package almacen;

import java.io.PrintWriter;

public class TiendaSegundaMano {
    String nombre;
    Producto[] Stock;

    public TiendaSegundaMano(String nombre, Producto[] Stock) {
        this.nombre = nombre;
        this.Stock = Stock;
        this.aplicarDescuento();
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
        System.out.println("----------------Lista de producto de la tienda de segunda mano--------");
        double beneficio=0.0;
        for(int i=0;i<Stock.length;i++){
            Stock[i].imprime();
            beneficio += Stock[i].getValor();
        }
        System.out.println("El beneficio de la tienda de segunda mano es:"+beneficio);
        System.out.println("-------------------------------------------");
    }
    
    public void imprimeEstadisticas(PrintWriter salida){
        System.out.println("-------------------------------------------");
        System.out.println("----------------Lista de producto de la tienda de segunda mano--------");
        double beneficio=0.0;
        for(int i=0;i<Stock.length;i++){
            Stock[i].imprime();
            beneficio += Stock[i].getValor();
        }
       System.out.println("El beneficio de la tienda de segunda mano es:"+beneficio);
       System.out.println("-------------------------------------------");
    }
    
    
    public void aplicarDescuento(){
        for(int i=0;i<Stock.length-1;i++){
            if(Stock[i].getClase().compareTo("B")==0){
                Stock[i].setValor(Stock[i].getValor()*0.75);
            }
            if(Stock[i].getClase().compareTo("C")==0){
                Stock[i].setValor(Stock[i].getValor()*0.50);
            }
        }
    }
    
    
}
