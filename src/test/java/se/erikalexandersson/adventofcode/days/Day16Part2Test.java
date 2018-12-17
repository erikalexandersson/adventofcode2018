package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day16Part2Test {

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
	public void testParse() throws URISyntaxException {
		int expectedOpCode = 9;
		String expectedMethodName = "seti";

		Map<Integer, Method> programs = Day16Part2
				.parseFile(Paths.get(ClassLoader.getSystemResource("Day16TestInput.txt").toURI()));
		int actualOpCode = programs.keySet().stream().findAny().orElse(null).intValue();

		assertEquals(expectedOpCode, actualOpCode);
		assertEquals(expectedMethodName, programs.get(actualOpCode).getName());
	}
}
