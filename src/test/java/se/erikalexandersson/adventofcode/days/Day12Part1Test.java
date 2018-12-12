package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day12Part1Test {

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
	public void testCountPlants() throws URISyntaxException {
		Day12Part1 day12Part1 = new Day12Part1(
				Paths.get(ClassLoader.getSystemResource("Day12Part1TestInput.txt").toURI()));
		int expectedNumPlants = 325;

		int actualNumPlants = (int) day12Part1.countPotsAfterGenerations(20);

		assertEquals(expectedNumPlants, actualNumPlants);
	}

}
