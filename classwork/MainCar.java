public class MainCar {
    public static void main(String[] args) {
        CasualCar car1 = new CasualCar(160,60);
        F1Car car2 = new F1Car(150, 220);
        Race.start(car1, car2, 2);
    }
}