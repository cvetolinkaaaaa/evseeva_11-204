import java.util.*;

public class Main5 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt(); 
		int [] b = new int [a];
		for (int i = 0; i < a ; i++) {
			b[i] = scanner.nextInt();
		}
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(sort(b)));

	}
	public static int [] sort (int[] c){
		for (int i = 0; i < c.length; i++) {
			int index = i;
			int min = c[i];
			for (int j = i+1; j < c.length; j++) {
				if (c[j] < min) {
					index = j;
					min = c[j];
				}
			}
			c[index] = c[i];
			c[i] = min;

		}
		return c;


}

}