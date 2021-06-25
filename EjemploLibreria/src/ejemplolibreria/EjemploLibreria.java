
package ejemplolibreria;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class EjemploLibreria {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
       GeneradorLibros gl = new GeneradorLibros(); 
       Libreria libreria = new Libreria(); 
       libreria.setNombre("donde alirio");
       libreria.setLibros(gl.generarLibros(20));
       
       String opcion="";
       while(opcion.compareTo("8")!=0){
           mostrarMenu();
           Scanner sc = new Scanner(System.in);
           opcion = sc.nextLine();
           
           switch (opcion){
               case "1":{
                   Sesion s = new Sesion();
                   s.setCatalogo(libreria.getLibros());
                   s.guardarCatalogo();
               break;} 
               
               case "2":{
                   Sesion s = new Sesion();
                   libreria.setLibros(s.cargarCatalogo());
               break;}
               
               case "3":{
                   System.out.println("ingresa ISBN libro");
                   String isbn=sc.nextLine();
                   System.out.println("Ingresa el titulo");
                   String titulo=sc.nextLine();
                   System.out.println("ingresa el autor");
                   String autor=sc.nextLine();
                   System.out.println("ingresa el valor");
                   double precio=Double.parseDouble(sc.nextLine());
                   libreria.anadirLibro(isbn, titulo, autor, precio);                    
               break;}
               
               case "4":{
                   System.out.println("escribe el ISBN libro");
                   String isbn=sc.nextLine();
                   libreria.borrarLibro(isbn);
               break;} 
               
               case "5":{
                   System.out.println("escribe el autor  libro");
                   String autor=sc.nextLine();
                   libreria.filtrarPorAutor(autor);
               break;}
               
               case "6":{
                   System.out.println("escribe el precio del libro");
                   double precio=Double.parseDouble(sc.nextLine());
                   libreria.filtrarPorPrecio(precio);
               break;}
                
               case "7":{
                   libreria.imprimirCatalogo();
               break;} 
               
               case "8":{
                   System.out.println("------**cerrar programa**---");
               break;}
               
               default:{
                   System.out.println("la opcion introducida es incorrecta");
               break;
           }
       }
        
    }
       }
    
    public static void mostrarMenu(){
        System.out.println("----------------***MENU***------------------");
        System.out.println("1. Cargar Catalogo");
        System.out.println("2. Gurdar Catalogo");
        System.out.println("3. Añadir Nuevo Libro");
        System.out.println("4. Borrar Libro (ISB)");
        System.out.println("5. Filtrar Autor");
        System.out.println("6. Filtrar Precio");
        System.out.println("7. Imprimir Catalogo");
        System.out.println("8. Salir");
    }
    
     
    
}
