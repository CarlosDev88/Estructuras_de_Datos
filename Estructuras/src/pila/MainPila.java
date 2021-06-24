package pila;

public class MainPila {

	public static void main(String[] args) {
		Pila p = new Pila();
		
		String s1 = "Elemento 1";
		String s2 = "Elemento 2";
		String s3 = "Elemento 3";
		
		p.Push(s1);
		System.out.println("la cima es "+ p.Top());
		p.Push(s2);
		System.out.println("la cima es "+ p.Top());
		p.Push(s3);
		System.out.println("la cima es "+ p.Top());
		
		System.out.println("el tamaño es: " + p.size);	
		
		p.Pop();
		System.out.println("la cima es "+ p.Top());
		p.Pop();
		System.out.println("la cima es "+ p.Top());
		
		System.out.println("el tamaño es: " + p.size);
		

	}

}
