package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;

import se.erikalexandersson.adventofcode.helpers.Cart;
import se.erikalexandersson.adventofcode.helpers.Point;

public class Day13Part2 extends Day13Part1 {

	public Day13Part2(Path path) {
		super(path);
	}

	public static void main(String args[]) throws URISyntaxException {
		Day13Part2 day13Part2 = new Day13Part2(Paths.get(ClassLoader.getSystemResource("Day13Input.txt").toURI()));
		System.out.println(day13Part2.getLastCart());
	}

	public Point getLastCart() {
		while (carts.size() > 1) {
			Collections.sort(carts, (c1, c2) -> c1.getPoint().compareTo(c2.getPoint()));
			Iterator<Cart> it = carts.iterator();
			boolean oneCartLeft = carts.stream().filter(cart -> !cart.isCrashed()).count() == 1;
			while (it.hasNext()) {
				Cart cart = it.next();
				if (cart.isCrashed()) {
					it.remove();
				} else {
					char ch = track[cart.getPoint().y][cart.getPoint().x];

					if (!oneCartLeft) {
						cart.tick(ch);
					}

					if (carts.stream().filter(c -> c.getPoint().equals(cart.getPoint())).count() > 1) {
						carts.stream().filter(c -> c.getPoint().equals(cart.getPoint()))
								.forEach(c -> c.setCrashed(true));
					}
				}
			}
		}

		return carts.stream().findAny().get().getPoint();
	}

}
