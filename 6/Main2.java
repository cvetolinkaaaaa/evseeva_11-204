import java.util.*;
public class Main2 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        String[] c = new String[a + 1];
        for (int i = 0; i < a + 1; i++) {
            c[i] = "";
        }
        int[] b = new int[a];
        for (int i = 0; i < a; i++) {
            b[i] = scanner.nextInt();
        }
        sort(b);
        int numb = -1002;
        for (int i = 0; i < a ; i++) {
            if(b[i] != numb){
                int count = 0;
                for (int j = i; j < a; j++) {
                    if (b[i] == b[j]) {
                        count += 1;
                    }
                }
                c[count-1] += "" + b[i] + " ";
                numb= b[i];
            }
        }
        System.out.println(Arrays.toString(c));
        for (int d = 0; d<a; d++) {
            if (c[d] != "") {
                System.out.println(d+1 + " time: " + c[d]);
            }
        }
    }
    public static int [] sort (int[] c){
        for (int i = 0; i < c.length; i++) {
            int index = i;
            int min = c[i];
            for (int j = i+1; j < c.length; j++) {
                if (c[j] < min) {
                    index = j;
                    min = c[j];
                }
            }
            c[index] = c[i];
            c[i] = min;
        }
        return c;
    }
}
