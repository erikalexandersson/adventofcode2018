package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.helpers.Point;

public class Day13Part2Test {

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
	public void testTrack() throws URISyntaxException {
		Day13Part2 day13Part2 = new Day13Part2(
				Paths.get(ClassLoader.getSystemResource("Day13Part2TestInput.txt").toURI()));
		Point expectedPoint = new Point(6, 4);

		Point actualPoint = day13Part2.getLastCart();

		assertEquals(expectedPoint, actualPoint);
	}

}
