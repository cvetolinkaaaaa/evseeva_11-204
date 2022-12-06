
public class Main {
    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(1,1,1,5,4,5,4,1);
        Rectangle rectangle2 = new Rectangle(-2,9,-2,13,4,13,4,9);
        Rectangle rectangle3 = new Rectangle(-5,-8,-5,-3,0,-3,0,-8);
        System.out.println(rectangle1);
        System.out.println(rectangle1.perimeter());
        System.out.println(rectangle1.square());
        Rectangle[] rectangles1 = {rectangle1, rectangle2,rectangle3};
        Array array1 = new Array(rectangles1);
        System.out.println(array1.perimetres());
        System.out.println(array1.equalities());
        System.out.println(rectangle1.equals(rectangle2));
        System.out.println(rectangle1.equalsDots(rectangle2));

    }

}
