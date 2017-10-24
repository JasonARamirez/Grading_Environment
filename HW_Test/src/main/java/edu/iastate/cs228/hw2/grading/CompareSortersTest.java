package edu.iastate.cs228.hw2.grading;

import java.util.Random;

import org.junit.Test;

@Total(value = 5)
public class CompareSortersTest {

	edu.iastate.cs228.hw2.solution.Point[] solutionPoints;
	edu.iastate.cs228.hw2.Point[] studentPoints;

	@Test
	@Points(value = 5)
	public void testGenerateRandomPoints() {
		solutionPoints = TestUtils.createSolutionPoints(new Random(10));
		studentPoints = edu.iastate.cs228.hw2.CompareSorters
				.generateRandomPoints(TestUtils.SIZE, new Random(10));
		TestUtils.assertPointsEqual(solutionPoints, studentPoints);
	}

}
