package edu.iastate.cs228.hw2.grading;

import java.io.FileNotFoundException;

public class AutomatedJUnitRunner {
	public static void main(String[] args) throws FileNotFoundException {
		
		double topTotal = 113;
		
		new Grader(AbstractSorterTest.class, "Abstract Sorter Test Script").run();
		new Grader(InsertionSorterTest.class, "Insertion Sorter Test Script").run();
		new Grader(SelectionSorterTest.class, "Selection Sorter Test Script").run();
		new Grader(MergeSorterTest.class, "Merge Sorter Test Script").run();
		new Grader(QuickSorterTest.class, "Quick Sorter Test Script").run();
		new Grader(PointTest.class, "Point Test Script").run();
		new Grader(PolarAngleComparatorTest.class, "Polar Angle Comparator Test Script").run();
		new Grader(CompareSortersTest.class, "Compare Sorters Test Script").run();
		
        // Total print out
        double total = Grader.getTotal();
        double studentTotal = Grader.getStudentTotal();
        double normalized = (studentTotal / total) * topTotal;
        System.out.println();
        if (total != topTotal)
            System.out.println(String.format("Raw Total Normalized Scores: %.2f/%.2f",
                studentTotal, total));
        System.out.println(String.format("Normalized Total Score: %.2f/%.2f", normalized, topTotal));

        System.exit(0);
	}
}
