package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day2Part2 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(getID(Paths.get(ClassLoader.getSystemResource("Day2Input.txt").toURI())));
	}

	public static int compareIDs(String str1, String str2) {
		int diff = 0;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				diff++;
			}
		}
		return diff;
	}

	public static String getCommonLetters(String str1, String str2) {
		String common = "";
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) == str2.charAt(i)) {
				common += str1.charAt(i);
			}
		}
		return common;
	}

	public static String getID(Path path) {
		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			int currentLow = Integer.MAX_VALUE;
			int lowI = 0;
			int lowJ = 1;

			for (int i = 0; i < lines.size(); i++) {
				for (int j = i + 1; j < lines.size(); j++) {
					int diff = compareIDs(lines.get(i), lines.get(j));
					if (diff < currentLow) {
						currentLow = diff;
						lowI = i;
						lowJ = j;
					}
				}
			}

			return getCommonLetters(lines.get(lowI), lines.get(lowJ));
		} catch (IOException e) {
			return null;
		}
	}

}
