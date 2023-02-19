public class Person {
    public String name;
    public int strength;
    public int hp;

    public Person(String name, int strength, int hp) {
        this.name = name;
        this.strength = strength;
        this.hp = hp;
    }

    public void hit (Person person) {
        int hit1 = 0;
        double aaa = (110 - strength * 10)/100;
        double probability = Math.random();
        if (probability <= aaa) {
            person.hp = person.hp - strength;
        } else {
            person.hp = person.hp - strength;
        }
    }
}

