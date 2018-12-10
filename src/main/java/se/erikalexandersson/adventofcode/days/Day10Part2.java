package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import se.erikalexandersson.adventofcode.helpers.Point;

public class Day10Part2 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println((getTimeUntilMessage(
				Day10Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day10Input.txt").toURI())), 10)));
	}

	public static int getTimeUntilMessage(List<Point> points, int lines) {
		int seconds = 0;
		int linesWithStars = 0;
		int maxY;
		int minY;

		do {
			points.stream().forEach(p -> p.step());
			seconds++;
			maxY = points.stream().mapToInt(p -> p.y).max().orElse(0);
			minY = points.stream().mapToInt(p -> p.y).min().orElse(0);
			linesWithStars = Math.abs(maxY - minY) + 1;
		} while (linesWithStars != lines);

		return seconds;
	}
}
