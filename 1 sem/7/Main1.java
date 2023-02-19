import java.util.*;

public class Main1 {
    public static void main(String[] args) {
    Sinitsa sinitsa1 = new Sinitsa(12, 10, 14, true, false);
    Sinitsa sinitsa2 = new Sinitsa(47, "yellow" );
    Sinitsa sinitsa3 = Sinitsa.childSinitsa(sinitsa1, sinitsa2);
    sinitsa1.sinitsaOret();
    sinitsa1.sinitsaUletaet();
    sinitsa1.sinitsaUmiraet();
    sinitsa1.sinitsaEstHleb();
    Sinitsa.info(sinitsa3);
    }
}
