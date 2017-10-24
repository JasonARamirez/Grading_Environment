package edu.iastate.cs228.hw2.grading;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw2.grading.student_extensions.StudentBaseSorter;

@Total(value=23)
public class AbstractSorterTest {

	edu.iastate.cs228.hw2.solution.AbstractSorter solutionSorter;
	edu.iastate.cs228.hw2.AbstractSorter studentSorter;
	StudentBaseSorter studentBaseSorter; // Used to test protected constructors
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
	@Points(value=3)
	public void testPointsConstructor() {
		studentBaseSorter = new StudentBaseSorter(studentPoints);
		edu.iastate.cs228.hw2.Point[] answerPoints = studentBaseSorter.getPoints();
		assertFalse("Array was only shallow copied.", studentPoints == answerPoints);
		int idx = 0;
		TestUtils.assertPointsEqual(solutionPoints, studentBaseSorter.getPoints());
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Points(value=1)
	public void testPointsConstructorNullArray() {
		edu.iastate.cs228.hw2.Point[] points = null;
		studentBaseSorter = new StudentBaseSorter(points);
	}
	
	@Test(expected=IllegalArgumentException.class)
	@Points(value=1)
	public void testPointsConstructorZeroSizeArray() {
		edu.iastate.cs228.hw2.Point[] points = new edu.iastate.cs228.hw2.Point[0];
		studentBaseSorter = new StudentBaseSorter(points);
	}
	
	@Test 
	@Points(value=7)
	public void testFileConstructor() throws InputMismatchException, FileNotFoundException {
		solutionSorter = new edu.iastate.cs228.hw2.solution.SelectionSorter("src/files/points.txt");
		studentBaseSorter = new StudentBaseSorter("src/files/points.txt");
		TestUtils.assertPointsEqual(solutionSorter.getPoints(), studentBaseSorter.getPoints());
	}
	
	@Test(expected = InputMismatchException.class)
	@Points(value=1)
	public void testIncorrectFileConstructor() throws InputMismatchException, FileNotFoundException {
		studentBaseSorter = new StudentBaseSorter("src/files/bad_points.txt");
	}

	@Test
	@Points(value=2)
	public void testSelectionStats() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.SelectionSorter(solutionPoints);
		studentSorter = new edu.iastate.cs228.hw2.SelectionSorter(studentPoints);
		assertEquals("Stats strings unequal", stripWhiteSpace(solutionSorter.stats().toLowerCase()), stripWhiteSpace(studentSorter.stats().toLowerCase()));
	}
	
	@Test
	@Points(value=1)
	public void testInsertionStats() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.InsertionSorter(solutionPoints);
		studentSorter = new edu.iastate.cs228.hw2.InsertionSorter(studentPoints);
		assertEquals("Stats strings unequal", stripWhiteSpace(solutionSorter.stats().toLowerCase()), stripWhiteSpace(studentSorter.stats().toLowerCase()));
	}
	@Test
	@Points(value=1)
	public void testMergeStats() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.MergeSorter(solutionPoints);
		studentSorter = new edu.iastate.cs228.hw2.MergeSorter(studentPoints);
		assertEquals("Stats strings unequal", stripWhiteSpace(solutionSorter.stats().toLowerCase()), stripWhiteSpace(studentSorter.stats().toLowerCase()));
	}
	@Test
	@Points(value=1)
	public void testQuickStats() {
		solutionSorter = new edu.iastate.cs228.hw2.solution.QuickSorter(solutionPoints);
		studentSorter = new edu.iastate.cs228.hw2.QuickSorter(studentPoints);
		assertEquals("Stats strings unequal", stripWhiteSpace(solutionSorter.stats().toLowerCase()), stripWhiteSpace(studentSorter.stats().toLowerCase()));
	}
	
	@Test
	@Points(value=5)
	public void testToString() {
		studentBaseSorter = new StudentBaseSorter(studentPoints);
		solutionSorter = new edu.iastate.cs228.hw2.solution.SelectionSorter(solutionPoints);
		assertEquals("toString results were unequal", solutionSorter.toString().trim().replaceAll("\\s+", " "), studentBaseSorter.toString().trim().replaceAll("\\(|,|\\)", "").replaceAll("\\s+", " "));
	}
	
	private String stripWhiteSpace(String str) {
		str = str.replace(" ", "");
		str = str.replace("\n", "");
		str = str.replace("\t", "");
		return str;
	}

}
