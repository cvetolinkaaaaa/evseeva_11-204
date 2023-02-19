package Carrrrr;

public class MainCar {
    public static void main(String[] args) {
        CasualCar car1 = new CasualCar(12,15);
        F1Car car2 = new F1Car(13, 12);
        BoostedCar car3 = new BoostedCar(17, 20, 0 );
        Race.start(car1, car2, car3, 5);
    }
}