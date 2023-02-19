import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		char [] stroke = a.toCharArray();
		int c = 0;
		char [] reversedStroke = new char [stroke.length];
		for (int i = stroke.length - 1; i >= 0; i --) {
				reversedStroke[stroke.length - i - 1] = stroke [i];
			
		}
		System.out.println(String.valueOf(reversedStroke));
	}
}