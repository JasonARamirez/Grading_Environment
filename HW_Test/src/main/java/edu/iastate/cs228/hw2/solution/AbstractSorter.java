package edu.iastate.cs228.hw2.solution;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  
 * @author Yuxiang Zhang
 *
 */

/**
 * 
 * This class tests all four sorting algorithms in the project. It stores the sorted sequence and records the time spent on sorting.
 *
 */
public abstract class AbstractSorter {
	// "selection sort", "insertion sort", "mergesort", or "quicksort".
	// Initialized by a subclass constructor.
	protected String algorithm = "";

	// lowest point in the array, or in case of a tie, the leftmost of the lowest points.
	// This point is used as the reference point for polar angle based comparison.
	private Point lowestPoint;

	protected String outputFileName;

	protected Comparator<Point> pointComparator;

	// Array of points operated on by a sorting algorithm.
	// The number of points is given by points.length.
	protected Point[] points;

	protected boolean sortByAngle; // last sort done by x-coordinate if true and by polar angle if false
	protected long sortingTime;

	/**
	 * This constructor accepts an array of points as input. Copy the points into the array points[].</br>
	 * Sets the instance variable lowestPoint.
	 *
	 * @param pts
	 *            input array of points
	 * @throws IllegalArgumentException
	 *             if pts == null or pts.length == 0.
	 */
	protected AbstractSorter(Point[] pts) throws IllegalArgumentException {
		if (pts == null)
			throw new IllegalArgumentException("pts == null");
		if (pts.length < 1)
			throw new IllegalArgumentException("pts.length < 1");

		// construct a new array from the input array, meanwhile find the lowest point
		points = new Point[pts.length];
		lowestPoint = new Point(0, Integer.MAX_VALUE);
		for (int i = 0; i < pts.length; i++) {
			points[i] = new Point(pts[i]);
			if (points[i].getY() < lowestPoint.getY() || (points[i].getY() == lowestPoint.getY() && points[i].getX() < lowestPoint.getX()))
				lowestPoint = points[i];
		}
	}

	/**
	 * This constructor reads points from a file. Sets the instance variable lowestPoint.
	 * 
	 * @param inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException
	 *             when the input file contains an odd number of integers
	 */
	protected AbstractSorter(String inputFileName) throws FileNotFoundException, InputMismatchException {
		Scanner scan = new Scanner(new File(inputFileName));
		ArrayList<Point> list = new ArrayList<Point>();

		// construct a new array from the input file, meanwhile find the lowest point
		lowestPoint = new Point(0, Integer.MAX_VALUE);
		while (scan.hasNextInt()) {
			int x = scan.nextInt();
			if (!scan.hasNextInt()) {
				scan.close();
				throw new InputMismatchException("odd number of integers");
			}
			int y = scan.nextInt();
			Point p = new Point(x, y);
			list.add(p);
			if (y < lowestPoint.getY() || (y == lowestPoint.getY() && x < lowestPoint.getX()))
				lowestPoint = p;
		}
		points = list.toArray(new Point[0]);
		scan.close();
	}

	/**
	 * Generates a comparator on the fly to compare by polar angles if sortByAngle == true and by x-coordinate if sortByAngle == false.</br>
	 * Need to call the compareTo() method in the Point class and create an object of the PolarAngleComparator class.
	 * 
	 * @param order
	 * @return
	 */
	protected void setComparator(int order) {
		sortByAngle = order == 2;
		pointComparator = order == 1 ? new Comparator<Point>() {
			@Override
			public int compare(Point p, Point other) {
				return p.compareTo(other);
			}
		} : new PolarAngleComparator(lowestPoint);
	}

	/**
	 * Sorts the points in points[].
	 * 
	 * a) in the non-decreasing order of x-coordinate if order == 0</br>
	 * b) in the non-decreasing order of polar angle w.r.t. lowestPoint if order == 1 (lowestPoint will at index 0 after sorting)
	 * 
	 * Records the sorting time (in nanoseconds) using the System.nanoTime() method. (Assign the time to the variable sortingTime.)</br>
	 * Sets the instance variable xOrAngle based on the value of order.
	 * 
	 * @param order
	 *            1 by x-coordinate (using the compareTo() method of the Point class)<br>
	 *            2 by polar angle w.r.t lowestPoint (using a PolarAngleComparator object)
	 *
	 * @throws IllegalArgumentException
	 *             if order is less than 1 or greater than 2
	 */
	public abstract void sort(int order) throws IllegalArgumentException;

	/**
	 * Outputs performance statistics in the format:
	 * 
	 * <sorting algorithm> <size> <time>
	 * 
	 * For instance,
	 * 
	 * insertion sort 100000 1623
	 */
	public String stats() {
		return algorithm + "\t" + points.length + "\t" + sortingTime;
	}

	/**
	 * Swap the two elements indexed i and j respectively in the array points[].
	 * 
	 * @param i
	 * @param j
	 */
	protected void swap(int i, int j) {
		Point tmp = points[i];
		points[i] = points[j];
		points[j] = tmp;
	}

	/**
	 * Write points[] to a string. When printed, the points will appear in order of increasing index with every point occupying a separate line.</br>
	 * The x and y coordinates of the point are displayed on the line with exactly one blank space in between.
	 */
	@Override
	public String toString() {
		String s = "";
		for (Point p : points)
			s += p.getX() + " " + p.getY() + "\n";
		return s;
	}

	/**
	 * This method, called after sorting, writes point data into a file by outputFileName.<br>
	 * The format of data in the file is the same as printed out from toString().<br>
	 * The file can help you verify the full correctness of a sorting result and debug the underlying algorithm.
	 * 
	 * @throws FileNotFoundException
	 */
	public void writePointsToFile() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(outputFileName);
		pw.write(toString());
		pw.close();
	}

	/**
	 * This method is called after sorting to check whether the result is correct.<br>
	 * You need to generate a list of points and a list of segments, depending on the value of sortByAngle as detailed in Section 4.1.<br>
	 * Then create a Plot object to call the method myFrame().
	 */
	public void draw() {
		Segment[] segments;
		// Based on Section 4.1, generate the line segments to draw to display the sorting result.
		// Assign their number to numSegs, and store them in segments[] in the order.
		if (sortByAngle) {
			segments = new Segment[points.length <= 1 ? 0 : points.length * 2 - 3];
			for (int i = 0; i < points.length - 1; i++)
				segments[i] = new Segment(points[0], points[i + 1]);
			for (int i = points.length - 1; i < segments.length; i++)
				segments[i] = new Segment(points[i - points.length + 2], points[i - points.length + 3]);
		} else {
			segments = new Segment[points.length - 1];
			for (int i = 0; i < points.length - 1; i++)
				segments[i] = new Segment(points[i], points[i + 1]);
		}
		// The following statement creates a window to display the sorting result.
		Plot.myFrame(points, segments, getClass().getName());
	}
	
	public Point[] getPoints() {
		return points;
	}
}
