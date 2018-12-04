package se.erikalexandersson.adventofcode.days;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Map.Entry;

public class Day4Part2 extends Day4Part1 {

	public Day4Part2() {
	}

	public static void main(String args[]) throws URISyntaxException {
		Day4Part2 day4 = new Day4Part2();
		System.out.println(day4
				.findSleepyGuard(day4.parseFile(Paths.get(ClassLoader.getSystemResource("Day4Input.txt").toURI()))));
	}

	public int findSleepyGuard(Map<Integer, Map<Integer, Integer>> guardSleeping) {
		Integer sleepiestGuard = null;
		Integer worstMinute = null;
		int mostFrequentDay = 0;
		for (Entry<Integer, Map<Integer, Integer>> entry : guardSleeping.entrySet()) {
			int guard = entry.getKey();
			for (Entry<Integer, Integer> entry2 : guardSleeping.get(guard).entrySet()) {
				int minute = entry2.getKey();
				int days = entry2.getValue();

				if (days > mostFrequentDay) {
					mostFrequentDay = days;
					worstMinute = minute;
					sleepiestGuard = guard;
				}
			}
		}

		return sleepiestGuard * worstMinute;
	}

}
