package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day3Part2;

public class Day3Part2Test {

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
	public void testOverlap() throws URISyntaxException {
		// Arrange
		String expectedClaim = "3";
		Day3Part2 day3 = new Day3Part2(10, 10);

		// Act
		String actualClaim = day3.findClaim(Paths.get(ClassLoader.getSystemResource("Day3TestInput.txt").toURI()));

		// Assert
		assertEquals(expectedClaim, actualClaim);
	}
}
