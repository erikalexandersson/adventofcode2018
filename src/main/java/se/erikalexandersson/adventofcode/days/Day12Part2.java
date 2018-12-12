package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Day12Part2 extends Day12Part1 {

	public Day12Part2(Path path) {
		super(path);
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		Day12Part2 day12Part2 = new Day12Part2(Paths.get(ClassLoader.getSystemResource("Day12Input.txt").toURI()));
		System.out.println(day12Part2.countPotsAfterGenerations(50000000000l));
	}

	public long countPotsAfterGenerations(long generations) {
		Map<Integer, Boolean> oldGeneration = plants;

		int generation = 0;
		int shift = 0;
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

			String patternIn = getPattern(oldGeneration);
			String patternOut = getPattern(newGeneration);

			oldGeneration = newGeneration;

			if (patternIn.equals(patternOut)) {
				int outMax = newGeneration.entrySet().stream().filter(e -> e.getValue()).mapToInt(e -> e.getKey()).max()
						.orElse(0);
				shift = outMax - max;
				break;
			}
		}

		if (shift != 0) {
			int nPlants = (int) oldGeneration.values().stream().filter(v -> v.booleanValue()).count();
			long currentSum = oldGeneration.entrySet().stream().filter(e -> e.getValue()).mapToLong(e -> e.getKey())
					.sum();
			return currentSum + (shift * nPlants * (generations - generation));
		} else {
			return oldGeneration.entrySet().stream().filter(e -> e.getValue()).mapToInt(e -> e.getKey()).sum();
		}
	}
}
