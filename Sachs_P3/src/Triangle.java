public class Triangle extends Shape2D {
    private final double length;
    private final double height;

    public Triangle(double length, double height) {
        super("triangle");
        this.length = length;
        this.height = height;
    }

    public double getArea() {
        return (length * height)/2;
    }
}
