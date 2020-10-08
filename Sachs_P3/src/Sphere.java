public class Sphere extends Shape3D {
    private final double radius;

    public Sphere(double radius) {
        super("sphere");
        this.radius = radius;
    }

    public double getArea(){
        return 0;
    }
    public double getVolume(){
        return 0;
    }
}
