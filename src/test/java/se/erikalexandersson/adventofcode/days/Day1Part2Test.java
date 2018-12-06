package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.helpers.DuplicateFrequencyFoundException;

public class Day1Part2Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		// Arrange
		Day1Part2 day1 = new Day1Part2(0);

		// Act
		try {
			while (true) {
				day1.add(1);
				day1.add(-1);
			}
		} catch (DuplicateFrequencyFoundException ex) {
			// Assert
			assertEquals(0, ex.getFrequency());
		}
	}

	@Test
	public void test2() {
		// Arrange
		Day1Part2 day1 = new Day1Part2(0);

		// Act
		try {
			while (true) {
				day1.add(3);
				day1.add(3);
				day1.add(4);
				day1.add(-2);
				day1.add(-4);
			}
		} catch (DuplicateFrequencyFoundException ex) {
			// Assert
			assertEquals(10, ex.getFrequency());
		}
	}

	@Test
	public void test3() {
		// Arrange
		Day1Part2 day1 = new Day1Part2(0);

		// Act
		try {
			while (true) {
				day1.add(-6);
				day1.add(3);
				day1.add(8);
				day1.add(5);
				day1.add(-6);
			}
		} catch (DuplicateFrequencyFoundException ex) {
			// Assert
			assertEquals(5, ex.getFrequency());
		}
	}

	@Test
	public void test4() {
		// Arrange
		Day1Part2 day1 = new Day1Part2(0);

		// Act
		try {
			while (true) {
				day1.add(7);
				day1.add(7);
				day1.add(-2);
				day1.add(-7);
				day1.add(-4);
			}
		} catch (DuplicateFrequencyFoundException ex) {
			// Assert
			assertEquals(14, ex.getFrequency());
		}
	}

}
