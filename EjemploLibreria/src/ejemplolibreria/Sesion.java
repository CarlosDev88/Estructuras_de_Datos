
package ejemplolibreria;

import java.io.*;
import java.util.*;

public class Sesion {
    ArrayList<Libro> catalogo;

    public Sesion() {
    }

    public Sesion(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }

    public ArrayList<Libro> getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(ArrayList<Libro> catalogo) {
        this.catalogo = catalogo;
    }
    
    public void guardarCatalogo() throws FileNotFoundException, IOException{
        
       Scanner sc = new Scanner(System.in); 
       System.out.println("escribe el nombre del archivo destino");
       String fileName = sc.nextLine();
       
       FileOutputStream escritor = new FileOutputStream(fileName);
       ObjectOutputStream salida = new ObjectOutputStream(escritor);
       
       salida.writeObject(catalogo);
       salida.close(); 
    }
    
    public ArrayList<Libro> cargarCatalogo() throws FileNotFoundException, IOException, ClassNotFoundException{
        
       Scanner sc = new Scanner(System.in); 
       System.out.println("escribe el nombre del archivo origen");
       String fileName = sc.nextLine();
       
       FileInputStream lector = new FileInputStream(fileName);
       ObjectInputStream entrada = new ObjectInputStream(lector);
       
       ArrayList<Libro>lista = (ArrayList<Libro>) entrada.readObject();   
       return lista;
    }
    
   
}
