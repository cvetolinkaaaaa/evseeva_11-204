package Carrrrr;

import java.security.interfaces.RSAMultiPrimePrivateCrtKey;
import java.util.*;

public class BoostedCar extends Car {
    public int boostStartTime;
    public BoostedCar(int speedFirst3Minutes, int speedAfter, int boostStartTime){
        super(speedFirst3Minutes,speedAfter);
        this.boostStartTime = boostStartTime;
    }

    public BoostedCar(int speedFirst3Minutes, int speedAfter){
        super(speedFirst3Minutes,speedAfter);
        boostStartTime = -100000000;
    }

    @Override
    public void beep(){
        System.out.println("trrrrash");
    }

    @Override
    public int countDistance(int duration) {
        int[] array = new int[duration];
        int s1 = 0;
        for (int i = 0; i < duration; i++) {
            if (i < 3) {
                array[i] += speedFirst3Minutes;
            } else {
                array[i] += speedAfter;
            }
        }
        if (boostStartTime <= duration && boostStartTime > 0) {
            for (int i = boostStartTime - 1; i < boostStartTime + 2; i++) {
                array[i] = array[i] * 2;
                if (i == duration ) {
                    break;
                }
            }
        }
        for (int i = 0; i < duration ; i++) {
            s1 += array[i];
        }
        return s1;
    }
}
