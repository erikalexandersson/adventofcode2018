package se.erikalexandersson.adventofcode.helpers;

import java.util.Comparator;

public class Fighter implements Comparator<Fighter>, Comparable<Fighter> {

	private Race race;
	private Point position;
	private int hitPoints;
	private int attackPower;

	public Fighter(Race race, Point position, int hitPoints, int attackPower) {
		this.race = race;
		this.position = position;
		this.hitPoints = hitPoints;
		this.attackPower = attackPower;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public Race getRace() {
		return race;
	}

	@Override
	public int compare(Fighter f1, Fighter f2) {
		return f1.position.compareTo(f2.position);
	}

	@Override
	public int compareTo(Fighter other) {
		return compare(this, other);
	}

}
