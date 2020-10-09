public class Pyramid extends Shape3D {
    private final double length;
    private final double width;
    private final double height;
    private final String name;

    public Pyramid(double length, double width, double height) {
        super();
        this.length = length;
        this.width = width;
        this.height = height;
        this.name = "pyramid";
    }

    public double getArea(){
        double retval = sidefacelh();
        retval += sidefacewh();
        retval += base();
        return retval;
    }
    private double sidefacelh(){
        return length * Math.sqrt(Math.pow(width/2, 2)+Math.pow(height,2));
    }
    private double sidefacewh(){
        return width * Math.sqrt(Math.pow(length/2, 2)+Math.pow(height,2));
    }
    private double base(){
        return length * width;
    }

    public double getVolume(){
        return (length * width * height)/3;
    }

    public String getName(){return name;}
}
