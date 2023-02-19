package Carrrrr;

import Carrrrr.Car;

public class F1Car extends Car {
    public F1Car(int speedFirst3Minutes, int speedAfter){
        super(speedFirst3Minutes,speedAfter);
    }
    @Override
    public void beep(){
        System.out.println("aaaa");
    }

}