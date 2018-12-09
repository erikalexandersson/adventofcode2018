package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day9Part2Test {

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
	public void testPlay1() {
		Day9Part2 day9 = new Day9Part2(10, 1618);
		int expectedHighScore = 8317;

		day9.play();
		int actualHighScore = day9.getHighScore().intValue();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay2() {
		Day9Part2 day9 = new Day9Part2(13, 7999);
		int expectedHighScore = 146373;

		day9.play();
		int actualHighScore = day9.getHighScore().intValue();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay3() {
		Day9Part2 day9 = new Day9Part2(17, 1104);
		int expectedHighScore = 2764;

		day9.play();
		int actualHighScore = day9.getHighScore().intValue();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay4() {
		Day9Part2 day9 = new Day9Part2(21, 6111);
		int expectedHighScore = 54718;

		day9.play();
		int actualHighScore = day9.getHighScore().intValue();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay5() {
		Day9Part2 day9 = new Day9Part2(30, 5807);
		int expectedHighScore = 37305;

		day9.play();
		int actualHighScore = day9.getHighScore().intValue();

		assertEquals(expectedHighScore, actualHighScore);
	}
}
