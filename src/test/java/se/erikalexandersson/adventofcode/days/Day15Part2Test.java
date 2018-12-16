package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day15Part2Test {

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
	public void testOutcome2() throws URISyntaxException {
		int expectedOutcome = 31284;

		int actualOutcome = Day15Part2.findOutcomeWithLowestAPWithoutElfDeaths(
				Paths.get(ClassLoader.getSystemResource("Day15TestInput2.txt").toURI()));

		assertEquals(expectedOutcome, actualOutcome);
	}

	@Test
	public void testOutcome3() throws URISyntaxException {
		int expectedOutcome = 3478;

		int actualOutcome = Day15Part2.findOutcomeWithLowestAPWithoutElfDeaths(
				Paths.get(ClassLoader.getSystemResource("Day15TestInput3.txt").toURI()));

		assertEquals(expectedOutcome, actualOutcome);
	}

	@Test
	public void testOutcome4() throws URISyntaxException {
		int expectedOutcome = 6474;

		int actualOutcome = Day15Part2.findOutcomeWithLowestAPWithoutElfDeaths(
				Paths.get(ClassLoader.getSystemResource("Day15TestInput4.txt").toURI()));

		assertEquals(expectedOutcome, actualOutcome);
	}

	@Test
	public void testOutcome5() throws URISyntaxException {
		int expectedOutcome = 1140;

		int actualOutcome = Day15Part2.findOutcomeWithLowestAPWithoutElfDeaths(
				Paths.get(ClassLoader.getSystemResource("Day15TestInput5.txt").toURI()));

		assertEquals(expectedOutcome, actualOutcome);
	}
}
