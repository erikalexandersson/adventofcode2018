package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day1Part1Test {

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
		Day1Part1 day1 = new Day1Part1(0);

		// Act
		day1.add(1);
		day1.add(-2);
		day1.add(3);
		day1.add(1);

		// Assert
		assertEquals(3, day1.getFrequency());
	}

	@Test
	public void test2() {
		// Arrange
		Day1Part1 day1 = new Day1Part1(0);

		// Act
		day1.add(1);
		day1.add(1);
		day1.add(1);

		// Assert
		assertEquals(3, day1.getFrequency());
	}

	@Test
	public void test3() {
		// Arrange
		Day1Part1 day1 = new Day1Part1(0);

		// Act
		day1.add(1);
		day1.add(1);
		day1.add(-2);

		// Assert
		assertEquals(0, day1.getFrequency());
	}

	@Test
	public void test4() {
		// Arrange
		Day1Part1 day1 = new Day1Part1(0);

		// Act
		day1.add(-1);
		day1.add(-2);
		day1.add(-3);

		// Assert
		assertEquals(-6, day1.getFrequency());
	}
}
