package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day6Part2Test {

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
	public void testFindTargetArea() throws URISyntaxException {
		int expectedSize = 16;

		int actualSize = Day6Part2.findTargetArea(
				Day6Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day6TestInput.txt").toURI())), 32);

		assertEquals(expectedSize, actualSize);
	}

}
