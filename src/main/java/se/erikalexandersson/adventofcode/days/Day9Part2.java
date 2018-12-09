package se.erikalexandersson.adventofcode.days;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day9Part2 {

	private List<BigInteger> playfield;
	private int playfieldSize;
	private Map<Integer, BigInteger> score;
	private int players;
	private int lastMarble;
	private int currentPosition;
	private int currentPlayer;
	private int currentTurn;

	public Day9Part2(int players, int lastMarble) {
		this.currentPosition = 0;
		this.currentTurn = 0;
		this.currentPlayer = 0;
		this.playfield = new ArrayList<>();
		playfield.add(new BigInteger("0"));
		this.playfieldSize = 1;
		this.players = players;
		this.lastMarble = lastMarble;
		this.score = new HashMap<>();
		for (int i = 1; i <= players; i++) {
			this.score.put(i, new BigInteger("0"));
		}
	}

	public static void main(String args[]) {
		Day9Part2 day9 = new Day9Part2(473, 100 * 70904);
		day9.play();
		System.out.println(day9.getHighScore());
	}

	public BigInteger getHighScore() {
		return score.values().stream().sorted((b1, b2) -> b2.compareTo(b1)).findFirst().orElse(new BigInteger("0"));
	}

	public void play() {
		while (currentTurn < lastMarble) {
			takeTurn();
		}
	}

	public List<BigInteger> getPlayfield() {
		return playfield;
	}

	public int getCurrentPosition() {
		return this.currentPosition;
	}

	public void takeTurn() {
		currentTurn++;
		currentPlayer = (currentPlayer % players) + 1;
		if (currentTurn % 23 == 0) {
			score.put(currentPlayer, score.get(currentPlayer).add(new BigInteger(Integer.toString(currentTurn))));
			int toRemove = Math.floorMod(currentPosition - 7, playfieldSize);
			BigInteger points = removeFromPlayfield(toRemove);
			score.put(currentPlayer, score.get(currentPlayer).add(points));
			currentPosition = toRemove;
		} else {
			currentPosition = insertIntoPlayfield(currentTurn);
		}
	}

	private int insertIntoPlayfield(int value) {
		int position = (currentPosition + 2) % playfieldSize;
		playfield.add(position, new BigInteger(Integer.toString(value)));
		playfieldSize++;
		return position;
	}

	private BigInteger removeFromPlayfield(int toRemove) {
		BigInteger value = playfield.remove(toRemove);
		playfieldSize--;
		return value;
	}

}
