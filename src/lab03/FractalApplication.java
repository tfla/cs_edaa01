package fractal;

import koch.Koch;
import mountain.*;

public class FractalApplication {
	public static void main(String[] args) {
		Fractal[] fractals = new Fractal[2];
		fractals[0] = new Koch(300);
		fractals[1] = new Mountain(new Point(100,400), new Point(200,140), new Point(400,400), 30.0);
	    new FractalView(fractals, "Fraktaler");
	}
}
