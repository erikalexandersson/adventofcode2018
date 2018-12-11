package se.erikalexandersson.adventofcode.days;

public class Day11Part2 extends Day11Part1 {

	public Day11Part2(int serialNumber, int size) {
		super(serialNumber, size);
	}

	public static void main(String args[]) {
		Day11Part2 day11Part2 = new Day11Part2(2866, 300);
		System.out.println(day11Part2.findLargestPower());
	}

	public String findLargestPower() {
		int highX = 0;
		int highY = 0;
		int highSize = 0;
		int max = 0;
		int power;

		for (int y = 1; y <= size; y++) {
			for (int x = 1; x <= size; x++) {
				int sizeLimit = size - Math.max(x, y) + 1;
				for (int i = 1; i <= sizeLimit; i++) {
					power = calculateSquarePower(x, y, i);
					if (power > max) {
						max = power;
						highX = x;
						highY = y;
						highSize = i;
					}
				}
			}
		}

		return String.format("%d,%d,%d", highX, highY, highSize);
	}

	public int calculateSquarePower(int x, int y, int size) {
		int sum = 0;
		for (int i = y - 1; i < y - 1 + size; i++) {
			for (int j = x - 1; j < x - 1 + size; j++) {
				sum += grid[i][j];
			}
		}
		return sum;
	}

}
