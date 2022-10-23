import java.util.*;

public class Main3 {
    public static void main (String [] args) {
        Scanner scanner = new Scanner (System.in);
        int len = scanner.nextInt ();
        String [] a = new String[len];
        for (int i = 0; i < len; i++) {
            a[i] = scanner.next();
        }
        System.out.println(Arrays.toString(a));
        smertb(a);
    }

    public static void smertb (String [] a) {
        boolean ans = false;
        for (int i = 0; i<a.length ; i++) {
            for (int j =i+1; j<a.length; j++) {

                char [] char1 = a[i].toCharArray();
                char [] char2 = a[j].toCharArray();
                if (char1.length >= char2.length) {
                    i += 0;
                } else {
                    boolean flag = true;
                    for (int g = 0; g<char1.length; g++){
                        if (char1[g] == char2[g]) {
                            flag = true;
                        } else {
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        System.out.println("строка " + a[i] + " является началом строки " + a[j]);
                        ans = true;
                    }

                }
            }
        }
        if (ans == false) {
            System.out.println("no string");
        }


    }

}