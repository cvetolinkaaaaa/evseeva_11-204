public class Game {
    static void fight (Person person1, Person person2) {
        while (person1.hp>0 && person2.hp>0) {
            person1.hit(person2);
            System.out.println(person2.name + " " + " " + person2.hp);
            person2.hit(person1);
            System.out.println(person1.name + " " + " " + person1.hp);
        }
        if (person1.hp <= 0) {
            System.out.println(person2.name);
        } else if (person2.hp <= 0) {
            System.out.println(person1.name);
        }
    }
}
