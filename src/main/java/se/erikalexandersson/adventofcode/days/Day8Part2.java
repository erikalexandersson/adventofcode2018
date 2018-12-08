package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;

import se.erikalexandersson.adventofcode.helpers.Node;

public class Day8Part2 {

	public Day8Part2() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day8Part2
				.getValue(Day8Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day8Input.txt").toURI()))));
	}

	public static int getValue(List<Node> nodes) {
		return nodes.get(0).getValue();
	}

}
