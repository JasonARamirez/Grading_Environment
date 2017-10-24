package edu.iastate.cs228.hw2.grading;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw2.grading.student_extensions.StudentMergeSorter;

@Total(value=20)
public class MergeSorterTest {
	edu.iastate.cs228.hw2.solution.AbstractSorter solutionSorter;
	StudentMergeSorter studentSorter;
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
	@Points(value=10)
	public void testSortXCoordinate() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.MergeSorter(solutionPoints);
		studentSorter = new StudentMergeSorter(studentPoints);
		solutionSorter.sort(1);
		studentSorter.sort(1);
		TestUtils.assertPointsEqual(solutionSorter.getPoints(), studentSorter.getPoints());
	}
	
	@Test
	@Points(value=10)
	public void testSortPolarCoordinate() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.MergeSorter(solutionPoints);
		studentSorter = new StudentMergeSorter(studentPoints);
		solutionSorter.sort(2);
		studentSorter.sort(2);
		TestUtils.assertPointsEqual(solutionSorter.getPoints(), studentSorter.getPoints());
	}
}
