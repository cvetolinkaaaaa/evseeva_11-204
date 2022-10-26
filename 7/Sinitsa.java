public class Sinitsa {
    private int length;
    private int weight;
    private int wingspan;
    private String bellyСolor;

    public Sinitsa(int length, int weight, int wingspan, String bellyСolor) {
        this.length = length;
        this.weight = weight;
        this.wingspan = wingspan;
        this.bellyСolor = bellyСolor;
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
    public void setBellyСolor(String bellyСolor) {
        this.bellyСolor = bellyСolor;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }
    public void setWingspan(int wingspan) {
        this.wingspan = wingspan;
    }
    public int getWingspan() {
        return wingspan;
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
        Sinitsa childSinitsa1 = new Sinitsa (sinitsa1.getLength(), sinitsa1.getWeight(), sinitsa2.getWingspan(), sinitsa2.getBellyСolor());
        return childSinitsa1;
     }
    public static void info(Sinitsa childSinitsa1) {
        System.out.println("длина " + childSinitsa1.getLength() + ", масса " + childSinitsa1.getWeight() + ", размах крыла " + childSinitsa1.getWingspan() + ", цвет пуза " + childSinitsa1.getBellyСolor() );
    }

}