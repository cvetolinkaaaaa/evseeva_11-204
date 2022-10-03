import java.util.Scanner;
import java.util.Arrays;

public class Main1 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt(); //число элементов в массиве
		int c = 0;
		int [] b = new int [a];
		for (int i = 0; i < b.length; i++) {
			b[i] = scanner.nextInt();
		}
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 != 0) {
				c += b[i];
			}
		

		}
		System.out.println(c);
	}
}