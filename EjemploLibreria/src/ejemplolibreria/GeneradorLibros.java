
package ejemplolibreria;

import java.util.ArrayList;
import java.util.Random;

public class GeneradorLibros {
    
    public ArrayList<Libro> generarLibros(int n){
       
        ArrayList<Libro> resultado = new ArrayList<Libro>();
        for(int i=0; i<n; i++){
            
          Libro l = new Libro(this.generarISBN(),this.generarTitulo(),
                              this.generarAutor(),this.gereradorPrecio()); 
          resultado.add(l);
        }
        
        return resultado;
        
    }
    
    public String generarISBN(){
      Random r = new Random(); 
      String resultado="";
      
      for(int i=0; i<10; i++){
         
          if(i%3==0){
             resultado+="-"; 
          }
          resultado+=Integer.toString(r.nextInt(10));
      }
      
      return resultado;
    }
    
    public String generarTitulo(){
        String resultado ="";        
        String[] p1={"luna ","sol ","barco "," arbol "," mar "," corazon "," amor "," ballena "," pez "," llanura "}; 
        String[] p2={" de"," el "," la "," los "," las "," con "," sin "}; 
        String[] p3={" salvaje "," apacionado "," traicion "," perros "," tiempo "," rabia "," celos "," amargura "}; 
        Random r = new Random(); 
        
        resultado = p1[r.nextInt(p1.length)] + p2[r.nextInt(p2.length)] +
                    p3[r.nextInt(p3.length)];
        
        return resultado;   
    }
      
    public String generarAutor(){
        String resultado ="";        
        String[] p1={" Pepe "," Ardila "}; 
        String[] p2={" Charrasqueado "," Juan "}; 
        Random r = new Random(); 
        
        resultado = p1[r.nextInt(p1.length)] + p2[r.nextInt(p2.length)];
        return resultado;        
    }
    
    public double gereradorPrecio(){
      Random r = new Random(); 
      return r.nextDouble()*100;
    }
        
   
}
