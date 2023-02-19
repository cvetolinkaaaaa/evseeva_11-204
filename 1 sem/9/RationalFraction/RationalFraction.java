package RationalFraction;

import java.util.*;

public class RationalFraction {
    Scanner Scanner = new Scanner(System.in);
    public int a;
    public int b;
    public RationalFraction() {
        a = 0;
        b = Scanner.nextInt();
    }

    public RationalFraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void reduce(){
        int c = gcd(a,b);
        b /= c;
        a /= c;
    }

    public RationalFraction add(RationalFraction x) {
        RationalFraction add1 = new RationalFraction(a* x.b + x.a * b, b * x.b);
        add1.reduce();
        return add1;
    }

    public void add2(RationalFraction x) {
        int c = a;
        int d = b;
        a = c* x.b - x.a * d;
        b = d * x.b;
        reduce();
    }

    public RationalFraction sub(RationalFraction x) {
            RationalFraction sub1 = new RationalFraction(a* x.b - x.a * b, b * x.b);
            sub1.reduce();
            return sub1;
    }

    public void sub2(RationalFraction x) {
        int e = a;
        int f = b;
        a = e* x.b - x.a *f;
        b = f * x.b;
        reduce();
    }

    public RationalFraction mult(RationalFraction x) {
        RationalFraction mult1 = new RationalFraction(a * x.a, b * x.b );
        mult1.reduce();
        return mult1;
    }

    public void mult2(RationalFraction x) {
        a *= x.a;
        b *= x.b;
        reduce();
    }
    public RationalFraction div(RationalFraction x) {
        RationalFraction div1 = new RationalFraction(a*x.b, b*x.a);
        div1.reduce();
        return div1;
    }

    public void div2(RationalFraction x) {
        int l = a;
        int v = b;
        a =  l * x.b;
        b = v * x.a;
        reduce();
    }

    @Override
    public String toString() {
        if (a<0 && b<0) {
            return -a + "/" + -b;
        } else {
            return a + "/" + b;
        }
    }

    public double value() {
        double o = a;
        o /= b;
        return o;
    }

    public boolean equals(RationalFraction x){
        if (value() == x.value()) {
            return true;
        } else {
            return false;
        }
    }
    public int numberPart() {
        int q = a/b;
        return q;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
            }
        return gcd(b, a % b);
        }
}