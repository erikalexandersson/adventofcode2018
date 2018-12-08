package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Node;

public class Day8Part1 {

	public Day8Part1() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day8Part1.getMetadataSum(
				Day8Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day8Input.txt").toURI()))));
	}

	public static int getMetadataSum(List<Node> nodes) {
		return nodes.stream().mapToInt(node -> node.getMetadata().stream().mapToInt(meta -> meta.intValue()).sum())
				.sum();
	}

	public static List<Node> parseFile(Path path) {
		List<Node> nodes = new ArrayList<>();
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			for (String line : lines) {
				int[] nrs = Arrays.asList(line.split(" ")).stream().mapToInt(str -> Integer.valueOf(str).intValue())
						.toArray();
				addNodes(nrs, null, 0, 0, 0, nodes);
			}

		} catch (IOException e) {
			return null;
		}
		return nodes;
	}

	private static int addNodes(int[] nrs, Node currentNode, int currentPosition, int children, int metadataEntries,
			List<Node> nodes) {
		if (currentNode == null) {
			Node newNode = new Node();
			nodes.add(newNode);
			addNodes(nrs, newNode, 2, nrs[0], nrs[1], nodes);
		} else if (children > 0) {
			while (children-- > 0) {
				Node newNode = new Node();
				nodes.add(newNode);
				currentNode.getChildren().add(newNode);
				currentPosition = addNodes(nrs, newNode, currentPosition + 2, nrs[currentPosition],
						nrs[currentPosition + 1], nodes);
			}
		}
		if (metadataEntries > 0) {
			currentNode.getMetadata().add(nrs[currentPosition]);
			return addNodes(nrs, currentNode, currentPosition + 1, children, metadataEntries - 1, nodes);
		}
		return currentPosition;
	}

}
