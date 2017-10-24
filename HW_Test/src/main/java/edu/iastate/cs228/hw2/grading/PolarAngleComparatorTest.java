package edu.iastate.cs228.hw2.grading;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.iastate.cs228.hw2.PolarAngleComparator;

@Total(value=15)
public class PolarAngleComparatorTest {

	edu.iastate.cs228.hw2.PolarAngleComparator studentComparator;
	edu.iastate.cs228.hw2.Point referencePoint;
	
	@Before
	public void setup() {
		referencePoint = new edu.iastate.cs228.hw2.Point(2, 2);
		studentComparator = new PolarAngleComparator(referencePoint);
	}
	
	@Test
	@Points(value=1)
	public void testCompareEqual() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(5, 5);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(5, 5);
		assertTrue("Expected compare to equal 0 with two equal points", 
				studentComparator.compare(point1, point2) == 0);
		
	}
	
	@Test
	@Points(value=1)
	public void testCompareLessThanPolar() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(5, 4);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(5, 5);
		assertTrue("Expected compare to equal -1 with point1 lesser polar angle than point 2", 
				studentComparator.compare(point1, point2) == -1);
	}
	
	@Test
	@Points(value=1)
	public void testCompareGreaterThanPolar() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(1, 3);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(4, 3);
		assertTrue("Expected compare to equal 1 with point1 greater polar angle than point 2", 
				studentComparator.compare(point1, point2) == 1);	
	}
	
	@Test
	@Points(value=1)
	public void testCompareLessThanEqualPolar() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(4, 4);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(5, 5);
		assertTrue("Expected compare to equal -1 with point1 lesser distance than point 2 when polar angles equal", 
				studentComparator.compare(point1, point2) == -1);
	}
	
	@Test
	@Points(value=1)
	public void testCompareGreaterThanEqualPolar() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(5, 5);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(4, 4);
		assertTrue("Expected compare to equal 1 with point1 greater distance than point 2 when polar angles equal", 
				studentComparator.compare(point1, point2) == 1);	
	}
	
	@Test
	@Points(value=1)
	public void testComparePolarAngleEqual() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(5, 5);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(7, 7);
		assertTrue("Expected comparePolarAngle to equal 0 with two equal points", 
				studentComparator.comparePolarAngle(point1, point2) == 0);
	}
	
	@Test
	@Points(value=2)
	public void testComparePolarAngleLessThan() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(10, 1);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(10, 10);
		assertTrue("Expected comparePolarAngle to equal -1 with point1 less than point2", 
				studentComparator.comparePolarAngle(point1, point2) == -1);
	}
	
	@Test
	@Points(value=2)
	public void testComparePolarAngleGreaterThan() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(10, 10);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(10, 1);
		assertTrue("Expected comparePolarAngle to equal 1 with point1 greater than point2", 
				studentComparator.comparePolarAngle(point1, point2) == 1);
	}
	
	@Test
	@Points(value=1)
	public void testCompareDistanceEqual() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(1, 1);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(3, 3);
		assertTrue("Expected compareDistance to equal 0 with two equal points", 
				studentComparator.compareDistance(point1, point2) == 0);
	}
	
	@Test
	@Points(value=2)
	public void testCompareDistanceLessThan() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(1, 1);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(5, 5);
		assertTrue("Expected compareDistance to equal -1 with point1 less than point2", 
				studentComparator.compareDistance(point1, point2) == -1);
	}
	
	@Test
	@Points(value=2)
	public void testCompareDistanceGreaterThan() {
		edu.iastate.cs228.hw2.Point point1 = new edu.iastate.cs228.hw2.Point(5, 5);
		edu.iastate.cs228.hw2.Point point2 = new edu.iastate.cs228.hw2.Point(0, 0);
		assertTrue("Expected compareDistance to equal 1 with point1 less than point2", 
				studentComparator.compareDistance(point1, point2) == 1);
	}
}
