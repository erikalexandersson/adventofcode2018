package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.days.Day4Part1;
import se.erikalexandersson.adventofcode.helpers.Log;

public class Day4Part1Test {

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
	public void testParseLine() {
		// Arrange
		String line = "[1518-11-01 00:05] falls asleep";
		Log expectedLog = new Log(1518, 11, 1, 0, 5, "falls asleep");

		// Act
		Log actualLog = Log.parseLine(line);

		// Assert
		assertEquals(actualLog, expectedLog);
	}

	@Test
	public void testSort() {
		// Arrange
		List<String> lines = new ArrayList<>();
		String line1 = "[1518-11-02 00:50] wakes up";
		lines.add(line1);
		String line2 = "[1518-11-01 23:58] Guard #99 begins shift";
		lines.add(line2);
		String line3 = "[1518-11-01 00:05] falls asleep";
		lines.add(line3);
		String line4 = "[1518-11-03 00:05] Guard #10 begins shift";
		lines.add(line4);

		// Act
		List<Log> sortedLogs = Log.parseLines(lines);

		// Assert
		assertEquals(sortedLogs.get(0), Log.parseLine(line3));
		assertEquals(sortedLogs.get(1), Log.parseLine(line2));
		assertEquals(sortedLogs.get(2), Log.parseLine(line1));
		assertEquals(sortedLogs.get(3), Log.parseLine(line4));
	}

	@Test
	public void testParseFile() throws URISyntaxException {
		// Arrange
		Day4Part1 day4 = new Day4Part1();

		// Act
		Map<Integer, Map<Integer, Integer>> guards = day4
				.parseFile(Paths.get(ClassLoader.getSystemResource("Day4TestInput.txt").toURI()));

		// Assert
		assertEquals(50, guards.get(10).values().stream().mapToInt(min -> min.intValue()).sum());
		assertEquals(30, guards.get(99).values().stream().mapToInt(min -> min.intValue()).sum());
	}

	@Test
	public void testFindSleepy() throws URISyntaxException {
		// Arrange
		Day4Part1 day4 = new Day4Part1();
		int expected = 240;

		// Act
		int actual = day4
				.findSleepyGuard(day4.parseFile(Paths.get(ClassLoader.getSystemResource("Day4TestInput.txt").toURI())));

		// Assert
		assertEquals(expected, actual);
	}
}
