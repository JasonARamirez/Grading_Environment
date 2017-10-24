package edu.iastate.cs228.hw2.grading;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class HW2TestScript {

	edu.iastate.cs228.hw2.solution.AbstractSorter solutionSorter;
	edu.iastate.cs228.hw2.AbstractSorter studentSorter;
	edu.iastate.cs228.hw2.solution.Point[] solutionPoints;
	edu.iastate.cs228.hw2.Point[] studentPoints;
	Random rand;
	
	@Before
	public void setup() {
		rand = new Random(10);
		createDefaultPoints();
	}

	@Test
	public void testStats() {
		
	}
	
	private void createDefaultPoints() {
		solutionPoints = edu.iastate.cs228.hw2.solution.CompareSorters.generateRandomPoints(10, rand);
		int idx = 0;
		studentPoints = new edu.iastate.cs228.hw2.Point[solutionPoints.length];
		for (edu.iastate.cs228.hw2.solution.Point point : solutionPoints) {
			studentPoints[idx] = new edu.iastate.cs228.hw2.Point(point.getX(), point.getY());
			idx++;
		}
	}
	
}
