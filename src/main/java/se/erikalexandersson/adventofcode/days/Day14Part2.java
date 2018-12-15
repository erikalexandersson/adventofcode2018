package se.erikalexandersson.adventofcode.days;

import java.util.ArrayList;
import java.util.List;

public class Day14Part2 {

	private List<Byte> recipes;
	private int elf1pos;
	private int elf2pos;

	public Day14Part2() {
		this.recipes = new ArrayList<>();
		this.recipes.add((byte) 3);
		this.recipes.add((byte) 7);
		this.elf1pos = 0;
		this.elf2pos = 1;
	}

	public static void main(String args[]) {
		Day14Part2 day14Part2 = new Day14Part2();
		System.out.println(day14Part2.getNumRecipes("110201"));
	}

	public int getNumRecipes(String str) {

		int length = str.length();
		int numRecipes = recipes.size();

		while (true) {
			String newScore = String.valueOf(recipes.get(elf1pos) + recipes.get(elf2pos));
			recipes.add(Byte.valueOf(String.valueOf(newScore).substring(0, 1)));
			numRecipes++;

			if (numRecipes > length) {
				String score = "";
				for (int i = length; i > 0; i--) {
					score += recipes.get(numRecipes - i);
				}
				if (score.equals(str)) {
					break;
				}
			}

			if (newScore.length() > 1) {
				recipes.add(Byte.valueOf(String.valueOf(newScore).substring(1)));
				numRecipes++;
			}

			if (numRecipes > length) {
				String score = "";
				for (int i = length; i > 0; i--) {
					score += recipes.get(numRecipes - i);
				}
				if (score.equals(str)) {
					break;
				}
			}

			elf1pos = (elf1pos + 1 + recipes.get(elf1pos)) % numRecipes;
			elf2pos = (elf2pos + 1 + recipes.get(elf2pos)) % numRecipes;
		}

		return numRecipes - length;
	}

}
