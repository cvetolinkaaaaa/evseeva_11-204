public class Sinitsa {
    private int length;
    private int weight;
    private int wingspan;
    private String bellyСolor;

    public Sinitsa() {

    }
    public Sinitsa (int length, int weight) {
        this.length = length;
        this.weight = weight;
    }
    public Sinitsa (int wingspan, String bellyСolor) {
        this.wingspan = wingspan;
        this.bellyСolor = bellyСolor;
    }
    public String getBellyСolor() {
        return bellyСolor;
    }

    public void setBellyСolor(String name) {
        this.bellyСolor = bellyСolor;
    }
    public void sinitsaOret() {
        System.out.println("chikchirik");
    }

    public void sinitsaUletaet() {
        System.out.println("Sinitsa Uletela");
    }

    public void sinitsaUmiraet() {
        System.out.println("Sinitsa umerla");
    }
    public void sinitsaEstHleb() {
        System.out.println("Sinitsa est hleb");
    }
    public static Sinitsa childSinitsa (Sinitsa sinitsa1, Sinitsa sinitsa2) {
        Sinitsa childSinitsa1 = (sinitsa1.length, sinitsa1.weight , sinitsa2.wingspan, sinitsa2.bellyСolor);
        return childSinitsa1;
     }
}