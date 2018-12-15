package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day14Part2Test {

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
		int expectedNum = 9;
		Day14Part2 day14Part2 = new Day14Part2();

		int actualNum = day14Part2.getNumRecipes("51589");

		assertEquals(expectedNum, actualNum);
	}

	@Test
	public void testScore2() {
		int expectedNum = 5;
		Day14Part2 day14Part2 = new Day14Part2();

		int actualNum = day14Part2.getNumRecipes("01245");

		assertEquals(expectedNum, actualNum);
	}

	@Test
	public void testScore3() {
		int expectedNum = 18;
		Day14Part2 day14Part2 = new Day14Part2();

		int actualNum = day14Part2.getNumRecipes("92510");

		assertEquals(expectedNum, actualNum);
	}

	@Test
	public void testScore4() {
		int expectedNum = 2018;
		Day14Part2 day14Part2 = new Day14Part2();

		int actualNum = day14Part2.getNumRecipes("59414");

		assertEquals(expectedNum, actualNum);
	}
}
