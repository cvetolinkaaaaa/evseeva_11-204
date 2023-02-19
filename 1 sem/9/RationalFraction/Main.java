package RationalFraction;

public class Main {
    public static void main(String[] args) {
        RationalFraction a1 = new RationalFraction(14,-6);
        RationalFraction a2 = new RationalFraction(1,6);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a1.add(a2));
        a1.add2(a2);
        System.out.println(a1);
        System.out.println(a1.sub(a2));
        a1.sub2(a2);
        System.out.println(a1);
        System.out.println(a1.mult(a2));
        a1.mult2(a2);
        System.out.println(a1);
        System.out.println(a1.div(a2));
        a1.div2(a2);
        System.out.println(a1);
        System.out.println(a1.value());
        System.out.println(a1.equals(a2));
        System.out.println(a1.numberPart());

    }
}
