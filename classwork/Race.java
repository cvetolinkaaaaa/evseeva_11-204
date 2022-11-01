public class Race {

    public int time;

    static void start (CasualCar car1, F1Car car2, int time) {
        int s1 = 0;
        int s2 = 0;
        for (int i = time; i > 0 ; i--) {
            if (i>3) {
                s1 += car1.speedAfter;
                s2 += car2.speedAfter;
            }
            if (i<3) {
                s1 += car1.speedFirst3Minutes;
                s2 += car2.speedFirst3Minutes;
            }
        }
        if (s1>s2) {
            car1.beep();
        } else if (s2>s1){
            car2.beep();
        }


    }
}
