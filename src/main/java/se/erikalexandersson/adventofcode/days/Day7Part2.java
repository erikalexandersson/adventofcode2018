package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class Day7Part2 {

	public Day7Part2() {
	}

	public static void main(String args[]) throws URISyntaxException, IOException {
		System.out.println(Day7Part2.getExecutionTime(
				Day7Part1.parseFile(Paths.get(ClassLoader.getSystemResource("Day7Input.txt").toURI())), 5, 60));
	}

	public static int getExecutionTime(Map<String, Set<String>> instructions, int numWorkers, int extraDuration) {
		Map<Integer, Integer> workers = new HashMap<>();
		Map<Integer, String> workingOn = new HashMap<>();
		for (int i = 0; i < numWorkers; i++) {
			workers.put(i, null);
		}

		int currentSecond = 0;

		while (!instructions.isEmpty() || workingOn.values().stream().filter(step -> step != null).count() > 0) {
			List<String> steps = instructions.entrySet().stream()
					.filter(entry -> entry.getValue().isEmpty()).sorted((Entry<String, Set<String>> e1,
							Entry<String, Set<String>> e2) -> e1.getKey().compareTo(e2.getKey()))
					.map(entry -> entry.getKey()).collect(Collectors.toList());

			List<Integer> freeWorkers = workers.entrySet().stream()
					.filter(entry -> entry.getValue() == null || entry.getValue() == 0).map(entry -> entry.getKey())
					.collect(Collectors.toList());

			for (String step : steps) {
				Iterator<Integer> it = freeWorkers.iterator();
				while (it.hasNext()) {
					Integer freeWorker = it.next();
					workers.put(freeWorker, step.toCharArray()[0] - 'A' + extraDuration + 1);
					workingOn.put(freeWorker, step);
					instructions.remove(step);
					it.remove();
					break;
				}
			}

			Iterator<Entry<Integer, Integer>> it = workers.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, Integer> entry = it.next();
				int worker = entry.getKey();
				Integer workLeft = entry.getValue();
				if (workLeft != null && workLeft > 0) {
					int newValue = workLeft - 1;
					workers.put(worker, newValue);
					if (newValue == 0) {
						String step = workingOn.get(worker);
						instructions.values().forEach(list -> list.remove(step));
						workingOn.put(worker, null);
					}
				}
			}
			currentSecond++;
		}
		return currentSecond;
	}

}
