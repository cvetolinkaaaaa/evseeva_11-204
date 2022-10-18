import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
	public static void main (String []args) {
		Scanner scanner = new Scanner (System.in); 
		int n = scanner.nextInt();
		int b = scanner.nextInt();
		int sum = 0;

		int []a = new int[n];
		for (int i = 0; i < n-1; i++){
			a[i] = scanner.nextInt();
			while (a[i] > 0) {
				if ((a[i] /= 10 == 3) && (a[i] /= 10 == 5)  ) {
					sum ++;


				}
				
			}


		}
		if (summ == n) {
			System.out.println ("Все числа содержат 3 или 5");
		} else {
			System.out.println ("Не все числа содержат 3 или 5");
		}
	}
}