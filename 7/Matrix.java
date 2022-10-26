import java.util.*;

public class Matrix {
    private int[][] innerMatrix;

    public Matrix(int len){
        innerMatrix = new int[len][len];
    }

    public int getElement(int i, int j){
        return innerMatrix[i][j];
    }

    public void setElement(int i, int j,int value){
        innerMatrix[i][j] = value;
    }

    public int getMatrixSize(){
        return innerMatrix.length;
    }

    public void printMatrix(){
        for (int i = 0; i <innerMatrix.length ; i++) {
            System.out.println(Arrays.toString(innerMatrix[i]));
        }
    }
    public int opredelitel() {
        int opredelitel1 = 0;
        if (innerMatrix.length != 3) {
            throw new RuntimeException("Чтобы посчитать определитель, введите матрицу размерностью 3");
        } else {
            opredelitel1 = innerMatrix[0][0]*innerMatrix[1][1]*innerMatrix[2][2]+innerMatrix[0][1]*innerMatrix[1][2]*innerMatrix[2][0]+innerMatrix[1][0]*innerMatrix[2][1]*innerMatrix[0][2]-innerMatrix[0][2]*innerMatrix[1][1]*innerMatrix[2][0]-innerMatrix[2][1]*innerMatrix[1][2]*innerMatrix[0][0]-innerMatrix[1][0]*innerMatrix[0][1]*innerMatrix[2][2];
        }
        return opredelitel1;
    }
    public int sum() {
        int sum1 = 0;
        for (int i = 0; i <innerMatrix.length ; i++) {
            for (int j = 0; j <innerMatrix.length ; j++) {
                sum1 += innerMatrix[i][j];
            }
        }
        return sum1;
    }


}