public class Sphere extends Shape3D {
    private final double radius;
    private final String name;

    public Sphere(double radius) {
        super();
        this.radius = radius;
        this.name = "sphere";
    }

    public double getArea(){
        return 4 * 3.141592 * Math.pow(radius,2);
    }
    public double getVolume(){
        return (4 * 3.141592/3) * Math.pow(radius,3);
    }

    public String getName(){return name;}
}
