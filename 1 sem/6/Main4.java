import java.util.*;

public class Main4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int k = scanner.nextInt();
		int[][] matrix = new int[k][k];
		String str = scanner.next();
		for (int i =0;i<k ;i++ ) {
			for (int j = 0;j<k ;j++ ) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		printMatrix(matrix);
		double sum = 0;
		int kolvo = 0;
		double srznach = 0;

		switch (str) {

			case "green":
				for (int i =0;i<k ;i++ ) {
					for (int j = 0;j<k ;j++ ) {
						if ((j<(k/2)) && (i<(k/2)) && (i < j) && ((i+j) < (k - 1))){
							sum += matrix [i][j];
							kolvo+=1;
						}
					}
				}
				srznach = sum / kolvo;
				break;

			case "red":
				for (int i =0;i<k ;i++ ) {
					for (int j =0;j<k ;j++ ) {
						if ((j<(k/2)) && (i>(k/2)) && (i > j) && ((i+j) > (k - 1))) {
							sum += matrix [i][j];
							kolvo+=1;
						}
					}
				}
				srznach = sum / kolvo; 
				break;

			case "yellow":
				for (int i =0;i<k ;i++ ) {
					for (int j =0;j<k ;j++ ) {
						if ((j>(k/2)) && (i<(k/2)) && (i < j) && ((i+j) > (k - 1))) {
							sum += matrix [i][j];
							kolvo+=1;
						}
					}
				}
				srznach = sum / kolvo;
				break;

			default:
				System.out.println("Введите red, green или yellow");
				break;

		}
		System.out.println(srznach);

	}

	public static void printMatrix(int[][] matrix){
		for (int i =0;i<matrix.length ;i++ ) {
			System.out.println(Arrays.toString(matrix[i]));
		}
	}
}