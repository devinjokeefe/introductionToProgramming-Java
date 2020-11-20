public class ResizableCircle extends Circle implements Resizable {
	
	public ResizableCircle(double radius) {
		super (radius);
		resize (90);
	}

	@Override
	public void resize(int percent) {
		double newRadius = this.radius * (percent / 100.0);
		this.radius = newRadius;
	}	
}
