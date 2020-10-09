public class Square extends Shape2D {
    private final double length;
    private final String name;

    public Square(double length) {
        super();
        this.length = length;
        this.name = "square";
    }

    public double getArea(){
        return (length * length);
    }
    public String getName(){return name;}
}
