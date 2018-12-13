package se.erikalexandersson.adventofcode.days;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.erikalexandersson.adventofcode.helpers.Cart;
import se.erikalexandersson.adventofcode.helpers.Direction;
import se.erikalexandersson.adventofcode.helpers.Point;

public class Day13Part1Test {

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
	public void testCartTick1() {
		Cart cart = new Cart(new Point(3, 3), Direction.EAST);

		Direction expectedDirection = Direction.EAST;
		Point expectedPoint = new Point(4, 3);
		int expectedChoice = 1;

		cart.tick('-');

		assertEquals(expectedDirection, cart.getCurrentDirection());
		assertEquals(expectedPoint, cart.getPoint());
		assertEquals(expectedChoice, cart.getChoice());
	}

	@Test
	public void testCartTick2() {
		Cart cart = new Cart(new Point(3, 3), Direction.EAST);

		Direction expectedDirection = Direction.NORTH;
		Point expectedPoint = new Point(3, 2);
		int expectedChoice = 1;

		cart.tick('/');

		assertEquals(expectedDirection, cart.getCurrentDirection());
		assertEquals(expectedPoint, cart.getPoint());
		assertEquals(expectedChoice, cart.getChoice());
	}

	@Test
	public void testCartTick3() {
		Cart cart = new Cart(new Point(3, 3), Direction.EAST);

		Direction expectedDirection = Direction.SOUTH;
		Point expectedPoint = new Point(3, 4);
		int expectedChoice = 1;

		cart.tick('\\');

		assertEquals(expectedDirection, cart.getCurrentDirection());
		assertEquals(expectedPoint, cart.getPoint());
		assertEquals(expectedChoice, cart.getChoice());
	}

	@Test
	public void testCartTick4() {
		Cart cart = new Cart(new Point(3, 3), Direction.WEST);

		Direction expectedDirection = Direction.SOUTH;
		Point expectedPoint = new Point(3, 4);
		int expectedChoice = 4;

		cart.tick('+');

		assertEquals(expectedDirection, cart.getCurrentDirection());
		assertEquals(expectedPoint, cart.getPoint());
		assertEquals(expectedChoice, cart.getChoice());

		expectedDirection = Direction.SOUTH;
		expectedPoint = new Point(3, 5);
		expectedChoice = 7;

		cart.tick('+');

		assertEquals(expectedDirection, cart.getCurrentDirection());
		assertEquals(expectedPoint, cart.getPoint());
		assertEquals(expectedChoice, cart.getChoice());

		expectedDirection = Direction.WEST;
		expectedPoint = new Point(2, 5);
		expectedChoice = 1;

		cart.tick('+');

		assertEquals(expectedDirection, cart.getCurrentDirection());
		assertEquals(expectedPoint, cart.getPoint());
		assertEquals(expectedChoice, cart.getChoice());
	}

	@Test
	public void testTrack() throws URISyntaxException {
		Day13Part1 day13Part1 = new Day13Part1(Paths.get(ClassLoader.getSystemResource("Day13Part1TestInput.txt").toURI()));
		Point expectedPoint = new Point(7, 3);

		Point actualPoint = day13Part1.getFirstCrash();

		assertEquals(expectedPoint, actualPoint);
	}

}
