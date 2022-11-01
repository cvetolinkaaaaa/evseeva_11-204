public class Car {
    public int speedFirst3Minutes;
    public int speedAfter;

    public Car(int speedFirst3Minutes, int speedAfter) {
        this.speedFirst3Minutes = speedFirst3Minutes;
        this.speedAfter = speedAfter;
    }

    public Car(){
    }

    public void beep(){
        System.out.println("beep beep");
    }
}