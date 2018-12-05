package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.*;

import java.net.URISyntaxException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day5Part1;

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
	public void testReact() throws URISyntaxException {
		String expected = "";
		String line = "aA";

		String actual = String.valueOf(Day5Part1.react(line));

		assertEquals(expected, actual);
	}

	@Test
	public void testReact2() throws URISyntaxException {
		String expected = "dabCBAcaDA";
		String line = "dabAcCaCBAcCcaDA";

		String actual = String.valueOf(Day5Part1.react(line));

		assertEquals(expected, actual);
	}
}
