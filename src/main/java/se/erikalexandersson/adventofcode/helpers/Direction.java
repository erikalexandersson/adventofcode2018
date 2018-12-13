package se.erikalexandersson.adventofcode.helpers;

import java.util.Arrays;

public enum Direction {
	EAST(0), NORTH(1), WEST(2), SOUTH(3);

	int value;

	private Direction(int value) {
		this.value = value;
	}

	public static Direction valueOf(int value) {
		return Arrays.stream(values()).filter(dir -> dir.value == value).findFirst().orElse(null);
	}
}
