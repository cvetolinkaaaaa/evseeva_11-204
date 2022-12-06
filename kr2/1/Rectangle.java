public class Rectangle {
    //x1,y1 - координаты левого нижнего угла
    // x2,y2 - координаты левого верхнего угла
    //x3,y3 - координаты правого верхнего угла
    //x4,y4 - координаты правого нижнего угла
    int x1;
    int y1;
    int x2;
    int y2;
    int x3;
    int y3;
    int x4;
    int y4;


    public Rectangle(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.x4 = x4;
        this.y4 = y4;
    }
    public double side1(){
        double sideOne = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        return sideOne;
    }
    public double side2(){
        double sideTwo = Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
        return sideTwo;
    }
    public double perimeter() {
        double perimeter = 2*side1()+ 2*side2();
        return perimeter;
    }
    public double square() {
        double square = side1()*side2();
        return square;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "координата левого нижнего угла x1=" + x1 +
                ",координата левого нижнего угла x1 y1=" + y1 +
                ",координата левого верхнего угла x2=" + x2 +
                ",координата левого верхнего угла y2=" + y2 +
                ",координата правого верхнего угла x3=" + x3 +
                ",координата правого верхнего угла y3=" + y3 +
                ",координата правого нижнего угла x4=" + x4 +
                ",координата правого нижнего угла y4=" + y4 +
                '}';
    }
    public boolean equalsDots(Rectangle rectangle) {
        if ((x1==rectangle.x1 && y1==rectangle.y1) ||(x2==rectangle.x2 && y2==rectangle.y2) || (x3==rectangle.x3 && y3==rectangle.y3) ||(x4==rectangle.x4 && y4==rectangle.y4)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean equals(Rectangle rectangle) {
        if ((x1==rectangle.x1 && y1==rectangle.y1) &&(x2==rectangle.x2 && y2==rectangle.y2) &&(x3==rectangle.x3 && y3==rectangle.y3) &&(x4==rectangle.x4 && y4==rectangle.y4)) {
            return true;
        } else {
            return false;
        }
    }

}
