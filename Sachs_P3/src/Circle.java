public class Circle extends Shape2D {
    private final double radius;
    private final String name;


    public Circle(double radius) {
        super();
        this.radius = radius;
        this.name = "circle";
    }

    public double getArea() {
        return (3.1415 * (radius * radius));
    }

    public String getName() {return name;}
}
