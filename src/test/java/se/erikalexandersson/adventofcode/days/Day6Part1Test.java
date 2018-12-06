package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.helpers.Coordinate;

public class Day6Part1Test {

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
	public void testDistance() {
		Coordinate c1 = new Coordinate(1, 1, 6);
		Coordinate c2 = new Coordinate(2, 8, 3);
		int expectedManhattanDistance = 10;

		int actualManhattanDistance = Coordinate.manhattanDistance(c1, c2);

		assertEquals(expectedManhattanDistance, actualManhattanDistance);
	}

	@Test
	public void testFindLargestArea() throws URISyntaxException {
		int expectedSize = 17;

		int actualSize = Day6Part1.findLargestArea(
				Day6Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day6TestInput.txt").toURI())));

		assertEquals(expectedSize, actualSize);
	}

}
