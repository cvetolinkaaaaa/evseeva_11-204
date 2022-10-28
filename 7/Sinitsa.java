public class Sinitsa {
    private int length;
    private int weight;
    private int wingspan;
    private String bellyСolor;
    private boolean hungry;
    private boolean lazy;
    public Sinitsa(int length, int weight, int wingspan, String bellyСolor) {
        this.length = length;
        this.weight = weight;
        this.wingspan = wingspan;
        this.bellyСolor = bellyСolor;
    }
    public Sinitsa (int length, int weight,int wingspan,  boolean hungry, boolean lazy) {
        this.length = length;
        this.weight = weight;
        this.hungry = hungry;
        this.lazy = lazy;
        this.wingspan = wingspan;
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
        if (hungry == true && lazy == false) {
            System.out.println("chikchirik i want to eat");
        } else if (hungry == true && lazy == true) {
            System.out.println("Sinitsa is silent, she doesn't have the strength to chikchirik something ");
        } else if (hungry == false && lazy == true) {
            System.out.println("Sinitsa is silent, because it doesnt want to chikchirik something ");
        } else {
            System.out.println("chikchirik im a happy sinitsa");
        }
    }
    public void sinitsaEstHleb() {
        if (hungry == true) {
            System.out.println("Sinitsa est hleb");
            weight += 10;
        } else {
            System.out.println("Sinitsa pereela, now she has overweight");
            weight += 20;
        }
    }
    public void sinitsaUletaet() {
        if (hungry == true && lazy == true) {
            System.out.println("Sinitsa just lies");
        } else if (hungry == false && lazy == false){
            if (wingspan >= 13) {
                System.out.println("Sinitsa uletela v Dubai");
            } else {
                System.out.println("Sinitsa uletela v Sochi");
            }
        } else if ((hungry == true && lazy == false) || (hungry == false && lazy == true)){
            System.out.println("glhf to Sinitsa, ona uletela v Yoshkar-Olu");
        }
    }
    public void sinitsaUmiraet() {
        if (weight >= 25 && (hungry == false && lazy == false)) {
            System.out.println("Sinitsa umerla by overweight");
        }
        if (hungry == true && lazy == true){
            System.out.println("Sinitsa umerla because she was lazy and cant find any food");
        } else {
            System.out.println("gg sinitsa isnt dead");
        }
    }
    public static Sinitsa childSinitsa (Sinitsa sinitsa1, Sinitsa sinitsa2) {
        Sinitsa childSinitsa1 = new Sinitsa (sinitsa1.getLength(), sinitsa1.getWeight(), sinitsa2.getWingspan(), sinitsa2.getBellyСolor());
        return childSinitsa1;
     }
    public static void info(Sinitsa childSinitsa1) {
        System.out.println("длина " + childSinitsa1.getLength() + ", масса " + childSinitsa1.getWeight() + ", размах крыла " + childSinitsa1.getWingspan() + ", цвет пуза " + childSinitsa1.getBellyСolor() );
    }
}
