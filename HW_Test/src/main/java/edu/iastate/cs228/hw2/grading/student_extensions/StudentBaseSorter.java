package edu.iastate.cs228.hw2.grading.student_extensions;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class StudentBaseSorter extends edu.iastate.cs228.hw2.AbstractSorter{

	public StudentBaseSorter(String fileName) throws InputMismatchException, FileNotFoundException {
		super(fileName);
	}
	
	public StudentBaseSorter(edu.iastate.cs228.hw2.Point[] points) {
		super(points);
	}
	
	public edu.iastate.cs228.hw2.Point[] getPoints() {
		return super.points;
	}
	
	@Override
	public void sort(int order) throws IllegalArgumentException {}

}
