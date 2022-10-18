import java.util.Scanner;
import java.util.Arrays;

public class Main4 {
	public static void main (String []args) {
		Scanner scanner = new Scanner (System.in);
		int k = scanner.nextInt (); 
		int[][] matrix = new int[k][k];
		for (int i =0;i<k ;i++ ) {
			for (int j = 0;j<k ;j++ ) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		int sum = 0;
		double kolvo = 0.0; 
		for (int i =0;i<k ;i++ ) {
			for (int j = 0;j<k ;j++ ) {
				if ((i == j) || (i+j == n) || ((i>j) && (i+j<k)) || ((i<j) && (i+j>=k))) {
					sum+=a[i][j];
					kolvo++;

				}
			}
		}
		double sr = sum / kolvo;
		System.out.println(sr);
	}
}