public class Triangle extends Shape2D {
    private final double length;
    private final double height;
    private final String name;

    public Triangle(double length, double height) {
        super();
        this.length = length;
        this.height = height;
        this.name = "triangle";
    }

    public double getArea() {
        return (length * height)/2;
    }
    public String getName(){return name;}
}
