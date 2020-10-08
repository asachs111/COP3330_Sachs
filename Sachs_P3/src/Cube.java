public class Cube extends Shape3D {
    private final double length;

    public Cube(double length) {
        super("cube");
        this.length = length;
    }
    public double getArea() {
        return (6 * length * length);
    }

    public double getVolume() {
        return (length * length * length);
    }
}
