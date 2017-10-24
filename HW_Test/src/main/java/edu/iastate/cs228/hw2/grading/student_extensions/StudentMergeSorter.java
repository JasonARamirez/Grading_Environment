package edu.iastate.cs228.hw2.grading.student_extensions;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import edu.iastate.cs228.hw2.Point;

public class StudentMergeSorter extends edu.iastate.cs228.hw2.MergeSorter {

	public StudentMergeSorter(Point[] pts) {
		super(pts);
	}

	public StudentMergeSorter(String fileName) throws InputMismatchException, FileNotFoundException {
		super(fileName);
	}
	
	public edu.iastate.cs228.hw2.Point[] getPoints() {
		return super.points;
	}
	
}
