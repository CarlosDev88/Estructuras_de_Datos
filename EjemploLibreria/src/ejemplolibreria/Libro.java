
package ejemplolibreria;

import java.io.*;
import java.text.DecimalFormat;


public class Libro implements Serializable{
    private String isb,titulo,autor;
    private double precio;

    public Libro() {
    }

    public Libro(String isb, String titulo, String autor, double precio) {
        this.isb = isb;
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
    }

    public String getIsb() {
        return isb;
    }

    public void setIsb(String isb) {
        this.isb = isb;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void imprime(){
        
        DecimalFormat decimales = new DecimalFormat("00.0");
        
        System.out.println("ISBN: " + this.getIsb() + " ,Autor:: " +
                         this.getAutor() + ", Titulo: " + this.getTitulo() + 
                        ", Valor: " + decimales.format(this.getPrecio()) + "$");
    }
    
        public void imprime(PrintWriter salida){
        DecimalFormat decimales = new DecimalFormat("00.0"); 
        
        salida.println("ISBN: " + this.getIsb() + " ,Autor:: " +
                        this.getAutor() + ", Titulo: " + this.getTitulo() + 
                        ", Valor: " + decimales.format(this.getPrecio()) + "$");
    }
}
