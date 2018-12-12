package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day12Part1 {

	protected Map<Integer, Boolean> plants;
	protected Map<String, Boolean> notes;

	public Day12Part1(Path path) {
		this.parseFile(path);
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		Day12Part1 day12Part1 = new Day12Part1(Paths.get(ClassLoader.getSystemResource("Day12Input.txt").toURI()));
		System.out.println(day12Part1.countPotsAfterGenerations(20));
	}

	public long countPotsAfterGenerations(long generations) {
		Map<Integer, Boolean> oldGeneration = plants;

		int generation = 0;
		while (generation++ < generations) {
			Map<Integer, Boolean> newGeneration = new HashMap<>();
			int min = oldGeneration.entrySet().stream().filter(e -> e.getValue()).mapToInt(e -> e.getKey()).min()
					.orElse(0);
			int max = oldGeneration.entrySet().stream().filter(e -> e.getValue()).mapToInt(e -> e.getKey()).max()
					.orElse(0);
			for (int i = min - 3; i < max + 3; i++) {
				String pattern = "";
				for (int j = 0; j < 5; j++) {
					if (oldGeneration.containsKey(i + j)) {
						if (oldGeneration.get(i + j).booleanValue()) {
							pattern += "#";
						} else {
							pattern += ".";
						}
					} else {
						pattern += ".";
					}
				}
				boolean hasPlant = notes.containsKey(pattern) && notes.get(pattern).booleanValue();
				newGeneration.put(i + 2, hasPlant);
			}
			oldGeneration = newGeneration;
		}

		return oldGeneration.entrySet().stream().filter(e -> e.getValue()).mapToInt(e -> e.getKey()).sum();
	}

	protected String getPattern(Map<Integer, Boolean> plants) {
		return plants.entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.map(e -> e.getValue() ? "#" : ".").collect(Collectors.joining());
	}

	private void parseFile(Path path) {
		this.notes = new HashMap<>();
		this.plants = new HashMap<>();
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			for (String line : lines) {
				if (line.isEmpty()) {
					continue;
				}
				if (line.contains("initial state")) {
					String start = line.split(" ")[2];
					for (int i = 0; i < start.length(); i++) {
						if (start.charAt(i) == '#') {
							plants.put(i, true);
						} else {
							plants.put(i, false);
						}
					}
				} else {
					String in = line.split(" ")[0];
					String out = line.split(" ")[2];
					if (out.equals("#")) {
						notes.put(in, true);
					} else {
						notes.put(in, false);
					}
				}
			}

		} catch (IOException e) {
		}
	}

}
