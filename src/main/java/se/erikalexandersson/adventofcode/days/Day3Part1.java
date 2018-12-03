package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Claim;

public class Day3Part1 {

	private List<String> sheet[][];
	private int width;
	private int height;

	@SuppressWarnings("unchecked")
	public Day3Part1(int width, int height) {
		this.width = width;
		this.height = height;
		this.sheet = new List[width][height];
	}

	public static void main(String args[]) throws URISyntaxException {
		Day3Part1 day3 = new Day3Part1(1000, 1000);
		System.out.println(day3.getOverlap(Paths.get(ClassLoader.getSystemResource("Day3Input.txt").toURI())));
	}

	public int getOverlap(Path path) {
		try (Stream<String> stream = Files.lines(path)) {

			List<String> lines = stream.collect(Collectors.toList());

			lines.stream().map(line -> Claim.parseLine(line)).forEach(claim -> {
				for (int x = claim.left; x < claim.left + claim.width; x++) {
					for (int y = claim.top; y < claim.top + claim.height; y++) {
						if (sheet[x][y] == null) {
							sheet[x][y] = new ArrayList<>();
						}
						sheet[x][y].add(claim.id);
					}
				}
			});

			int overlap = 0;
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					if (sheet[i][j] != null && sheet[i][j].size() > 1) {
						overlap++;
					}
				}
			}

			return overlap;
		} catch (IOException e) {
			return 0;
		}
	}

}
