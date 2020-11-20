public class Circle implements GeometricObject {

	protected double radius = 1.0;
	
	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * radius * Math.PI;
		perimeter = Math.round(perimeter * 100.0) / 100.0;
		return perimeter;
	}

	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		area = Math.round(area * 100.0) / 100.0;
		return area;
	}

}
