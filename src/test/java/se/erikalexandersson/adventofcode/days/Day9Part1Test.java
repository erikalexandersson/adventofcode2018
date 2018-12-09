package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day9Part1Test {

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
	public void testTurns() {
		// Arrange
		Day9Part1 day9 = new Day9Part1(9, 25);
		int expectedPlayfieldAfter1Turn[] = { 1, 0 };
		int expectedPositionAfter1Turn = 0;
		int expectedPlayfieldAfter2Turn[] = { 2, 1, 0 };
		int expectedPositionAfter2Turn = 0;
		int expectedPlayfieldAfter3Turn[] = { 2, 1, 3, 0 };
		int expectedPositionAfter3Turn = 2;
		int expectedPlayfieldAfter4Turn[] = { 4, 2, 1, 3, 0 };
		int expectedPositionAfter4Turn = 0;
		int expectedPlayfieldAfter5Turn[] = { 4, 2, 5, 1, 3, 0 };
		int expectedPositionAfter5Turn = 2;

		int expectedHighScore = 32;

		// Act
		day9.takeTurn();
		// Assert
		assertArrayEquals(expectedPlayfieldAfter1Turn, day9.getPlayfield());
		assertEquals(expectedPositionAfter1Turn, day9.getCurrentPosition());

		// Act
		day9.takeTurn();
		// Assert
		assertArrayEquals(expectedPlayfieldAfter2Turn, day9.getPlayfield());
		assertEquals(expectedPositionAfter2Turn, day9.getCurrentPosition());

		// Act
		day9.takeTurn();
		// Assert
		assertArrayEquals(expectedPlayfieldAfter3Turn, day9.getPlayfield());
		assertEquals(expectedPositionAfter3Turn, day9.getCurrentPosition());

		// Act
		day9.takeTurn();
		// Assert
		assertArrayEquals(expectedPlayfieldAfter4Turn, day9.getPlayfield());
		assertEquals(expectedPositionAfter4Turn, day9.getCurrentPosition());

		// Act
		day9.takeTurn();
		// Assert
		assertArrayEquals(expectedPlayfieldAfter5Turn, day9.getPlayfield());
		assertEquals(expectedPositionAfter5Turn, day9.getCurrentPosition());

		day9.play();
		int actualHighScore = day9.getHighScore();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay1() {
		Day9Part1 day9 = new Day9Part1(10, 1618);
		int expectedHighScore = 8317;

		day9.play();
		int actualHighScore = day9.getHighScore();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay2() {
		Day9Part1 day9 = new Day9Part1(13, 7999);
		int expectedHighScore = 146373;

		day9.play();
		int actualHighScore = day9.getHighScore();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay3() {
		Day9Part1 day9 = new Day9Part1(17, 1104);
		int expectedHighScore = 2764;

		day9.play();
		int actualHighScore = day9.getHighScore();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay4() {
		Day9Part1 day9 = new Day9Part1(21, 6111);
		int expectedHighScore = 54718;

		day9.play();
		int actualHighScore = day9.getHighScore();

		assertEquals(expectedHighScore, actualHighScore);
	}

	@Test
	public void testPlay5() {
		Day9Part1 day9 = new Day9Part1(30, 5807);
		int expectedHighScore = 37305;

		day9.play();
		int actualHighScore = day9.getHighScore();

		assertEquals(expectedHighScore, actualHighScore);
	}
}
