package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Coordinate;

public class Day6Part1 {

	public Day6Part1() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day6Part1.findLargestArea(
				Day6Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day6Input.txt").toURI()))));
	}

	public static List<Coordinate> parseFile(Path path) {
		List<Coordinate> coordinates = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			for (int i = 0; i < lines.size(); i++) {
				coordinates.add(new Coordinate(i, Integer.valueOf(lines.get(i).split(",")[0].trim()),
						Integer.valueOf(lines.get(i).split(",")[1].trim())));
			}
		} catch (IOException e) {
			return null;
		}
		return coordinates;
	}

	public static int findLargestArea(List<Coordinate> coordinates) {
		Map<Coordinate, Coordinate> grid = new HashMap<>();

		int maxX = coordinates.stream().mapToInt(c -> c.x).max().orElse(0);
		int maxY = coordinates.stream().mapToInt(c -> c.y).max().orElse(0);

		int id = 0;
		for (int x = 0; x <= maxX; x++) {
			for (int y = 0; y <= maxY; y++) {
				Coordinate c1 = new Coordinate(id++, x, y);
				Coordinate closestNode = null;

				int shortestDistance = Integer.MAX_VALUE;
				for (Coordinate c2 : coordinates) {
					if (c1.equals(c2)) {
						closestNode = c2;
						break;
					} else {
						int distance = Coordinate.manhattanDistance(c1, c2);
						if (distance < shortestDistance) {
							shortestDistance = distance;
							closestNode = c2;
						} else if (distance == shortestDistance) {
							closestNode = null;
						}
					}
				}
				grid.put(c1, closestNode);
			}
		}

		List<Coordinate> coordinatesToRemove = new ArrayList<>();
		for (Coordinate c : coordinates) {
			boolean foundOther = false;

			int x = c.x;
			while (--x >= 0) {
				Coordinate c1 = new Coordinate(c.id, x, c.y);
				Coordinate c2 = grid.get(c1);
				if (c2 == null || (c2.id != c.id)) {
					foundOther = true;
				}
			}
			if (!foundOther) {
				coordinatesToRemove.add(c);
				continue;
			}

			foundOther = false;
			x = c.x;
			while (++x <= maxX) {
				Coordinate dc = new Coordinate(c.id, x, c.y);
				if (grid.get(dc) == null || (grid.get(dc).id != c.id)) {
					foundOther = true;
				}
			}
			if (!foundOther) {
				coordinatesToRemove.add(c);
				continue;
			}

			foundOther = false;
			int y = c.y;
			while (--y >= 0) {
				Coordinate dc = new Coordinate(c.id, c.x, y);
				if (grid.get(dc) == null || (grid.get(dc).id != c.id)) {
					foundOther = true;
				}
			}
			if (!foundOther) {
				coordinatesToRemove.add(c);
				continue;
			}

			foundOther = false;
			y = c.y;
			while (++y <= maxY) {
				Coordinate dc = new Coordinate(c.id, c.x, y);
				if (grid.get(dc) == null || (grid.get(dc).id != c.id)) {
					foundOther = true;
				}
			}
			if (!foundOther) {
				coordinatesToRemove.add(c);
				continue;
			}
		}

		Iterator<Entry<Coordinate, Coordinate>> it = grid.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Coordinate, Coordinate> entry = it.next();
			if (coordinatesToRemove.contains(entry.getValue())) {
				grid.put(entry.getKey(), null);
			}
		}

		Map<Integer, Integer> idToArea = new HashMap<>();
		for (Entry<Coordinate, Coordinate> entry : grid.entrySet()) {
			if (entry.getValue() != null) {
				id = entry.getValue().id;
				if (!idToArea.containsKey(id)) {
					idToArea.put(id, 0);
				}
				idToArea.put(id, idToArea.get(id) + 1);
			}
		}

		return idToArea.values().stream().mapToInt(i -> i.intValue()).max().orElse(0);
	}

}
