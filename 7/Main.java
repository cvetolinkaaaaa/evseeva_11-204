import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        Matrix matrix1 = new Matrix(len);
        for (int i = 0; i < matrix1.getMatrixSize(); i++) {
            for (int j = 0; j <matrix1.getMatrixSize() ; j++) {
                matrix1.setElement(i,j,scanner.nextInt());
            }
        }
        matrix1.printMatrix();
        System.out.println(matrix1.sum());
        System.out.println(matrix1.opredelitel());



    }
}