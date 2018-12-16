package se.erikalexandersson.adventofcode.days;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import se.erikalexandersson.adventofcode.helpers.Fighter;
import se.erikalexandersson.adventofcode.helpers.Point;
import se.erikalexandersson.adventofcode.helpers.Race;

public class Day15Part1 {

	protected char map[][];
	protected List<Fighter> elfs;
	protected List<Fighter> goblins;
	protected int round;

	protected int elfAttackPower;

	public Day15Part1(Path path) {
		this.elfs = new ArrayList<>();
		this.goblins = new ArrayList<>();
		this.round = 0;
		this.elfAttackPower = 3;
		parseFile(path);
	}

	public Day15Part1(Path path, int elfAttackPower) {
		this.elfs = new ArrayList<>();
		this.goblins = new ArrayList<>();
		this.round = 0;
		this.elfAttackPower = elfAttackPower;
		parseFile(path);
	}

	public static void main(String args[]) throws URISyntaxException {
		Day15Part1 day15Part1 = new Day15Part1(Paths.get(ClassLoader.getSystemResource("Day15Input.txt").toURI()));
		day15Part1.fight();
		System.out.println(day15Part1.getOutcome());
	}

	public int getOutcome() {
		if (elfs.size() > 0) {
			return round * elfs.stream().mapToInt(elf -> elf.getHitPoints()).sum();
		} else {
			return round * goblins.stream().mapToInt(goblin -> goblin.getHitPoints()).sum();
		}
	}

	public void fight() {
		while (elfs.size() > 0 && goblins.size() > 0) {
			boolean fullRound = true;
			// Each unit takes a turn
			List<Fighter> fighters = new ArrayList<>();
			fighters.addAll(elfs);
			fighters.addAll(goblins);

			Iterator<Fighter> it = fighters.stream().sorted().collect(Collectors.toList()).iterator();
			while (it.hasNext()) {

				if (!elfs.stream().filter(elf -> elf.getHitPoints() > 0).findAny().isPresent()
						|| !goblins.stream().filter(goblin -> goblin.getHitPoints() > 0).findAny().isPresent()) {
					fullRound = false;
				}

				Fighter currentFighter = it.next();
				if (currentFighter.getHitPoints() <= 0) {
					it.remove();
					continue;
				}

				// A turn is a set of actions

				// Identify all possible targets
				List<Fighter> targets;
				if (currentFighter.getRace().equals(Race.ELF)) {
					targets = goblins;
				} else {
					targets = elfs;
				}
				targets = targets.stream().filter(fighter -> fighter.getHitPoints() > 0).collect(Collectors.toList());

				if (attack(currentFighter, targets)) {
					continue;
				}

				List<Point> availablePoints = findAvailablePoints(targets);
				// If no possible targets end units turn
				if (availablePoints.isEmpty()) {
					continue;
				}

				// If not adjacent to a target, move

				// Determine squares that are in range and which square
				// could be reached in the fewest steps
				Map<Point, Integer> pointsWithDistance = findPath(currentFighter.getPosition(), availablePoints);

				if (pointsWithDistance.isEmpty()) {
					continue;
				}

				// Move a step closer
				Point moveToPoint = pointsWithDistance.entrySet().stream()
						.filter(entry -> checkAdjacency(currentFighter.getPosition(), entry.getKey()))
						.sorted((e1, e2) -> {
							if (e1.getValue().intValue() == e2.getValue().intValue()) {
								return e1.getKey().compareTo(e2.getKey());
							} else {
								return Integer.compare(e1.getValue(), e2.getValue());
							}
						}).findFirst().get().getKey();
				map[currentFighter.getPosition().y][currentFighter.getPosition().x] = '.';
				currentFighter.setPosition(moveToPoint);
				map[moveToPoint.y][moveToPoint.x] = currentFighter.getRace().getMarker();

				attack(currentFighter, targets);
			}
			elfs = elfs.stream().filter(fighter -> fighter.getHitPoints() > 0).collect(Collectors.toList());
			goblins = goblins.stream().filter(fighter -> fighter.getHitPoints() > 0).collect(Collectors.toList());
			if (fullRound) {
				round++;
			}
		}
	}

	private boolean attack(Fighter currentFighter, List<Fighter> targets) {
		// Attack if adjacent to a target
		List<Fighter> adjacentFighters = findAdjacentTargets(currentFighter, targets);

		Fighter target = adjacentFighters.stream().findFirst().orElse(null);
		if (target != null) {
			target.setHitPoints(target.getHitPoints() - currentFighter.getAttackPower());
			if (target.getHitPoints() <= 0) {
				map[target.getPosition().y][target.getPosition().x] = '.';
			}
			return true;
		}
		return false;
	}

	private Map<Point, Integer> findPath(Point fromPoint, List<Point> targetPoints) {
		Map<Point, Integer> result = new HashMap<>();
		List<Point> availablePoints = getAvailablePoints(fromPoint);

		Map<Point, Integer> pointsWithDistances = new HashMap<>();
		for (Point targetPoint : targetPoints) {
			pointsWithDistances.put(targetPoint, 0);
			getDistances(targetPoint, pointsWithDistances, 1);
		}

		availablePoints.stream().filter(point -> pointsWithDistances.containsKey(point))
				.forEach(point -> result.put(point, pointsWithDistances.get(point)));

		return result;
	}

	private void getDistances(Point targetPoint, Map<Point, Integer> pointsWithDistances, int distance) {
		for (Point availablePoint : getAvailablePoints(targetPoint)) {
			if (!pointsWithDistances.containsKey(availablePoint)) {
				pointsWithDistances.put(availablePoint, distance);
				getDistances(availablePoint, pointsWithDistances, distance + 1);
			} else {
				if (distance < pointsWithDistances.get(availablePoint)) {
					pointsWithDistances.put(availablePoint, distance);
					getDistances(availablePoint, pointsWithDistances, distance + 1);
				}
			}
		}
	}

	private List<Point> getAvailablePoints(Point point) {
		List<Point> points = new ArrayList<>();
		if (point.y > 0 && map[point.y - 1][point.x] == '.') {
			Point north = new Point(point.x, point.y - 1);
			points.add(north);
		}
		if (point.y < map.length && map[point.y + 1][point.x] == '.') {
			Point south = new Point(point.x, point.y + 1);
			points.add(south);
		}
		if (point.x > 0 && map[point.y][point.x - 1] == '.') {
			Point west = new Point(point.x - 1, point.y);
			points.add(west);
		}
		if (point.x < map[point.y].length && map[point.y][point.x + 1] == '.') {
			Point east = new Point(point.x + 1, point.y);
			points.add(east);
		}
		return points;
	}

	private void findPath(Point fromPoint, Point targetPoint, List<Point> currentPath, List<List<Point>> paths) {
		if (currentPath.contains(fromPoint) || currentPath.contains(targetPoint)) {
			return;
		}
		currentPath.add(targetPoint);

		if (!fromPoint.equals(targetPoint)) {

			for (Point point : getAvailablePoints(targetPoint)) {
				// boolean foundBetter = false;
				// for (List<Point> path : paths) {
				// if (path.contains(point)) {
				// int i = path.indexOf(point);
				// int j = currentPath.size();
				// if (j < i) {
				// foundBetter = true;
				// break;
				// }
				// }
				// }
				// if (!foundBetter) {
				addPath(point, fromPoint, targetPoint, currentPath, paths);
				// }
			}
		}
	}

	private void addPath(Point point, Point fromPoint, Point targetPoint, List<Point> currentPath,
			List<List<Point>> paths) {
		List<Point> newPath = new ArrayList<>(currentPath);
		paths.add(newPath);
		findPath(fromPoint, point, newPath, paths);
	}

	private List<Fighter> findAdjacentTargets(Fighter currentFighter, List<Fighter> targets) {
		return targets.stream().filter(target -> checkAdjacency(currentFighter.getPosition(), target.getPosition()))
				.sorted((f1, f2) -> {
					if (f1.getHitPoints() == f2.getHitPoints()) {
						return f1.getPosition().compareTo(f2.getPosition());
					} else {
						return Integer.compare(f1.getHitPoints(), f2.getHitPoints());
					}
				}).collect(Collectors.toList());
	}

	private boolean checkAdjacency(Point point, Point point2) {
		int x1 = point.x;
		int y1 = point.y;
		int x2 = point2.x;
		int y2 = point2.y;

		if (y1 == y2 && Math.abs(x1 - x2) == 1) {
			return true;
		}
		if (x1 == x2 && Math.abs(y1 - y2) == 1) {
			return true;
		}
		return false;
	}

	private List<Point> findAvailablePoints(List<Fighter> targets) {
		List<Point> points = new ArrayList<>();
		targets.forEach(target -> {
			int x = target.getPosition().x;
			int y = target.getPosition().y;
			if (y > 0 && map[y - 1][x] == '.') {
				points.add(new Point(x, y - 1));
			}
			if (y < map.length && map[y + 1][x] == '.') {
				points.add(new Point(x, y + 1));
			}
			if (x > 0 && map[y][x - 1] == '.') {
				points.add(new Point(x - 1, y));
			}
			if (x < map[y].length && map[y][x + 1] == '.') {
				points.add(new Point(x + 1, y));
			}
		});
		return points;
	}

	public void parseFile(Path path) {
		try (Stream<String> stream = Files.lines(path)) {
			List<String> lines = stream.collect(Collectors.toList());

			map = new char[lines.size()][lines.get(0).length()];

			for (int y = 0; y < lines.size(); y++) {
				String line = lines.get(y);
				for (int x = 0; x < line.length(); x++) {
					char ch = line.charAt(x);
					Point p = new Point(x, y);
					switch (ch) {
					case 'G':
						Fighter goblin = new Fighter(Race.GOBLIN, p, 200, 3);
						goblins.add(goblin);
						break;
					case 'E':
						Fighter elf = new Fighter(Race.ELF, p, 200, elfAttackPower);
						elfs.add(elf);
						break;

					default:
						break;
					}
					map[y][x] = ch;
				}
			}
		} catch (IOException e) {
		}
	}

}
