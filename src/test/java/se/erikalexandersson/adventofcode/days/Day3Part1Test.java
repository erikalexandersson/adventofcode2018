package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day3Part1;
import se.erikalexandersson.adventofcode.helpers.Claim;

public class Day3Part1Test {

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
		int expectedOverlap = 4;
		Day3Part1 day3 = new Day3Part1(10, 10);

		// Act
		int actualOverlap = day3.getOverlap(Paths.get(ClassLoader.getSystemResource("Day3TestInput.txt").toURI()));

		// Assert
		assertEquals(expectedOverlap, actualOverlap);
	}

	@Test
	public void testParse() {
		Claim expectedClaim = new Claim("1", 1, 3, 4, 4);
		String line = "#1 @ 1,3: 4x4";

		Claim actualClaim = Claim.parseLine(line);

		assertEquals(expectedClaim, actualClaim);
	}
}
