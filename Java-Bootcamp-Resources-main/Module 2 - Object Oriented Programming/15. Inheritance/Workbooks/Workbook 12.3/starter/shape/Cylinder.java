package shape;

public class Cylinder extends Shape {

    private double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public double getVolume() {
        return Math.pow(this.getRadius(), 2) * this.height * Math.PI;
    }
    
    @Override
    public double getArea() {
        return (this.getRadius() * this.height * 2 * Math.PI) + (2*Math.PI*Math.pow(this.getRadius(), 2));
    }

  
}
  