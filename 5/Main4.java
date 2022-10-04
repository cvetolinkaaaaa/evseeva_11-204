import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int sum = 0;
		int kolvo = 0;
		boolean a = true;
		int[][] matrix = new int[k][k];
		for (int i =0;i<k ;i++ ) {
			for (int j = 0;j<k ;j++ ) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		printMatrix(matrix);
		for (int i =0;i<k ;i++ ) {
					for (int j = 0;j<k ;j++ ) {
							if (i == j) {
								sum += matrix[i][j];
							}
					}
		}
		if (sum % 2 == 0) {
			a = true;
		} else {
			a = false;
		}
		System.out.println(a);

	}

	public static void printMatrix(int[][] matrix){
		for (int i =0;i<matrix.length ;i++ ) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}


}