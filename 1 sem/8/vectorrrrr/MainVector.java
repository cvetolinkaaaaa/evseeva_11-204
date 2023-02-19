package vectorrrrr;

public class MainVector {
    public static void main(String[] args) {
        Vector2D vector0 = new Vector2D();
        Vector2D vector1 = new Vector2D(1,2);
        Vector2D vector2 = new Vector2D(2,3 );
        System.out.println(vector1.add(vector2));
        vector1.add2(vector2);
        System.out.println(vector1);
        System.out.println(vector1.sub(vector2));
        vector1.sub2(vector2);
        System.out.println(vector1);
        System.out.println(vector1.mult(2));
        vector1.mult2(2);
        System.out.println(vector1);
        System.out.println(vector1.length());
        System.out.println(vector1.scalarProduct(vector2));
        System.out.println(vector1.cos(vector2));
        System.out.println(vector1.equals(vector2));
    }
}
