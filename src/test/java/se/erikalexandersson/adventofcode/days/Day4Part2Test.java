package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day4Part2;

public class Day4Part2Test {

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
	public void testFindSleepy() throws URISyntaxException {
		// Arrange
		Day4Part2 day4 = new Day4Part2();
		int expected = 4455;

		// Act
		int actual = day4
				.findSleepyGuard(day4.parseFile(Paths.get(ClassLoader.getSystemResource("Day4TestInput.txt").toURI())));

		// Assert
		assertEquals(expected, actual);
	}
}
