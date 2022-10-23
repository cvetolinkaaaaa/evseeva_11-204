import java.util.*;

public class Main1 {
    public static void main (String [] args){
        Scanner Scanner = new Scanner(System.in);
        int len = Scanner.nextInt();
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i=0;i<len;i++) {
            a[i] = Scanner.nextInt();
            b[i] = a[i];
        }
        System.out.println(sort(a));
        System.out.println(sort1(b));

    }
    public static double sort(int[] arr){
        double swaps1 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    int currEl = arr[i];
                    arr[i] = arr[j];
                    arr[j] = currEl;
                }
                swaps1 += 1;
            }
        }
        System.out.println(Arrays.toString(arr));
        return swaps1;
    }
    public static double sort1(int[] arr) {
        double swaps2 = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]){
                    int currEl = arr[i];
                    arr[i] = arr[j];
                    arr[j] = currEl;
               
                }
                swaps2 += 1;
                
            }
        }
        System.out.println(Arrays.toString(arr));
        return swaps2;
    }
}