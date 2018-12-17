package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.*;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Day16Part1Test {

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
	public void testAddr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 7, 2, 3, 4 };

		int[] actual = Day16Part1.addr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testAddi() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 6, 2, 3, 4 };

		int[] actual = Day16Part1.addi(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testMulr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 12, 2, 3, 4 };

		int[] actual = Day16Part1.mulr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testMuli() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 9, 2, 3, 4 };

		int[] actual = Day16Part1.muli(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBanr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 0, 2, 3, 4 };

		int[] actual = Day16Part1.banr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBani() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 3, 2, 3, 4 };

		int[] actual = Day16Part1.bani(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBorr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 7, 2, 3, 4 };

		int[] actual = Day16Part1.borr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testBori() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 3, 2, 3, 4 };

		int[] actual = Day16Part1.bori(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testSetr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 3, 2, 3, 4 };

		int[] actual = Day16Part1.setr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testSeti() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 2, 2, 3, 4 };

		int[] actual = Day16Part1.seti(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGtir() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 0, 2, 3, 4 };

		int[] actual = Day16Part1.gtir(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGtri() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 0, 2, 3, 4 };

		int[] actual = Day16Part1.gtri(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGtrr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 0, 2, 3, 4 };

		int[] actual = Day16Part1.gtrr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testEqir() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 0, 2, 3, 4 };

		int[] actual = Day16Part1.eqir(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testEqri() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 1, 2, 3, 4 };

		int[] actual = Day16Part1.eqri(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testEqrr() {
		int[] in = { 1, 2, 3, 4 };
		int[] expected = { 0, 2, 3, 4 };

		int[] actual = Day16Part1.eqrr(in, 2, 3, 0);

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testGetMatchingOpCodes() {
		int[] in = { 3, 2, 1, 1 };
		int[] out = { 3, 2, 2, 1 };
		int expected = 3;
		int opcode = 9;
		int a = 2;
		int b = 1;
		int c = 2;

		int actual = Day16Part1.getMatchingOpCodes(in, out, opcode, a, b, c).size();

		assertEquals(expected, actual);
	}

	@Test
	public void testParse() throws URISyntaxException {
		int expected = 1;

		int actual = Day16Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day16TestInput.txt").toURI()));

		assertEquals(expected, actual);
	}
}
