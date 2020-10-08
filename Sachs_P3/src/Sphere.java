public class Sphere extends Shape3D {
    private final double radius;

    public Sphere(double radius) {
        super("sphere");
        this.radius = radius;
    }

    public double getArea(){
        return 4 * 3.141592 * Math.pow(radius,2);
    }
    public double getVolume(){
        return (4 * 3.141592/3) * Math.pow(radius,3);
    }
}
