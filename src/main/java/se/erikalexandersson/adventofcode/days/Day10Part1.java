package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Point;

public class Day10Part1 {

	public static void main(String args[]) throws URISyntaxException {
		printMessage(findMessage(parseFile(Paths.get(ClassLoader.getSystemResource("Day10Input.txt").toURI())), 10));
	}

	public static List<Point> parseFile(Path path) {
		List<Point> points = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			for (String line : lines) {
				Pattern p = Pattern
						.compile("position=<\\s*(\\-?\\d+),\\s*(\\-?\\d+)> velocity=<\\s*(\\-?\\d+),\\s*(\\-?\\d+)>");
				Matcher m = p.matcher(line);

				if (m.matches()) {
					points.add(new Point(Integer.valueOf(m.group(1)), Integer.valueOf(m.group(2)),
							Integer.valueOf(m.group(3)), Integer.valueOf(m.group(4))));
				}
			}

		} catch (IOException e) {
			return null;
		}
		return points;
	}

	public static void printMessage(List<String> lines) {
		lines.forEach(line -> System.out.println(line));
	}

	public static List<String> findMessage(List<Point> points, int lines) {
		List<String> message = new ArrayList<>();
		int linesWithStars = 0;
		int maxY;
		int minY;
		int maxX;
		int minX;

		do {
			points.stream().forEach(p -> p.step());
			maxY = points.stream().mapToInt(p -> p.y).max().orElse(0);
			minY = points.stream().mapToInt(p -> p.y).min().orElse(0);
			maxX = points.stream().mapToInt(p -> p.x).max().orElse(0);
			minX = points.stream().mapToInt(p -> p.x).min().orElse(0);
			linesWithStars = Math.abs(maxY - minY) + 1;
		} while (linesWithStars != lines);

		for (int y = minY; y <= maxY; y++) {
			StringBuilder stringBuilder = new StringBuilder();
			for (int x = minX; x <= maxX; x++) {
				boolean found = false;
				for (Point point : points) {
					if (point.x == x && point.y == y) {
						found = true;
						break;
					}
				}
				if (found) {
					stringBuilder.append("#");
				} else {
					stringBuilder.append(".");
				}
			}
			message.add(stringBuilder.toString());
		}
		return message;
	}
}
