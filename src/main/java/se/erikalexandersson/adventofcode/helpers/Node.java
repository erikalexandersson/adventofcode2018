package se.erikalexandersson.adventofcode.helpers;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private List<Node> children;
	private List<Integer> metadata;

	public Node() {
		this.children = new ArrayList<>();
		this.metadata = new ArrayList<>();
	}

	public List<Node> getChildren() {
		return children;
	}

	public List<Integer> getMetadata() {
		return metadata;
	}

	public int getValue() {
		int sum = 0;
		if (children.isEmpty()) {
			sum = metadata.stream().mapToInt(meta -> meta.intValue()).sum();
		} else {
			for (Integer meta : metadata) {
				try {
					sum += children.get(meta - 1).getValue();
				} catch (IndexOutOfBoundsException ex) {
					// This is ok.
				}
			}
		}
		return sum;
	}

}
