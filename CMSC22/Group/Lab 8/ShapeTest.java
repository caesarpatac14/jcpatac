public class ShapeTest {
	public static void main(String[] args) {

		Shape shape;

		System.out.println("\n===============================================================================================");

		System.out.println("Test default constructor:");
		shape = new Shape();
		System.out.println(shape); // expect color red and is filled

		System.out.println("\nTest setters/getters for Color in Shape:");
		shape.setColor("green");
		System.out.println(shape); // expect color green and is filled

		System.out.println("\nTest setters/getters for Filled in Shape:");
		shape.setFilled(false);
		System.out.println(shape); // expect color green and is not filled

		System.out.println("\nTest overloaded constructor for Shape:");
		shape = new Shape("pink", true);
		System.out.println(shape); // expect color pink and is filled

		System.out.println("\n===============================================================================================");

		System.out.println("\nTest default constructor for Circle:");
		shape = new Circle();
		System.out.println(shape); // expect radius = 1.0

		System.out.println("\nTest first overloaded constructor for Circle:");
		shape = new Circle(5.0);
		System.out.println(shape); //expect radius = 5.0

		System.out.println("\nTest second overloaded constructor for Circle:");
		shape = new Circle(10.2, "black", false);
		System.out.println(shape); // expect radius = 10.2, color = black, not filled

		System.out.println("\nTest setters/getters for radius in Circle:");
		((Circle)shape).setRadius(20.5);
		System.out.println(shape); //expect radius = 20.5

		System.out.println("\nTest Area method in Circle:");
		System.out.println("Area = " + ((Circle)shape).getArea()); // expect result around 1320

		System.out.println("\nTest Perimeter method in Circle:");
		System.out.println("Perimeter: " + ((Circle)shape).getPerimeter()); // expect result around 128

		System.out.println("\n===============================================================================================");

		System.out.println("\nTest for default constructor in Rectangle:");
		shape = new Rectangle();
		System.out.println(shape); // expect width = 1.0 and length 1.0

		System.out.println("\nTest for first overloaded constructor in Rectangle:");
		shape = new Rectangle(2.0, 3.0);
		System.out.println(shape); // expect width = 2.0 and length 3.0

		System.out.println("\nTest for second overloaded constructor in Rectangle:");
		shape = new Rectangle(4.0, 5.0, "violet", false);
		System.out.println(shape); // expect width = 4.0, length = 5.0, color = violet, and not filled

		System.out.println("\nTest setters/getters for width in Rectangle:");
		((Rectangle)shape).setWidth(6.0);
		System.out.println(shape); // expect width = 6.0

		System.out.println("\nTest setters/getters for length in Rectangle:");
		((Rectangle)shape).setLength(7.0);
		System.out.println(shape);

		System.out.println("\nTest for Area method in Rectangle:");
		System.out.println("Area: " + ((Rectangle)shape).getArea()); // expect result = 42.0;

		System.out.println("\nTest for Perimeter method in Rectangle:");
		System.out.println("Perimeter: " + ((Rectangle)shape).getPerimeter()); //expect result = 26.0

		System.out.println("\n===============================================================================================");

		System.out.println("\nTest for first overloaded constructor in Square:");
		shape = new Square(2.0);
		System.out.println(shape);

		System.out.println("\nTest for second overloaded constructor in Square:");
		shape = new Square(3.0, "purple", false);
		System.out.println(shape);

		System.out.println("\nTest setters/getters for side, width, and length in Square:");
		((Square)shape).setSide(4.0);
		System.out.println(shape);

		System.out.println("\nTest for Area method in Square:");
		System.out.println("Area: " + ((Square)shape).getArea()); // expect result = 16.0

		System.out.println("\nTest for Perimeter method in Square:");
		System.out.println("Perimeter: " + ((Square)shape).getPerimeter()); // expect result = 16.0

		System.out.println("\n===============================================================================================");

	}
}