import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();
		int c = 1;
		while (a>0) {
			c *= a;
			a -= 1;
		}
		System.out.println(c);

	}
}