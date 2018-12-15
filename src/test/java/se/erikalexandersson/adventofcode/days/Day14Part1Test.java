package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day14Part1Test {

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
	public void testScore1() {
		String expectedScore = "5158916779";
		Day14Part1 day14Part1 = new Day14Part1();

		String actualScore = day14Part1.getScore(9);

		assertEquals(expectedScore, actualScore);
	}

	@Test
	public void testScore2() {
		String expectedScore = "0124515891";
		Day14Part1 day14Part1 = new Day14Part1();

		String actualScore = day14Part1.getScore(5);

		assertEquals(expectedScore, actualScore);
	}

	@Test
	public void testScore3() {
		String expectedScore = "9251071085";
		Day14Part1 day14Part1 = new Day14Part1();

		String actualScore = day14Part1.getScore(18);

		assertEquals(expectedScore, actualScore);
	}

	@Test
	public void testScore4() {
		String expectedScore = "5941429882";
		Day14Part1 day14Part1 = new Day14Part1();

		String actualScore = day14Part1.getScore(2018);

		assertEquals(expectedScore, actualScore);
	}
}
