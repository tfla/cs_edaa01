package mountain;

import fractal.*;
import java.util.LinkedList;

public class Mountain extends Fractal {
	private Point a;
	private Point b;
	private Point c;
	private double dev;
	private LinkedList<Side> list;

	/** Creates an object that handles a Mountain fractal. 
	 * @param a bottom left point of the triangle
	 * @param b top point of the triangle
	 * @param c bottom right point of the triangle
	 * @param dev deviation for randFunc()
	 */
	public Mountain(Point a, Point b, Point c, double dev) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.dev = dev;
		list = new LinkedList<Side>();
	}

	/**
	 * Returns the title.
	 * @return the title
	 */
	public String getTitle() {
		return "Mountain fractal";
	}

	/** Draws the fractal.  
	 * @param turtle the turtle graphic object
	 */
	public void draw(TurtleGraphics turtle) {
		turtle.moveTo(a.getX(), a.getY());
		fractalLine(turtle, order, a, b, c, dev);
	}

	/** 
	 * Reursive method: Draws a recursive line of the triangle. 
	 */
	private void fractalLine(TurtleGraphics turtle, int order, Point a, Point b, Point c, double dev) {
		if (order == 0) {
			turtle.moveTo(c.getX(), c.getY());
			turtle.forwardTo(a.getX(), a.getY());
			turtle.forwardTo(b.getX(), b.getY());
			turtle.forwardTo(c.getX(), c.getY());
		}
		else {
			Point d = newPoint(a, b, dev);
			Point e = newPoint(b, c, dev);
			Point f = newPoint(c, a, dev);

			d = ifExists(new Side(a, b, d), d);
			e = ifExists(new Side(b, c, e), e);
			f = ifExists(new Side(c, a, f), f);
			
			fractalLine(turtle, order-1, a, d, f, dev/2);
			fractalLine(turtle, order-1, b, d, e, dev/2);
			fractalLine(turtle, order-1, c, e, f, dev/2);
			fractalLine(turtle, order-1, d, e, f, dev/2);
			
		}
	}

	/**
	 * Returns the middle Point of two specified Points.
	 * @param a One of the Points
	 * @param b The other Point
	 * @param dev The deviation for randFunc()
	 * @return the new Point
	 */
	private Point newPoint(Point a, Point b, double dev) {
		return new Point((a.getX()+b.getX())/2, ((a.getY()+b.getY())/2)+RandomUtilities.randFunc(dev));
	}

	/**
	 * Checks the list to see if it contains the specified midpoint.
	 * @param s the Side on which to search for a point
	 * @param p the Point to search for
	 * @return the Point in the middle of the line, if it exists
	 */
	private Point ifExists(Side s, Point p) {
		if (list.contains(s)) {
			return list.remove(list.indexOf(s)).getM();
		}
		else {
			list.add(s);
			return p;
		}
	}

}
