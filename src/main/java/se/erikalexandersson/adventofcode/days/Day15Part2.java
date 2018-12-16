package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Day15Part2 extends Day15Part1 {

	public Day15Part2(Path path, int elfAttackPower) {
		super(path, elfAttackPower);
	}

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(findOutcomeWithLowestAPWithoutElfDeaths(
				Paths.get(ClassLoader.getSystemResource("Day15Input.txt").toURI())));
	}

	public static int findOutcomeWithLowestAPWithoutElfDeaths(Path path) {
		int currentAp = 3;

		Day15Part2 day15Part2;
		while (true) {
			currentAp++;

			day15Part2 = new Day15Part2(path, currentAp);
			int numElves = day15Part2.elfs.size();

			day15Part2.fight();

			int numElvesAlive = (int) day15Part2.elfs.stream().filter(elf -> elf.getHitPoints() > 0).count();
			if (numElves == numElvesAlive) {
				break;
			}
		}

		return day15Part2.getOutcome();
	}

}
