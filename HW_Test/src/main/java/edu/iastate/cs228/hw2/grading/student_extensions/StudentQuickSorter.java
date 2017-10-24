package edu.iastate.cs228.hw2.grading.student_extensions;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import edu.iastate.cs228.hw2.Point;

public class StudentQuickSorter extends edu.iastate.cs228.hw2.QuickSorter{

	public StudentQuickSorter(Point[] pts) {
		super(pts);
	}

	public StudentQuickSorter(String fileName) throws InputMismatchException, FileNotFoundException {
		super(fileName);
	}
	
	public edu.iastate.cs228.hw2.Point[] getPoints() {
		return super.points;
	}
}
