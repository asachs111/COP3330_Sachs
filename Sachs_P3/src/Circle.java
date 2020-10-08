public class Circle extends Shape2D {
    private final double radius;


    public Circle(double radius) {
        super("circle");
        this.radius = radius;
    }

    public double getArea() {
        return (3.1415 * (radius * radius));
    }
}
