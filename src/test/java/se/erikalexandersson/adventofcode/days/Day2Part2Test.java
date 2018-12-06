package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day2Part2;

public class Day2Part2Test {

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
	public void testList() throws URISyntaxException {
		// Arrange
		String expectedID = "fgij";

		// Act
		String actualID = Day2Part2.getID(Paths.get(ClassLoader.getSystemResource("Day2Part2TestInput.txt").toURI()));

		// Assert
		assertEquals(expectedID, actualID);
	}

	@Test
	public void test1() {
		// Arrange
		int expectedDiff = 2;

		// Act
		int actualDiff = Day2Part2.compareIDs("abcde", "axcye");

		// Assert
		assertEquals(expectedDiff, actualDiff);
	}

	@Test
	public void test2() {
		// Arrange
		int expectedDiff = 1;

		// Act
		int actualDiff = Day2Part2.compareIDs("fghij", "fguij");

		// Assert
		assertEquals(expectedDiff, actualDiff);
	}

	@Test
	public void test3() {
		// Arrange
		String expected = "fgij";

		// Act
		String actual = Day2Part2.getCommonLetters("fghij", "fguij");

		// Assert
		assertEquals(expected, actual);
	}

}
