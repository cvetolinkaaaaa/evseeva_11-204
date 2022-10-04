import java.util.*;

public class Main2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		double sum = 0;
		int kolvo = 0;
		int[][] matrix = new int[k][k];
		for (int i =0;i<k ;i++ ) {
			for (int j = 0;j<k ;j++ ) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		printMatrix(matrix);
		for (int i =0;i<k ;i++ ) {
					for (int j = 0;j<k ;j++ ) {
							if (i%2 == 0 && j%2 !=0) {
								sum += matrix[i][j];
								kolvo ++;
							}
					}
		}
		double middle = sum / kolvo;
		System.out.println (middle);

	}

	public static void printMatrix(int[][] matrix){
		for (int i =0;i<matrix.length ;i++ ) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}


}