package se.erikalexandersson.adventofcode.days;

import java.util.ArrayList;
import java.util.List;

public class Day14Part1 {

	private List<Integer> recipes;
	private int elf1pos;
	private int elf2pos;

	public Day14Part1() {
		this.recipes = new ArrayList<>();
		this.recipes.add(3);
		this.recipes.add(7);
		this.elf1pos = 0;
		this.elf2pos = 1;
	}

	public static void main(String args[]) {
		Day14Part1 day14Part1 = new Day14Part1();
		System.out.println(day14Part1.getScore(110201));
	}

	public String getScore(int numRecipes) {

		while (recipes.size() < numRecipes + 10) {
			String newScore = String.valueOf(recipes.get(elf1pos) + recipes.get(elf2pos));
			recipes.add(Integer.valueOf(String.valueOf(newScore).substring(0, 1)));
			if (newScore.length() > 1) {
				recipes.add(Integer.valueOf(String.valueOf(newScore).substring(1)));
			}
			elf1pos = (elf1pos + 1 + recipes.get(elf1pos)) % recipes.size();
			elf2pos = (elf2pos + 1 + recipes.get(elf2pos)) % recipes.size();
		}

		String result = "";
		for (int i = 0; i < 10; i++) {
			result += recipes.get(i + numRecipes);
		}
		return result;
	}

}
