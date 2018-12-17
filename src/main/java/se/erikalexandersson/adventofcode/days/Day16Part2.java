package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day16Part2 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(runProgram(Paths.get(ClassLoader.getSystemResource("Day16Part2Input.txt").toURI()),
				parseFile(Paths.get(ClassLoader.getSystemResource("Day16Part1Input.txt").toURI()))));
	}

	private static int runProgram(Path path, Map<Integer, Method> opCodes) {
		int[] in = { 0, 0, 0, 0 };
		int[] out = in;
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.filter(line -> !line.trim().isEmpty()).collect(Collectors.toList());

			int opcode = 0, a = 0, b = 0, c = 0;
			for (String line : lines) {
				opcode = Integer.valueOf(line.split(" ")[0]);
				a = Integer.valueOf(line.split(" ")[1]);
				b = Integer.valueOf(line.split(" ")[2]);
				c = Integer.valueOf(line.split(" ")[3]);
				out = (int[]) opCodes.get(opcode).invoke(null, out, a, b, c);
			}

		} catch (IOException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			return 0;
		}

		return out[0];
	}

	public static Map<Integer, Method> parseFile(Path path) {
		Map<Integer, Method> programs = new HashMap<>();
		Map<Integer, Set<Method>> possiblePrograms = new HashMap<>();
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.filter(line -> !line.trim().isEmpty()).collect(Collectors.toList());

			int[] in = null, out;
			int opcode = 0, a = 0, b = 0, c = 0;
			for (String line : lines) {
				if (line.startsWith("Before")) {
					in = Arrays.asList(line.split("\\[")[1].replaceAll("\\s+", "").replaceAll("\\]", "").split(","))
							.stream().mapToInt(s -> Integer.valueOf(s)).toArray();
				} else if (line.startsWith("After")) {
					out = Arrays.asList(line.split("\\[")[1].replaceAll("\\s+", "").replaceAll("\\]", "").split(","))
							.stream().mapToInt(s -> Integer.valueOf(s)).toArray();
					List<Method> methods = Day16Part1.getMatchingOpCodes(in, out, opcode, a, b, c);

					if (!programs.containsKey(opcode)) {

						if (!possiblePrograms.containsKey(opcode)) {
							possiblePrograms.put(opcode, new HashSet<>());
						}
						possiblePrograms.get(opcode).addAll(methods);

					}
				} else {
					opcode = Integer.valueOf(line.split(" ")[0]);
					a = Integer.valueOf(line.split(" ")[1]);
					b = Integer.valueOf(line.split(" ")[2]);
					c = Integer.valueOf(line.split(" ")[3]);
				}
			}

		} catch (IOException e) {
			return null;
		}

		while (programs.keySet().size() < 16 && !possiblePrograms.keySet().isEmpty()) {
			Iterator<Entry<Integer, Set<Method>>> it = possiblePrograms.entrySet().iterator();
			while (it.hasNext()) {
				Entry<Integer, Set<Method>> entry = it.next();
				Set<Method> methods = entry.getValue();
				if (methods.size() == 1) {
					Integer opCode = entry.getKey();
					Method method = entry.getValue().stream().findAny().get();
					programs.put(opCode, method);
					it.remove();
					possiblePrograms.values().stream().forEach(list -> list.remove(method));
				}
			}
		}

		return programs;
	}

}
