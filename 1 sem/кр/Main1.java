import java.util.Scanner;

public class Main1 {
	public static void main (String []args) {
		Scanner scanner = new Scanner (System.in);
		double x = scanner.nextDouble();
		double y = scanner.nextDouble();
		if ( Math.log(x,2)+Math.abs(y)==2) {
			System.out.println("Точка лежит на графике");
		} else {
			System.out.println("Точка не лежит на графике");
		}
	}
}