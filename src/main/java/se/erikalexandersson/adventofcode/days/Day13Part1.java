package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Cart;
import se.erikalexandersson.adventofcode.helpers.Direction;
import se.erikalexandersson.adventofcode.helpers.Point;

public class Day13Part1 {

	protected char track[][];
	protected List<Cart> carts;

	public Day13Part1(Path path) {
		this.carts = new ArrayList<>();
		this.parseFile(path);
	}

	public static void main(String args[]) throws URISyntaxException {
		Day13Part1 day13Part1 = new Day13Part1(Paths.get(ClassLoader.getSystemResource("Day13Input.txt").toURI()));
		System.out.println(day13Part1.getFirstCrash());
	}

	public Point getFirstCrash() {
		boolean crashed = false;
		Point crashPoint = null;

		while (!crashed) {
			Collections.sort(carts, (c1, c2) -> c1.getPoint().compareTo(c2.getPoint()));
			Iterator<Cart> it = carts.iterator();
			while (it.hasNext() && !crashed) {
				Cart cart = it.next();
				char ch = track[cart.getPoint().y][cart.getPoint().x];
				cart.tick(ch);

				if (carts.stream().filter(c -> c.getPoint().equals(cart.getPoint())).count() > 1) {
					crashed = true;
					crashPoint = cart.getPoint();
				}
			}
		}

		return crashPoint;
	}

	public void parseFile(Path path) {
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			int maxLine = lines.stream().mapToInt(line -> line.length()).max().orElse(0);
			track = new char[lines.size()][maxLine];

			for (int y = 0; y < lines.size(); y++) {
				String line = lines.get(y);
				for (int x = 0; x < line.length(); x++) {
					char ch = line.charAt(x);
					if (ch == '<') {
						Cart cart = new Cart(new Point(x, y), Direction.WEST);
						carts.add(cart);
						ch = '-';
					} else if (ch == '>') {
						Cart cart = new Cart(new Point(x, y), Direction.EAST);
						carts.add(cart);
						ch = '-';
					} else if (ch == '^') {
						Cart cart = new Cart(new Point(x, y), Direction.NORTH);
						carts.add(cart);
						ch = '|';
					} else if (ch == 'v') {
						Cart cart = new Cart(new Point(x, y), Direction.SOUTH);
						carts.add(cart);
						ch = '|';
					}
					track[y][x] = ch;
				}
			}
		} catch (IOException e) {
		}
	}

}
