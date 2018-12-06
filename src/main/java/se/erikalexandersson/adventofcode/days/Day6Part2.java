package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import se.erikalexandersson.adventofcode.helpers.Coordinate;

public class Day6Part2 {

	public Day6Part2() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day6Part2.findTargetArea(
				Day6Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day6Input.txt").toURI())), 10000));
	}

	public static int findTargetArea(List<Coordinate> coordinates, int limit) {
		int maxX = coordinates.stream().mapToInt(c -> c.x).max().orElse(0);
		int maxY = coordinates.stream().mapToInt(c -> c.y).max().orElse(0);

		int area = 0;

		int id = 0;
		for (int x = 0; x <= maxX; x++) {
			for (int y = 0; y <= maxY; y++) {
				Coordinate c1 = new Coordinate(id++, x, y);

				int distanceSum = 0;
				for (Coordinate c2 : coordinates) {
					distanceSum += Coordinate.manhattanDistance(c1, c2);
				}
				if (distanceSum < limit) {
					area++;
				}
			}
		}

		return area;
	}

}
