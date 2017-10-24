package edu.iastate.cs228.hw2.solution;

/**
 * 
 * Simple class representing a line segment for drawing only.
 *
 */
public class Segment {
	private Point p;
	private Point q;

	public Segment(Point p0, Point q0) {
		p = new Point(p0);
		q = new Point(q0);
	}

	public Point getP() {
		return p;
	}

	public Point getQ() {
		return q;
	}

}
