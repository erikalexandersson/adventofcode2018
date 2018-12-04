package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Log;

public class Day4Part1 {

	public Day4Part1() {
	}

	public static void main(String args[]) throws URISyntaxException {
		Day4Part1 day4 = new Day4Part1();
		System.out.println(day4
				.findSleepyGuard(day4.parseFile(Paths.get(ClassLoader.getSystemResource("Day4Input.txt").toURI()))));
	}

	public int findSleepyGuard(Map<Integer, Map<Integer, Integer>> guardSleeping) {
		Integer sleepiestGuard = null;
		int maxSleep = 0;
		for (Entry<Integer, Map<Integer, Integer>> entry : guardSleeping.entrySet()) {
			int sleep = entry.getValue().values().stream().mapToInt(min -> min.intValue()).sum();
			if (sleep > maxSleep) {
				maxSleep = sleep;
				sleepiestGuard = entry.getKey();
			}
		}

		if (sleepiestGuard != null) {
			Integer worstMinute = null;
			int maxDays = 0;

			for (Entry<Integer, Integer> entry : guardSleeping.get(sleepiestGuard).entrySet()) {
				int minute = entry.getKey();
				int days = entry.getValue();

				if (days > maxDays) {
					maxDays = days;
					worstMinute = minute;
				}
			}

			if (worstMinute != null) {
				return sleepiestGuard * worstMinute;
			} else {
				return 0;
			}
		}

		return 0;
	}

	public Map<Integer, Map<Integer, Integer>> parseFile(Path path) {
		try (Stream<String> stream = Files.lines(path)) {

			Map<Integer, Map<Integer, Integer>> guards = new HashMap<>();
			Integer currentGuard = null;
			int asleepAt = 0;

			List<String> lines = stream.collect(Collectors.toList());
			List<Log> logs = Log.parseLines(lines);

			Iterator<Log> it = logs.iterator();
			while (it.hasNext()) {
				Log log = it.next();

				if (log.event.contains("begins shift")) {
					currentGuard = Integer.valueOf(log.event.split("#")[1].split(" ")[0]);
				} else if (log.event.contains("falls asleep")) {
					asleepAt = log.minute;
				} else if (log.event.contains("wakes up")) {
					if (!guards.containsKey(currentGuard)) {
						guards.put(currentGuard, new HashMap<>());
					}
					for (int i = asleepAt; i < log.minute; i++) {
						if (guards.get(currentGuard).containsKey(i)) {
							guards.get(currentGuard).put(i, guards.get(currentGuard).get(i) + 1);
						} else {
							guards.get(currentGuard).put(i, 1);
						}
					}
				}
			}

			return guards;
		} catch (IOException e) {
			return null;
		}
	}

}
