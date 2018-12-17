package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.OpCode;

public class Day16Part1 {

	public static void main(String args[]) throws URISyntaxException {
		System.out.println(parseFile(Paths.get(ClassLoader.getSystemResource("Day16Part1Input.txt").toURI())));
	}

	public static int parseFile(Path path) {
		int num = 0;
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
					if (getMatchingOpCodes(in, out, opcode, a, b, c).size() >= 3) {
						num++;
					}
				} else {
					opcode = Integer.valueOf(line.split(" ")[0]);
					a = Integer.valueOf(line.split(" ")[1]);
					b = Integer.valueOf(line.split(" ")[2]);
					c = Integer.valueOf(line.split(" ")[3]);
				}
			}

		} catch (IOException e) {
			return 0;
		}
		return num;
	}

	@OpCode
	public static int[] addr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] + res[b];
		return res;
	}

	@OpCode
	public static int[] addi(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] + b;
		return res;
	}

	@OpCode
	public static int[] mulr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] * res[b];
		return res;
	}

	@OpCode
	public static int[] muli(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] * b;
		return res;
	}

	@OpCode
	public static int[] banr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] & res[b];
		return res;
	}

	@OpCode
	public static int[] bani(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] & b;
		return res;
	}

	@OpCode
	public static int[] borr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] | res[b];
		return res;
	}

	@OpCode
	public static int[] bori(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a] | b;
		return res;
	}

	@OpCode
	public static int[] setr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = res[a];
		return res;
	}

	@OpCode
	public static int[] seti(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		res[c] = a;
		return res;
	}

	@OpCode
	public static int[] gtir(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		if (a > reg[b]) {
			res[c] = 1;
		} else {
			res[c] = 0;
		}
		return res;
	}

	@OpCode
	public static int[] gtri(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		if (reg[a] > b) {
			res[c] = 1;
		} else {
			res[c] = 0;
		}
		return res;
	}

	@OpCode
	public static int[] gtrr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		if (reg[a] > reg[b]) {
			res[c] = 1;
		} else {
			res[c] = 0;
		}
		return res;
	}

	@OpCode
	public static int[] eqir(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		if (a == reg[b]) {
			res[c] = 1;
		} else {
			res[c] = 0;
		}
		return res;
	}

	@OpCode
	public static int[] eqri(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		if (reg[a] == b) {
			res[c] = 1;
		} else {
			res[c] = 0;
		}
		return res;
	}

	@OpCode
	public static int[] eqrr(int[] reg, int a, int b, int c) {
		int[] res = reg.clone();
		if (reg[a] == reg[b]) {
			res[c] = 1;
		} else {
			res[c] = 0;
		}
		return res;
	}

	public static List<Method> getMatchingOpCodes(int[] in, int[] out, int opcode, int a, int b, int c) {
		List<Method> result = new ArrayList<>();
		List<Method> methods = Arrays.asList(Day16Part1.class.getDeclaredMethods()).stream()
				.filter(m -> m.isAnnotationPresent(OpCode.class)).collect(Collectors.toList());

		for (Method method : methods) {
			try {
				int[] res = (int[]) method.invoke(null, in, a, b, c);
				if (Arrays.equals(res, out)) {
					result.add(method);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		}

		return result;
	}

}
