package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Day5Part2 extends Day5Part1 {

	public Day5Part2() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day5Part2
				.improve(Day5Part2.parseFile(Paths.get(ClassLoader.getSystemResource("Day5Input.txt").toURI()))));
	}

	public static int improve(String input) {
		Set<String> letters = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			letters.add(String.valueOf(input.toLowerCase().charAt(i)));
		}

		int shortest = Integer.MAX_VALUE;
		for (String letter : letters) {
			String str = new String(input);
			int length = react(str.replaceAll(letter, "").replaceAll(letter.toUpperCase(), "")).length();
			if (length < shortest) {
				shortest = length;
			}
		}

		return shortest;
	}

}
