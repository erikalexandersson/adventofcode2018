package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class Day5Part1 {

	public Day5Part1() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(
				Day5Part1.react(Day5Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day5Input.txt").toURI())))
						.length());
	}

	public static String parseFile(Path path) throws IOException {
		byte[] encoded = Files.readAllBytes(path);
		return new String(encoded);
	}

	public static String react(String str) {
		List<String> strs = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			strs.add(String.valueOf(str.charAt(i)));
		}
		return react(strs).stream().collect(Collectors.joining());
	}

	private static List<String> react(List<String> strs) {
		ListIterator<String> it = strs.listIterator();
		while (it.hasNext()) {
			String str1 = it.next();
			if (it.hasNext()) {
				String str2 = it.next();
				if (!str1.equals(str2) && str1.equalsIgnoreCase(str2)) {
					it.remove();
					it.previous();
					it.remove();
				}
				if (it.hasPrevious()) {
					it.previous();
				}
			}
		}
		return strs;
	}

}
