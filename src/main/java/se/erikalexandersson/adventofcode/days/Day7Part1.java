package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7Part1 {

	public Day7Part1() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day7Part1.getInstructionOrder(
				Day7Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day7Input.txt").toURI()))));
	}

	public static Map<String, Set<String>> parseFile(Path path) {
		Map<String, Set<String>> instructions = new HashMap<>();
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			for (String line : lines) {
				String step = line.split(" ")[7];
				String prerequisite = line.split(" ")[1];
				if (!instructions.containsKey(step)) {
					instructions.put(step, new HashSet<>());
				}
				if (!instructions.containsKey(prerequisite)) {
					instructions.put(prerequisite, new HashSet<>());
				}
				instructions.get(step).add(prerequisite);
			}
		} catch (IOException e) {
			return null;
		}
		return instructions;
	}

	public static String getInstructionOrder(Map<String, Set<String>> instructions) {
		String order = "";
		while (!instructions.isEmpty()) {
			String step = instructions.entrySet().stream()
					.filter(entry -> entry.getValue().isEmpty()).sorted((Entry<String, Set<String>> e1,
							Entry<String, Set<String>> e2) -> e1.getKey().compareTo(e2.getKey()))
					.findFirst().get().getKey();
			order += step;
			instructions.values().forEach(list -> list.remove(step));
			instructions.remove(step);
		}
		return order;
	}

}
