package se.erikalexandersson.adventofcode.days;

public class Day11Part1 {

	protected int serialNumber;
	protected int grid[][];
	protected int size;

	public Day11Part1(int serialNumber, int size) {
		this.serialNumber = serialNumber;
		this.size = size;
		this.grid = createGrid();
	}

	public static void main(String args[]) {
		Day11Part1 day11Part1 = new Day11Part1(2866, 300);
		System.out.println(day11Part1.findLargestPower());
	}

	public String findLargestPower() {
		int highX = 0;
		int highY = 0;
		int max = 0;
		int power;

		for (int y = 1; y <= size - 2; y++) {
			for (int x = 1; x <= size - 2; x++) {
				power = calculateSquarePower(x, y);
				if (power > max) {
					max = power;
					highX = x;
					highY = y;
				}
			}
		}

		return String.format("%d,%d", highX, highY);
	}

	public int[][] createGrid() {
		int grid[][] = new int[size][size];

		for (int y = 1; y <= size; y++) {
			for (int x = 1; x <= size; x++) {
				grid[y - 1][x - 1] = calculatePower(x, y);
			}
		}
		return grid;
	}

	public int calculatePower(int x, int y) {
		int rackID = x + 10;
		int powerLevel = ((rackID * y) + serialNumber) * rackID;
		String powerLevelStr = String.valueOf(powerLevel);
		return Integer.parseInt(powerLevelStr.substring(powerLevelStr.length() - 3, powerLevelStr.length() - 2)) - 5;
	}

	public int calculateSquarePower(int x, int y) {
		int a = grid[y - 1][x - 1];
		int b = grid[y - 1][x];
		int c = grid[y - 1][x + 1];
		int d = grid[y][x - 1];
		int e = grid[y][x];
		int f = grid[y][x + 1];
		int g = grid[y + 1][x - 1];
		int h = grid[y + 1][x];
		int i = grid[y + 1][x + 1];
		return a + b + c + d + e + f + g + h + i;
	}

}
