package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day5Part1Test {

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
	public void testReact() {
		String expected = "";
		String line = "aA";

		String actual = String.valueOf(Day5Part1.react(line));

		assertEquals(expected, actual);
	}

	@Test
	public void testReact2() {
		String expected = "dabCBAcaDA";
		String line = "dabAcCaCBAcCcaDA";

		String actual = String.valueOf(Day5Part1.react(line));

		assertEquals(expected, actual);
	}
}
