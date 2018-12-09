package se.erikalexandersson.adventofcode.days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day9Part1 {

	private int[] playfield;
	private Map<Integer, Integer> score;
	private int players;
	private int lastMarble;
	private int currentPosition;
	private int currentPlayer;
	private int currentTurn;

	public Day9Part1(int players, int lastMarble) {
		int playfield[] = { 0 };
		this.currentPosition = 0;
		this.currentTurn = 0;
		this.currentPlayer = 0;
		this.playfield = playfield;
		this.players = players;
		this.lastMarble = lastMarble;
		this.score = new HashMap<>();
		for (int i = 1; i <= players; i++) {
			this.score.put(i, 0);
		}
	}

	public static void main(String args[]) {
		Day9Part1 day9 = new Day9Part1(473, 70904);
		day9.play();
		System.out.println(day9.getHighScore());
	}

	public int getHighScore() {
		return score.values().stream().mapToInt(val -> val.intValue()).max().orElse(0);
	}

	public void play() {
		while (currentTurn < lastMarble) {
			takeTurn();
		}
	}

	public int[] getPlayfield() {
		return playfield;
	}

	public int getCurrentPosition() {
		return this.currentPosition;
	}

	public void takeTurn() {
		currentTurn++;
		currentPlayer = (currentPlayer % players) + 1;
		if (currentTurn % 23 == 0) {
			score.put(currentPlayer, score.get(currentPlayer) + currentTurn);
			int toRemove = Math.floorMod(currentPosition - 7, playfield.length);
			int points = removeFromPlayfield(toRemove);
			score.put(currentPlayer, score.get(currentPlayer) + points);
			currentPosition = toRemove;
		} else {
			currentPosition = insertIntoPlayfield(currentTurn);
		}
	}

	private int insertIntoPlayfield(int value) {
		int position = (currentPosition + 2) % playfield.length;
		int newPlayfield[] = new int[playfield.length + 1];
		int lower[] = Arrays.copyOfRange(playfield, 0, position);
		int higher[] = Arrays.copyOfRange(playfield, position, playfield.length);
		for (int i = 0; i < lower.length; i++) {
			newPlayfield[i] = lower[i];
		}
		newPlayfield[position] = value;
		for (int i = 0; i < higher.length; i++) {
			newPlayfield[i + position + 1] = higher[i];
		}
		playfield = newPlayfield;
		return position;
	}

	private int removeFromPlayfield(int toRemove) {
		int value = playfield[toRemove];
		int newPlayfield[] = new int[playfield.length - 1];
		int lower[] = Arrays.copyOfRange(playfield, 0, toRemove);
		int higher[] = Arrays.copyOfRange(playfield, toRemove + 1, playfield.length);
		for (int i = 0; i < lower.length; i++) {
			newPlayfield[i] = lower[i];
		}
		for (int i = 0; i < higher.length; i++) {
			newPlayfield[i + toRemove] = higher[i];
		}
		playfield = newPlayfield;
		return value;
	}

}
