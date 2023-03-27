package shape;

public class Cylinder extends Shape {

    private double height;

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
  
}
  