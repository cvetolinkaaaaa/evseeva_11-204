package Carrrrr;

import Carrrrr.Car;

public class Race {

    public int time;

    static void start (Car car1, Car car2, Car car3, int time) {
        int s1 = car1.countDistance(time);
        int s2 = car2.countDistance(time);
        int s3 = car3.countDistance(time);
        System.out.println("FisrtCar - " + s1 + " " + "SecondCar - " + s2 + " ThirdCar - " + s3);
        if (s1 > s2 && s1 > s3) {
            car1.beep();
        } else if (s2 > s1 && s2 > s3) {
            car2.beep();
        } else if (s3 > s1 && s3 > s2) {
            car3.beep();
        } else if (s1 > s2 && s1 == s3) {
            car1.beep();
            car3.beep();
        } else if (s1 > s3 && s2 == s1) {
            car1.beep();
            car2.beep();
        } else if (s2 > s1 && s2 == s3 ) {
            car3.beep();
            car2.beep();
        } else if (s1 == s2 && s2 == s3) {
            car1.beep();
            car2.beep();
            car3.beep();
        }
    }
}