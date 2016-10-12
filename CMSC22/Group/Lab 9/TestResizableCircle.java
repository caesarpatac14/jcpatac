public class TestResizableCircle {
	public static void main(String[] args) {

		ResizableCircle circle = new ResizableCircle(2.0);

		circle.resize(100); // expect 4.0
		circle.resize(-50); // expect 2.0;
		circle.resize(50); // expect 3.0;
		circle.resize(10); // expect 3.3;
		circle.resize(0); // expect 3.3;
	}
}