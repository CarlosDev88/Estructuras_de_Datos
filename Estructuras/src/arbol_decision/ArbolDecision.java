package arbol_decision;

import java.util.Scanner;

import tree.Position;
import tree.binary_tree.BinaryTree;

public class ArbolDecision {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String cadena1 = "";
		String cadena2 = "";

		System.out.println("De que tema quieres que te adivine");
		cadena1 = sc.nextLine();
		a.addRoot(cadena1);

		System.out.println("Dame un ejemplo de un " + a.root().element());
		cadena1 = sc.nextLine();
		a.addLeft(a.root(), cadena1);

		while (cadena2.compareTo("fin") != 0) {
			ArbolDecision.reccorerArbol(a.root());
		}

	}

	public static void reccorerArbol(Position<String> p) {
		Scanner sc = new Scanner(System.in);
		String res1 = "";

		if (a.isLeaf(p)) {
			System.out.println(p.element() + "?");
			res1 = sc.nextLine();

			if (res1.compareToIgnoreCase("si") == 0) {
				System.out.println("Bien acertado !! volvamos a empezar");
				ArbolDecision.reccorerArbol(a.root());

			} else {
				System.out.println("Vaya nunca lo habria adivinado");
				System.out.println("Por favor escribeme la solucion");
				String solucion = sc.nextLine();
				System.out.println("Escribeme la diferencia " + solucion + " Y " + p.element());
				String nodoInterno = sc.nextLine();
				String oldLeaf = p.element();
				a.replace(p, nodoInterno);
				a.addLeft(p, solucion);
				a.addRight(p, oldLeaf);
				System.out.println("volvemos a empezar");
				ArbolDecision.reccorerArbol(a.root());
			}

		} else {
			System.out.println(p.element()+"?");
			res1=sc.nextLine();
			
			if(res1.compareToIgnoreCase("si")==0) {
				if(a.HasLeft(p)) {
					ArbolDecision.reccorerArbol(a.left(p));
				}else {
					System.out.println("¿En que estabas pensando?");
					String res2= sc.nextLine();
					a.addLeft(p, res2);
					System.out.println("Volvemos a empezar");
					ArbolDecision.reccorerArbol(a.root());
				}
				
			}else {//respuesta negativa
				if(a.HasRight(p)) {
					ArbolDecision.reccorerArbol(a.right(p));
				}else {
					System.out.println("¿En que estabas pensando?");
					String res2= sc.nextLine();
					a.addRight(p, res2);
					System.out.println("Volvemos a empezar");
					ArbolDecision.reccorerArbol(a.root());
				}
			}
		}
	}

	static BinaryTree<String> a = new BinaryTree<String>();
	
}
