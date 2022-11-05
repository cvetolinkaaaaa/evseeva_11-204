package Carrrrr;

public class Car {
    public int speedFirst3Minutes;
    public int speedAfter;

    public Car(int speedFirst3Minutes, int speedAfter) {
        this.speedFirst3Minutes = speedFirst3Minutes;
        this.speedAfter = speedAfter;
    }

    public Car() {
    }

    public void beep() {
        System.out.println("beep beep");
    }

    public int countDistance(int duration) {
        int s1 = 0;
        for (int i = duration; i > 0; i--) {
            if (i > 3) {
                s1 += speedAfter;
            }
            if (i <= 3) {
                s1 += speedFirst3Minutes;
            }
        }
        return s1;
    }
}

