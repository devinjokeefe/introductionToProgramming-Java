public class TestResizableCircle {

	public static void main(String[] args) {
		Circle testResizableCircle = new ResizableCircle (100);
		System.out.println("Perimeter of the resized circle is " + testResizableCircle.getPerimeter());
		System.out.println("Area of the reszied circle is " + testResizableCircle.getArea());
	}

}
