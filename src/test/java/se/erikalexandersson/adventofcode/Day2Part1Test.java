package se.erikalexandersson.adventofcode;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day2Part1;

public class Day2Part1Test {

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
		int expectedChecksum = 12;

		// Act
		int actualChecksum = Day2Part1.checksum(Paths.get(ClassLoader.getSystemResource("Day2Part1TestInput.txt").toURI()));

		// Assert
		assertEquals(expectedChecksum, actualChecksum);
	}

	@Test
	public void test1() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 0;
		int expectedNumThrees = 0;
		String input = "abcdef";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

	@Test
	public void test2() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 1;
		int expectedNumThrees = 1;
		String input = "bababc";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

	@Test
	public void test3() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 1;
		int expectedNumThrees = 0;
		String input = "abbcde";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

	@Test
	public void test4() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 0;
		int expectedNumThrees = 1;
		String input = "abcccd";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

	@Test
	public void test5() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 1;
		int expectedNumThrees = 0;
		String input = "aabcdd";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

	@Test
	public void test6() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 1;
		int expectedNumThrees = 0;
		String input = "abcdee";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

	@Test
	public void test7() throws URISyntaxException {
		// Arrange
		int expectedNumTwos = 0;
		int expectedNumThrees = 1;
		String input = "ababab";

		// Act
		int actualNumTwos = Day2Part1.checkTwos(input);
		int actualNumThrees = Day2Part1.checkThrees(input);

		// Assert
		assertEquals(expectedNumTwos, actualNumTwos);
		assertEquals(expectedNumThrees, actualNumThrees);
	}

}
