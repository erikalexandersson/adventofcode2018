package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day15Part1Test {

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
	public void testOutcome1() throws URISyntaxException {
		Day15Part1 day15Part1 = new Day15Part1(Paths.get(ClassLoader.getSystemResource("Day15TestInput1.txt").toURI()));
		int expectedOutcome = 36334;

		day15Part1.fight();
		int actualOutcome = day15Part1.getOutcome();

		assertEquals(expectedOutcome, actualOutcome);
	}

	// @Test
	public void testOutcome2() throws URISyntaxException {
		Day15Part1 day15Part1 = new Day15Part1(Paths.get(ClassLoader.getSystemResource("Day15TestInput2.txt").toURI()));
		int expectedOutcome = 39514;

		day15Part1.fight();
		int actualOutcome = day15Part1.getOutcome();

		assertEquals(expectedOutcome, actualOutcome);
	}

	// @Test
	public void testOutcome3() throws URISyntaxException {
		Day15Part1 day15Part1 = new Day15Part1(Paths.get(ClassLoader.getSystemResource("Day15TestInput3.txt").toURI()));
		int expectedOutcome = 27755;

		day15Part1.fight();
		int actualOutcome = day15Part1.getOutcome();

		assertEquals(expectedOutcome, actualOutcome);
	}

	// @Test
	public void testOutcome4() throws URISyntaxException {
		Day15Part1 day15Part1 = new Day15Part1(Paths.get(ClassLoader.getSystemResource("Day15TestInput4.txt").toURI()));
		int expectedOutcome = 28944;

		day15Part1.fight();
		int actualOutcome = day15Part1.getOutcome();

		assertEquals(expectedOutcome, actualOutcome);
	}

	// @Test
	public void testOutcome5() throws URISyntaxException {
		Day15Part1 day15Part1 = new Day15Part1(Paths.get(ClassLoader.getSystemResource("Day15TestInput5.txt").toURI()));
		int expectedOutcome = 18740;

		day15Part1.fight();
		int actualOutcome = day15Part1.getOutcome();

		assertEquals(expectedOutcome, actualOutcome);
	}
}
