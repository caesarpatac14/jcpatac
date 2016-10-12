public class Circle implements GeometricObject {

	protected double radius = 1.0;

	public Circle(double radius) {
		this.radius = radius;
	}

	public double getPerimeter() {
		return (Math.PI * (radius * 2));
	}

	public double getArea() {
		return (Math.PI * (Math.pow(radius, 2)));
	}
}