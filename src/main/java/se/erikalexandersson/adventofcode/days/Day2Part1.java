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

public class Day2Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(checksum(Paths.get(ClassLoader.getSystemResource("Day2Input.txt").toURI())));
	}

	public static int checkTwos(String input) {
		return countChars(input).values().stream().filter(n -> n.intValue() == 2).count() > 0 ? 1 : 0;
	}

	public static int checkThrees(String input) {
		return countChars(input).values().stream().filter(n -> n.intValue() == 3).count() > 0 ? 1 : 0;
	}

	private static Map<Character, Integer> countChars(String input) {
		Map<Character, Integer> charCount = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			Character ch = input.charAt(i);
			if (charCount.containsKey(ch)) {
				charCount.put(ch, charCount.get(ch) + 1);
			} else {
				charCount.put(ch, 1);
			}
		}
		return charCount;
	}

	public static int checksum(Path path) {
		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			int numTwos = lines.stream().mapToInt(line -> checkTwos(line)).sum();
			int numThrees = lines.stream().mapToInt(line -> checkThrees(line)).sum();

			return numTwos * numThrees;
		} catch (IOException e) {
			return -1;
		}
	}

}
