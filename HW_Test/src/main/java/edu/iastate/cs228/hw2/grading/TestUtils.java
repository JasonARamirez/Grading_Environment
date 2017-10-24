package edu.iastate.cs228.hw2.grading;

import static org.junit.Assert.assertEquals;

import java.util.Random;

public class TestUtils {
	
	public static int SIZE = 20;
	

	public static edu.iastate.cs228.hw2.solution.Point[] createSolutionPoints(Random rand) {
		return edu.iastate.cs228.hw2.solution.CompareSorters.generateRandomPoints(SIZE, rand);
	}
	
	public static edu.iastate.cs228.hw2.Point[] copySolitionPointsToStudent(edu.iastate.cs228.hw2.solution.Point[] solutionPoints) {
		edu.iastate.cs228.hw2.Point[] studentPoints = new edu.iastate.cs228.hw2.Point[solutionPoints.length];
		int idx = 0;
		for (edu.iastate.cs228.hw2.solution.Point point : solutionPoints) {
			studentPoints[idx] = new edu.iastate.cs228.hw2.Point(point.getX(), point.getY());
			idx++;
		}
		return studentPoints;
	}
	
	public static void assertPointsEqual(edu.iastate.cs228.hw2.solution.Point[] solPoints,
			edu.iastate.cs228.hw2.Point[] points) {
		int idx = 0;
		assertEquals("Point array sizes different.", solPoints.length, points.length);
		for (edu.iastate.cs228.hw2.solution.Point point : solPoints) {
			assertEquals("X coordinate at position: " + idx + " not equal.", point.getX(), points[idx].getX());
			assertEquals("Y coordinate at position: " + idx + " not equal.",point.getY(), points[idx].getY());
			idx++;
		}
		
	}
	
}
