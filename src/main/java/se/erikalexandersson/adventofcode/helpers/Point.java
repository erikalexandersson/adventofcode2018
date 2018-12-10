package se.erikalexandersson.adventofcode.helpers;

public class Point {

	public int x;
	public int y;

	public int vx;
	public int vy;

	public Point(int x, int y, int vx, int vy) {
		this.x = x;
		this.y = y;
		this.vx = vx;
		this.vy = vy;
	}

	public void step() {
		this.x += vx;
		this.y += vy;
	}
}
