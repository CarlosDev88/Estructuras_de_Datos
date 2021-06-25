
package ejemplolibreria;

import java.io.*;
import java.util.*;

public class Libreria {
    
    ArrayList<Libro> libros;
    private String nombre;

    public Libreria() {
    }

    public Libreria(ArrayList<Libro> libros, String nombre) {
        this.libros = libros;
        this.nombre = nombre;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
        
   public void anadirLibro(String isb, String titulo, String autor, double precio){
      Libro l=new Libro(isb,  titulo,  autor,  precio);
      
      libros.add(l);
   }
   
   //---------------Imprimir libros-----------------------------------
   
   public void imprimirCatalogo() throws IOException{
       System.out.println("desea guardar el catalogo en un fichero");
       Scanner sc = new Scanner(System.in);
       String respuesta = sc.nextLine();
       
       if(respuesta.compareToIgnoreCase("s")==0){
           
           System.out.println("escribe el nombre del archivo destino");
           String fileName = sc.nextLine();
           
           FileWriter escribir = new FileWriter(fileName);  
           PrintWriter pw = new PrintWriter(escribir); 
           
           Iterator<Libro> it = libros.iterator();
           while(it.hasNext()){
               Libro l=it.next();
               l.imprime(pw);
           }
           
           pw.close();
       }
       
       Iterator<Libro> it = libros.iterator();
           while(it.hasNext()){
               Libro l=it.next();
               l.imprime();
           }
   }
   
   //---------------Borrar libro-----------------------------------
   
   public Libro borrarLibro(String isb){
       
       boolean encontrado = false;
       Iterator<Libro> it = libros.iterator();
           while(it.hasNext()&& (encontrado=false)){
               Libro l=it.next();
               
               if(l.getIsb().compareTo(isb)==0){
                   it.remove();
                   encontrado=true;
                   return l;
               }               
           }
           return null;
   }
   
   //---------------filtrar por autor-----------------------------------
   
   public ArrayList<Libro> filtrarPorAutor(String autor ) throws IOException{
       
       ArrayList<Libro> subLista = new ArrayList<Libro>();
       
       Iterator<Libro> it = libros.iterator();
           while(it.hasNext()){
               Libro l=it.next();
               
               if(l.getAutor().compareToIgnoreCase(autor)==0){
                   subLista.add(l);
               }
           }
           
       System.out.println("desea guardar el catalogo en un fichero");
       Scanner sc = new Scanner(System.in);
       String respuesta = sc.nextLine();
       
       if(respuesta.compareToIgnoreCase("s")==0){
           
           System.out.println("escribe el nombre del archivo destino");
           String fileName = sc.nextLine();
           
           FileWriter escribir = new FileWriter(fileName);  
           PrintWriter pw = new PrintWriter(escribir); 
           
           Iterator<Libro> it2 = subLista.iterator();
           while(it2.hasNext()){
               Libro l=it2.next();
               l.imprime(pw);
           }
           
           pw.close();
       }
       
       Iterator<Libro> it3 = subLista.iterator();
           while(it3.hasNext()){
               Libro l=it3.next();
               l.imprime();
           }
       
       return subLista;
   }
   
   //---------------filtrar por precio-----------------------------------
   
   public ArrayList<Libro> filtrarPorPrecio(double precioMax ) throws IOException{
       
       ArrayList<Libro> subLista = new ArrayList<Libro>();
       
       Iterator<Libro> it = libros.iterator();
           while(it.hasNext()){
               Libro l=it.next();
               
               if(l.getPrecio() <= precioMax){
                   subLista.add(l);
               }
           }
           
       System.out.println("desea guardar el catalogo en un fichero");
       Scanner sc = new Scanner(System.in);
       String respuesta = sc.nextLine();
       
       if(respuesta.compareToIgnoreCase("s")==0){
           
           System.out.println("escribe el nombre del archivo destino");
           String fileName = sc.nextLine();
           
           FileWriter escribir = new FileWriter(fileName);  
           PrintWriter pw = new PrintWriter(escribir); 
           
           Iterator<Libro> it2 = subLista.iterator();
           while(it2.hasNext()){
               Libro l=it2.next();
               l.imprime(pw);
           }
           
           pw.close();
       }
       
       Iterator<Libro> it3 = subLista.iterator();
           while(it3.hasNext()){
               Libro l=it3.next();
               l.imprime();
           }
       
       return subLista;
   }
   
   
//-----------FIN DE LA CLASE------------------------------------
}
