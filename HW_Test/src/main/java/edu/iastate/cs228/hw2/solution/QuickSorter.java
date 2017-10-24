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
 * This class implements the version of the quicksort algorithm presented in the lecture.
 *
 */

public class QuickSorter extends AbstractSorter {
	{
		algorithm = "quicksort";
		outputFileName = "quick.txt";
	}

	/**
	 * The three constructors below invoke their corresponding superclass constructors. They also set the instance variable algorithm in the
	 * superclass.
	 */

	/**
	 * Constructor accepts an input array of points.
	 * 
	 * @param arr
	 *            input array of integers
	 * @param cv
	 *            set to cutOff
	 */
	public QuickSorter(Point[] pts) {
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
	public QuickSorter(String inputFileName) throws InputMismatchException, FileNotFoundException {
		super(inputFileName);
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last) {
		Point pivot = points[last];
		int i = first - 1;
		for (int j = first; j < last; j++) // [first, i] should always <= pivot
			if (pointComparator.compare(points[j], pivot) <= 0)
				swap(j, ++i);

		// place pivot at index (i + 1)
		swap(last, ++i);
		return i;
	}

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 *            starting index of the subarray
	 * @param last
	 *            ending index of the subarray
	 */
	private void quickSortRec(int first, int last) {
		if (first >= last)
			return;
		int p = partition(first, last);
		quickSortRec(first, p - 1);
		quickSortRec(p + 1, last);
	}

	/**
	 * Carry out quicksort on the array points[] of the AbstractSorter class.
	 * 
	 * @param order
	 *            0 by x-coordinate (using the compareTo() method of the Point class) 1 by polar angle w.r.t lowestPoint (using a PolarAngleComparator
	 *            object)
	 *
	 */
	public void sort(int order) {
		setComparator(order);

		long start = System.nanoTime();

		quickSortRec(0, points.length - 1);

		sortingTime = System.nanoTime() - start;
	}
}
