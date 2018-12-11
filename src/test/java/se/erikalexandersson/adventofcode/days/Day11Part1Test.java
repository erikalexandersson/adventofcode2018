package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day11Part1Test {

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
	public void testCalculatePower1() {
		Day11Part1 day11Part1 = new Day11Part1(8, 300);
		int expectedPower = 4;

		int actualPower = day11Part1.calculatePower(3, 5);

		assertEquals(expectedPower, actualPower);
	}

	@Test
	public void testCalculatePower2() {
		Day11Part1 day11Part1 = new Day11Part1(57, 300);
		int expectedPower = -5;

		int actualPower = day11Part1.calculatePower(122, 79);

		assertEquals(expectedPower, actualPower);
	}

	@Test
	public void testCalculatePower3() {
		Day11Part1 day11Part1 = new Day11Part1(39, 300);
		int expectedPower = 0;

		int actualPower = day11Part1.calculatePower(217, 196);

		assertEquals(expectedPower, actualPower);
	}

	@Test
	public void testCalculatePower4() {
		Day11Part1 day11Part1 = new Day11Part1(71, 300);
		int expectedPower = 4;

		int actualPower = day11Part1.calculatePower(101, 153);

		assertEquals(expectedPower, actualPower);
	}

	@Test
	public void testSquare1() {
		Day11Part1 day11Part1 = new Day11Part1(18, 300);
		String expectedCoordinates = "33,45";

		String actualCoordinates = day11Part1.findLargestPower();

		assertEquals(expectedCoordinates, actualCoordinates);
	}

	@Test
	public void testSquare2() {
		Day11Part1 day11Part1 = new Day11Part1(42, 300);
		String expectedCoordinates = "21,61";

		String actualCoordinates = day11Part1.findLargestPower();

		assertEquals(expectedCoordinates, actualCoordinates);
	}

}
