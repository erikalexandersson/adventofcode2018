package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.helpers.Point;

public class Day10Part1Test {

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
	public void testParse() throws URISyntaxException {
		int expectedNumPoints = 31;

		List<Point> points = Day10Part1
				.parseFile(Paths.get(ClassLoader.getSystemResource("Day10TestInput.txt").toURI()));

		assertEquals(expectedNumPoints, points.size());
	}

	@Test
	public void testFindMessage() throws URISyntaxException {
		List<String> expectedMessage = new ArrayList<>();
		expectedMessage.add("#...#..###");
		expectedMessage.add("#...#...#.");
		expectedMessage.add("#...#...#.");
		expectedMessage.add("#####...#.");
		expectedMessage.add("#...#...#.");
		expectedMessage.add("#...#...#.");
		expectedMessage.add("#...#...#.");
		expectedMessage.add("#...#..###");

		List<String> actualMessage = Day10Part1.findMessage(
				Day10Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day10TestInput.txt").toURI())), 8);

		assertArrayEquals(expectedMessage.toArray(), actualMessage.toArray());
	}
}
