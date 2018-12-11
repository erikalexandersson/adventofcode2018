package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day11Part2Test {

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
	public void testSquare1() {
		Day11Part1 day11Part2 = new Day11Part2(18, 300);
		String expectedCoordinates = "90,269,16";

		String actualCoordinates = day11Part2.findLargestPower();

		assertEquals(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void testSquare2() {
		Day11Part1 day11Part2 = new Day11Part2(42, 300);
		String expectedCoordinates = "232,251,12";

		String actualCoordinates = day11Part2.findLargestPower();

		assertEquals(expectedCoordinates, actualCoordinates);
	}
}
