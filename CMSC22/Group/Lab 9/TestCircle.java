public class TestCircle {
	public static void main(String[] args) {

		GeometricObject circle = new Circle(5.0);
		System.out.println("Perimeter: " + circle.getPerimeter());
		System.out.println("Area: " + circle.getArea());
		
	}
}