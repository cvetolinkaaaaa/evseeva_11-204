import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String [5];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = (scanner.nextLine());
        }
        for (int i = 0; i < strings.length; i++) {
            Pattern pattern = Pattern.compile("(10)+|(01)+|1+|0+|(10)+1|(01)+0");
            Matcher matcher = pattern.matcher(strings[i]);
            System.out.println(matcher.matches());
            if (matcher.matches()) {
                System.out.println(i);
            }

        }
    }
}
