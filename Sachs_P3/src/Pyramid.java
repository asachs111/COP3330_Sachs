public class Pyramid extends Shape3D {
    private final double length;
    private final double width;
    private final double height;

    public Pyramid(double length, double width, double height) {
        super("pyramid");
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getArea(){
        return 0;
    }
    public double getVolume(){
        return 0;
    }
}
