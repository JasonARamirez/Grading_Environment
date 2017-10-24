package edu.iastate.cs228.hw2.grading;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw2.grading.student_extensions.StudentInsertionSorter;

@Total(value=12)
public class InsertionSorterTest {

	edu.iastate.cs228.hw2.solution.AbstractSorter solutionSorter;
	StudentInsertionSorter studentSorter;
	edu.iastate.cs228.hw2.solution.Point[] solutionPoints;
	edu.iastate.cs228.hw2.Point[] studentPoints;
	Random rand;
	
	@Before
	public void setup() {
		rand = new Random(10);
		solutionPoints = TestUtils.createSolutionPoints(rand);
		studentPoints = TestUtils.copySolitionPointsToStudent(solutionPoints);
	}
	
	@Test
	@Points(value=6)
	public void testSortXCoordinate() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.InsertionSorter(solutionPoints);
		studentSorter = new StudentInsertionSorter(studentPoints);
		solutionSorter.sort(1);
		studentSorter.sort(1);
		TestUtils.assertPointsEqual(solutionSorter.getPoints(), studentSorter.getPoints());
	}
	
	@Test
	@Points(value=6)
	public void testSortPolarCoordinate() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.InsertionSorter(solutionPoints);
		studentSorter = new StudentInsertionSorter(studentPoints);
		solutionSorter.sort(2);
		studentSorter.sort(2);
		TestUtils.assertPointsEqual(solutionSorter.getPoints(), studentSorter.getPoints());
	}
	
}
