import java.util.Scanner;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a1 = scanner.nextInt();
		int a2 = scanner.nextInt();
		int n = scanner.nextInt();
		int d = a2 - a1;
		int an = a1 + d * (n - 1);
		System.out.println(an);
	}
}