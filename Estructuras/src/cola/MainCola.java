package cola;

public class MainCola {

	public static void main(String[] args) {
		
		Cola c = new Cola();
		String s1="1. Pedro";
		String s2="2. Pablo";
		String s3="3. Jacinto";
		
		c.Enqueue(s1);
		c.Enqueue(s2);
		c.Enqueue(s3);
		
		c.Dequeue();
				
		System.out.println(c.Front().toString());
		

	}

}
