import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.print(" Значение 1:");
		System.out.print(a);
		System.out.print(" Значение 2:");
		System.out.println(b);
		a += b;
		b = a - b;
		a = a - b;
		System.out.print(" Измененное начение 1:");
		System.out.print(a);
		System.out.print(" Измененное Значение 2:");
		System.out.println(b);

	}
}