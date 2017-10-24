package edu.iastate.cs228.hw2.solution;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

/**
 *  
 * @author Yuxiang Zhang
 *
 */

/**
 * 
 * This class implements selection sort.
 *
 */

public class SelectionSorter extends AbstractSorter {
	// Other private instance variables if you need ...
	{
		algorithm = "selection sort";
		outputFileName = "select.txt";
	}

	/**
	 * The three constructors below invoke their corresponding superclass constructors. They also set the instance variable algorithm in the
	 * superclass.
	 */

	/**
	 * Constructor takes an array of points.
	 * 
	 * @param pts
	 */
	public SelectionSorter(Point[] pts) {
		super(pts);
	}

	/**
	 * Constructor reads points from a file.
	 * 
	 * @param inputFileName
	 *            the name of the input file
	 * @param cv
	 *            set to cutOff
	 * @throws FileNotFoundException
	 * @throws InputMismatchException
	 */
	public SelectionSorter(String inputFileName) throws InputMismatchException, FileNotFoundException {
		super(inputFileName);
	}

	/**
	 * Apply insertion sort on the array points[] of the parent class AbstractSorter.
	 *
	 * @param order
	 *            0 by x-coordinate (using the compareTo() method of the Point class) 1 by polar angle w.r.t lowestPoint (using a PolarAngleComparator
	 *            object)
	 *
	 */
	public void sort(int order) {
		setComparator(order);

		long start = System.nanoTime();

		for (int i = 0; i < points.length; i++) {
			int min = i;
			for (int j = i + 1; j < points.length; j++)
				if (pointComparator.compare(points[j], points[min]) < 0)
					min = j;
			swap(i, min);
		}

		sortingTime = System.nanoTime() - start;
	}
}
