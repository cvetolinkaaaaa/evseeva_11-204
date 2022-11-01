public class Game {
    static void fight (Person person1, Person person2) {
        while (person1.hp>0 && person2.hp>0) {

            person1.hit(person2);
            if (person1.hp <= 0 || person2.hp <= 0) {
                break;
            }
            person2.hit(person1);
        }
        if (person1.hp <= 0) {
            System.out.println(person1.name);
        } else if (person2.hp <= 0) {
            System.out.println(person2.name);
        }
    }
}