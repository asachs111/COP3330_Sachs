public class Cube extends Shape3D {
    private final double length;
    private final String name;
    public Cube(double length) {
        super();
        this.length = length;
        this.name = "cube";
    }
    public double getArea() {
        return (6 * length * length);
    }
    public double getVolume() {
        return (length * length * length);
    }

    public String getName(){return name;}
}
