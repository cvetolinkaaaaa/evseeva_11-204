import java.util.Scanner;
import java.util.Arrays;

public class Main4 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int [] b = new int [a];
		for (int i = 0; i < b.length; i++) {
			b[i] = scanner.nextInt();
		}
		for (int i = 0; i < (b.length - 2); i++) {
			if (b[i+2] - b[i+1] == b[i+1] - b[i]) {
				System.out.println("Арифметическая прогрессия");
			} else {
				System.out.println("Не арифметическая прогрессия");
			}
		}
	}
}