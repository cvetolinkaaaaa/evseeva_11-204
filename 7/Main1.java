import java.util.*;

public class Main1 {
    public static void main(String[] args) {
    Sinitsa sinitsa1 = new Sinitsa(12, 53);
    Sinitsa sinitsa2 = new Sinitsa(47, "yellow" );
    sinitsa1.sinitsaOret();
    sinitsa1.sinitsaUletaet();
    sinitsa1.sinitsaUmiraet();
    sinitsa1.sinitsaEstHleb();
    System.out.println(Sinitsa.childSinitsa());

    }
}
