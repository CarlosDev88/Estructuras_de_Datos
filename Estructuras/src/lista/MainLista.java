package lista;

public class MainLista {

	public static void main(String[] args) {
		DoubleLinkedList<String> dl = new DoubleLinkedList<>();
		DoubleLinkedList<String> dl2 = new DoubleLinkedList<>();

		String s1 = "1";
		String s2 = "2";
		String s3 = "3";
		String s4 = "4";

		dl.addLast(s1);
		dl.addLast(s2);
		dl.addLast(s3);
		dl.addLast(s4);

		String s5 = "el nuevo";
		dl.remove(2);
		String resultado;

		while (dl.isEmpty() == false) {
			System.out.println(dl.getFirst());
			dl2.addFirst(dl.getFirst());

			dl.removeFirst();
		}

		dl = dl2;

	}

}
