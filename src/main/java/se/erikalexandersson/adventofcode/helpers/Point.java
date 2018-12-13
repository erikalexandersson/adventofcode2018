package se.erikalexandersson.adventofcode.helpers;

public class Point implements Comparable<Point> {

	public int x;
	public int y;

	public int vx;
	public int vy;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return x + "," + y;
	}

	@Override
	public int compareTo(Point p) {
		if (this.y == p.y) {
			return Integer.compare(this.x, p.x);
		} else {
			return Integer.compare(this.y, p.y);
		}
	}
}
