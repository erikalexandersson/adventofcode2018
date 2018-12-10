package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day10Part2Test {

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
	public void testTimeUntilMessageAppears() throws URISyntaxException {
		int expectedTime = 3;

		int actualTime = Day10Part2.getTimeUntilMessage(
				Day10Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day10TestInput.txt").toURI())), 8);

		assertEquals(expectedTime, actualTime);
	}
}
