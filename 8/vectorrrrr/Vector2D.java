package vectorrrrr;

public class Vector2D {
    private double x;
    private double y;
    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D vector) {
        Vector2D summVector = new Vector2D();
        summVector.x = x + vector.x;
        summVector.y = y + vector.y;
        return summVector;
    }

    public void add2(Vector2D vector) {
        x += vector.x;
        y += vector.y;
    }

    public Vector2D sub(Vector2D vector) {
        Vector2D minusVector = new Vector2D(x, y);
        minusVector.x = x - vector.x;
        minusVector.y = y - vector.y;
        return minusVector;
    }

    public void sub2(Vector2D vector) {
        x -= vector.x;
        y -= vector.y;
    }

    public Vector2D mult(double chislo) {
        Vector2D multVector = new Vector2D(x, y);
        multVector.x = x * chislo;
        multVector.y = y * chislo;
        return multVector;
    }

    public void mult2(double chislo) {
        x *= chislo;
        y *= chislo;
    }

    @Override
    public String toString() {
        return "Vector (" + x + ", " + y + ")";
    }

    public double length() {
        double len = Math. sqrt(Math. pow(x,2) + Math. pow(y , 2));
        return len;
    }

    public double scalarProduct(Vector2D vector) {
        double scalar = x * vector.x + y * vector.y;
        return scalar;
    }

    public double cos(Vector2D vector) {
        double cosinus = scalarProduct(vector) / (length() * vector.length());
        return cosinus;
    }

    public boolean equals(Vector2D vector) {
        if (x == vector.x && y == vector.y) {
            return true;
        } else {
            return false;
        }
    }


}