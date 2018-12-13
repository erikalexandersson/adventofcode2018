package se.erikalexandersson.adventofcode.helpers;

public class Cart {

	private Point point;
	private Direction currentDirection;
	private int choice;
	private boolean crashed;

	public Cart(Point point, Direction currentDirection) {
		this.point = point;
		this.currentDirection = currentDirection;
		this.choice = 1;
	}

	public Point getPoint() {
		return point;
	}

	public Direction getCurrentDirection() {
		return currentDirection;
	}

	public int getChoice() {
		return choice;
	}

	public void setCrashed(boolean crashed) {
		this.crashed = crashed;
	}

	public boolean isCrashed() {
		return crashed;
	}

	public void tick(char ch) {
		switch (ch) {
		case '+':
			currentDirection = Direction.valueOf((currentDirection.value + choice) % 4);
			this.choice = (choice + 3) % 9;
			break;
		case '/':
			switch (currentDirection) {
			case EAST:
				this.currentDirection = Direction.NORTH;
				break;
			case NORTH:
				this.currentDirection = Direction.EAST;
				break;
			case WEST:
				this.currentDirection = Direction.SOUTH;
				break;
			case SOUTH:
				this.currentDirection = Direction.WEST;
				break;
			}
			break;
		case '\\':
			switch (currentDirection) {
			case EAST:
				this.currentDirection = Direction.SOUTH;
				break;
			case NORTH:
				this.currentDirection = Direction.WEST;
				break;
			case WEST:
				this.currentDirection = Direction.NORTH;
				break;
			case SOUTH:
				this.currentDirection = Direction.EAST;
				break;
			}
		default:
			break;
		}

		switch (currentDirection) {
		case EAST:
			this.point.x++;
			break;
		case NORTH:
			this.point.y--;
			break;
		case WEST:
			this.point.x--;
			break;
		case SOUTH:
			this.point.y++;
			break;
		}
	}

}
