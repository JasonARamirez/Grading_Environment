package edu.iastate.cs228.hw2.solution;

/**
 * 
 * @author Yuxiang Zhang
 *
 */
public class Point implements Comparable<Point> {
	private int x;
	private int y;

	public Point() // default constructor
	{
		// x and y get default value 0
		x = 0;
		y = 0;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) { // copy constructor
		x = p.getX();
		y = p.getY();
	}

	/**
	 * Compare this point with a second point q in the left-to-right order.
	 * 
	 * @param q
	 * @return -1 if this.x < q.x || (this.x == q.x && this.y < q.y) 0 if this.x == q.x && this.y < q.y 1 otherwise
	 */
	public int compareTo(Point q) {
		return x == q.x ? Integer.compare(y, q.y) : Integer.compare(x, q.x);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Point other = (Point) obj;
		return x == other.x && y == other.y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	/**
	 * Output a point in the standard form (x, y).
	 */
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}