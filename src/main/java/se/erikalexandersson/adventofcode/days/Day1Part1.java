package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1Part1 {

	private int frequency;

	public Day1Part1(int frequency) {
		this.frequency = frequency;
	}

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(calibrate(Paths.get(ClassLoader.getSystemResource("Day1Input.txt").toURI())));
	}

	public static int calibrate(Path path) {
		Day1Part1 day1 = new Day1Part1(0);
		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			lines.stream().forEach(line -> {
				day1.add(Integer.parseInt(line));
			});

		} catch (IOException e) {
		}
		return day1.getFrequency();
	}

	public int getFrequency() {
		return frequency;
	}

	public void add(int frequency) {
		this.frequency += frequency;
	}

}
