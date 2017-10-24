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
 * This class implements insertion sort.
 *
 */

public class InsertionSorter extends AbstractSorter {
	{
		algorithm = "insertion sort";
		outputFileName = "insert.txt";
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
	public InsertionSorter(Point[] pts) {
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
	public InsertionSorter(String inputFileName) throws InputMismatchException, FileNotFoundException {
		super(inputFileName);
	}

	/**
	 * Perform insertion sort on the array points[] of the parent class AbstractSorter.
	 * 
	 * @param order
	 *            0 by x-coordinate (using the compareTo() method of the Point class)</br>
	 *            1 by polar angle w.r.t lowestPoint (using a PolarAngleComparator object)
	 */
	@Override
	public void sort(int order) {
		setComparator(order);

		long start = System.nanoTime();

		for (int i = 1; i < points.length; i++) // [0, i) will be always sorted as the loop goes
			for (int j = i; j > 0; j--)
				if (pointComparator.compare(points[j], points[j - 1]) < 0)
					swap(j, j - 1);

		sortingTime = System.nanoTime() - start;
	}
}
