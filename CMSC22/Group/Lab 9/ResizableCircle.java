public class ResizableCircle extends Circle implements Resizable {

	public ResizableCircle(double radius) {
		super(radius);
	}

	public void resize(int percent) {
		double percentage = (double)(percent) / 100;
		double tempResult = radius * percentage;
		radius += tempResult;
		System.out.println("new radius: " + radius);
	}
}