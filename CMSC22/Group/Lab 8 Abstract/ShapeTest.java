public class ShapeTest {
	public static void main(String[] args) {
		Shape s1 = new Circle(5.5, "RED", false);  // Upcast Circle to Shape
		
		System.out.println(s1);                    // which version? ANS: The toString version that will be executed is the method
												   // in Circle class because it will override the toString mehod in the super class

		System.out.println(s1.getArea());          // which version? ANS: The getArea version that will be executed is the method
												   // in Circle class because in the Shape class, the method getArea is declared abstract.

		System.out.println(s1.getPerimeter());     // which version? ANS: The getPerimeter version that will be executed is the method
												   // in Circle class because in the Shape class, the getPerimeter method is declared abstract.
		System.out.println(s1.getColor());
		System.out.println(s1.isFilled());

		//System.out.println(s1.getRadius()); NOTE: This will not work because the Shape class has no getRadius method and object s1 is of type Shape.
												//  For this to work, we must create a method called getRadius in the Shape class. But this violates the characteristics
												//  of the shapes because not all shapes have radius.

		System.out.println("==========================================================================");
   
		Circle c1 = (Circle)s1;                   // Downcast back to Circle
		System.out.println(c1);
		System.out.println(c1.getArea());
		System.out.println(c1.getPerimeter());
		System.out.println(c1.getColor());
		System.out.println(c1.isFilled());
		System.out.println(c1.getRadius());

		// NOTE: Because of downcasting, method getRadius, which is present in the class Circle, is executed.

		System.out.println("==========================================================================");
   
		//Shape s2 = new Shape(); NOTE: This will not work because s2 is of type Shape and the class Shape was declared as abstract.
									//  This means that Shape cannot be instantiated because it is abstract.
   
		Shape s3 = new Rectangle(1.0, 2.0, "RED", false);   // Upcast

		System.out.println(s3);
		System.out.println(s3.getArea());
		System.out.println(s3.getPerimeter());
		System.out.println(s3.getColor());
		// System.out.println(s3.getLength()); NOTE: This will not work because the Shape class has no getLength method and object s3 is of type Shape.
												//  For this to work, we must create a method called getLength in the Shape class. But this violates the characteristics
												//  of the shapes because not all shapes have Length.

		System.out.println("==========================================================================");
   
		Rectangle r1 = (Rectangle)s3;   // downcast
		System.out.println(r1);
		System.out.println(r1.getArea());
		System.out.println(r1.getColor());
		System.out.println(r1.getLength());

		// NOTE: Because of downcasting, method getLength, which is present in the class Rectangle, is executed.

		System.out.println("==========================================================================");
   
		Shape s4 = new Square(6.6);     // Upcast
		System.out.println(s4);
		System.out.println(s4.getArea());
		System.out.println(s4.getColor());
		// System.out.println(s4.getSide()); NOTE: This will not work because the Shape class has no getSide method and object s3\4 is of type Shape.
												//  For this to work, we must create a method called getSide in the Shape class. But this violates the characteristics
												//  of the shapes because not all shapes have Side.

		System.out.println("==========================================================================");
  
		// Take note that we downcast Shape s4 to Rectangle, 
		//  which is a superclass of Square, instead of Square
		Rectangle r2 = (Rectangle)s4;
		System.out.println(r2);
		System.out.println(r2.getArea());
		System.out.println(r2.getColor());
		// System.out.println(r2.getSide()); NOTE: This will not work because the Rectangle class has no getSide method and object r2 is of type Rectangle.
												//  For this to work, we must create a method called getSide in the Shape class. But because its not stated
												//  in the class diagram, we will violate the client's specs if we create this method.
		System.out.println(r2.getLength());

		System.out.println("==========================================================================");
   
		// Downcast Rectangle r2 to Square
		Square sq1 = (Square)r2;
		System.out.println(sq1);
		System.out.println(sq1.getArea());
		System.out.println(sq1.getColor());
		System.out.println(sq1.getSide());
		System.out.println(sq1.getLength());

		// NOTE: Because of downcasting, method getSide, which is present in the class Square, is executed.
	}
}