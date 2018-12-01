package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.DuplicateFrequencyFoundException;

public class Day1Part2 {

	private int frequency;
	private Set<Integer> knownFrequencies;

	public Day1Part2(int frequency) {
		this.frequency = frequency;
		this.knownFrequencies = new HashSet<>();
		this.knownFrequencies.add(frequency);
	}

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(calibrate(Paths.get(ClassLoader.getSystemResource("Day1Input.txt").toURI())));
	}

	public static Integer calibrate(Path path) {
		Day1Part2 day1 = new Day1Part2(0);
		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			while (true) {
				for (int i = 0; i < lines.size(); i++) {
					day1.add(Integer.parseInt(lines.get(i)));
				}
			}
		} catch (IOException e) {
		} catch (DuplicateFrequencyFoundException e) {
			return (Integer) e.getFrequency();
		}
		return null;
	}

	public int getFrequency() {
		return frequency;
	}

	public void add(int frequency) throws DuplicateFrequencyFoundException {
		this.frequency += frequency;
		if (knownFrequencies.contains(this.frequency)) {
			throw new DuplicateFrequencyFoundException(this.frequency);
		} else {
			knownFrequencies.add(this.frequency);
		}
	}

}
