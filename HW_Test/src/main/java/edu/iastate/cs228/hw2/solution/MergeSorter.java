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
 * This class implements the mergesort algorithm.
 *
 */

public class MergeSorter extends AbstractSorter {
	{
		algorithm = "mergesort";
		outputFileName = "merge.txt";
	}

	/**
	 * The three constructors below invoke their corresponding superclass constructors. They also set the instance variable algorithm in the
	 * superclass.
	 */

	/**
	 * Constructor accepts an input array of points. in the array.
	 * 
	 * @param arr
	 *            input array of integers
	 * @param cv
	 *            set to cutOff
	 */
	public MergeSorter(Point[] pts) {
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
	public MergeSorter(String inputFileName) throws InputMismatchException, FileNotFoundException {
		super(inputFileName);
	}

	/**
	 * This is a recursive method that carries out mergesort on an array pts[] of points. One way is to make copies of the two halves of pts[],
	 * recursively call mergeSort on them, and merge the two sorted subarrays into pts[].
	 * 
	 * @param pts
	 *            point array
	 */
	private void mergeSortRec(Point[] pts) {
		if (pts.length <= 1)
			return;

		// split array into halves
		Point[] arrL = new Point[pts.length / 2];
		Point[] arrR = new Point[pts.length - arrL.length];
		for (int i = 0; i < arrL.length; i++)
			arrL[i] = pts[i];
		for (int j = 0; j < arrR.length; j++)
			arrR[j] = pts[j + arrL.length];

		// sort each half
		mergeSortRec(arrL);
		mergeSortRec(arrR);

		// merge
		int i = 0, j = 0, k = 0; // i:= index on arrL, j:= index on arrR, k:= index on merged array
		while (i < arrL.length && j < arrR.length)
			if (pointComparator.compare(arrL[i], arrR[j]) < 0)
				pts[k++] = arrL[i++];
			else
				pts[k++] = arrR[j++];
		while (i < arrL.length)
			pts[k++] = arrL[i++];
		while (j < arrR.length)
			pts[k++] = arrR[j++];
	}

	/**
	 * Perform mergesort on the array points[] of the parent class AbstractSorter.
	 * 
	 * @param order
	 *            0 by x-coordinate (using the compareTo() method of the Point class) 1 by polar angle w.r.t lowestPoint (using a PolarAngleComparator
	 *            object)
	 *
	 */
	public void sort(int order) {
		setComparator(order);

		long start = System.nanoTime();

		mergeSortRec(points);

		sortingTime = System.nanoTime() - start;
	}
}
