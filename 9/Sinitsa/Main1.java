package Sinitsa;

public class Main1 {
    public static void main(String[] args) throws SinitsaException {
        Sinitsa sinitsa1 = new Sinitsa(12, 10, 14, true, false);
//        Sinitsa.Sinitsa sinitsa2 = new Sinitsa.Sinitsa(47, "yellow" );
//        Sinitsa.Sinitsa sinitsa3 = Sinitsa.Sinitsa.childSinitsa(sinitsa1, sinitsa2);
//        sinitsa1.sinitsaOret();
//        sinitsa1.sinitsaUletaet();
//        sinitsa1.sinitsaUmiraet();
//        sinitsa1.sinitsaEstHleb();
//        Sinitsa.Sinitsa.info(sinitsa3);
        System.out.println(sinitsa1.sinitsaFeedsChildren(sinitsa1));

    }
}