package edu.iastate.cs228.hw2.grading;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw2.Point;

@Total(value=6)
public class PointTest {

	edu.iastate.cs228.hw2.Point basePoint;
	edu.iastate.cs228.hw2.Point testPoint;
	edu.iastate.cs228.hw2.solution.Point solutionPoint;

	@Before
	public void setup() {
		basePoint = new Point(0, 0);
	}

	@Test
	@Points(value=1)
	public void testCompareToEquals() {
		testPoint = new Point(0, 0);
		assertTrue("Expected compareTo to return 0 with equal points",
				basePoint.compareTo(testPoint) == 0);
	}

	@Test
	@Points(value=1)
	public void testCompareToGreater() {
		testPoint = new Point(-1, -1);
		assertTrue(
				"Expected compareTo to return > 0 when first point is greater than second point",
				basePoint.compareTo(testPoint) > 0);
	}

	@Test
	@Points(value=1)
	public void testCompareToLess() {
		testPoint = new Point(1, 1);
		assertTrue(
				"Expected compareTo to return < 0 when first point is greater than second point",
				basePoint.compareTo(testPoint) < 0);
	}

	@Test
	@Points(value=1)
	public void testCompareToXEquals() {
		testPoint = new Point(0, 1);
		assertTrue(
				"Expected compareTo to return < 0 when first point is greater than second point"
						+ " with the two x coordinates equal.",
				basePoint.compareTo(testPoint) < 0);
	}

	@Test
	@Points(value=2)
	public void testToString() {
		solutionPoint = new edu.iastate.cs228.hw2.solution.Point(0, 0);
		assertEquals("Expected toString of two equal points to be equal",
				solutionPoint.toString(), basePoint.toString());
	}

}
