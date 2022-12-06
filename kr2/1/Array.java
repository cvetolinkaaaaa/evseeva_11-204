public class Array {
    static Rectangle[] rectangles;

    public Array(Rectangle[] rectangles) {
        this.rectangles = rectangles;
    }

    static double perimetres() {
        double sumPerimetres = 0;
        for (int i = 0; i < rectangles.length; i++) {
            sumPerimetres+=rectangles[i].perimeter();
        }
        return sumPerimetres;
    }

    static boolean equalities() {
        boolean flag = false;
        for (int i = 0; i < rectangles.length - 1; i++) {
            if (rectangles[i].equalsDots(rectangles[i+1])) {
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }
}
