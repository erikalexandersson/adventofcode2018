package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day7Part1Test {

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
	public void testGetInstructionOrder() throws URISyntaxException {
		String expectedOrder = "CABDFE";

		String actualOrder = Day7Part1.getInstructionOrder(
				Day7Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day7TestInput.txt").toURI())));

		assertEquals(expectedOrder, actualOrder);
	}

}
