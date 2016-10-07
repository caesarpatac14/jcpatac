public class Circle extends Shape {
    private double radius = 1.0;
  
    public Circle() {
        radius = 1.0;
    }
  
    public Circle(double radius) {
        this.radius = radius;
    }
  
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }
  
    public double getRadius() {
        return radius;
    }
  
    public void setRadius(double radius) {
        this.radius = radius;
    }
  
    public double getArea() {
        return (Math.PI * (Math.pow(radius, 2)));
    }
  
    public double getPerimeter() {
        return (Math.PI * (radius * 2));
    }
  
    public String toString() {
        String result = "A Circle with radius = " + radius + ", which is a subclass of " + super.toString();
        return result;
    }
}