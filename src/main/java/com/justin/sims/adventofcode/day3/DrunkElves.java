package com.justin.sims.adventofcode.day3;

import java.awt.Point;

import com.justin.sims.adventofcode.utils.InputReader;

/**
 * <p><b>--- Day 3: Perfectly Spherical Houses in a Vacuum ---</b></p>
 * Santa is delivering presents to an infinite two-dimensional grid of houses.
 * <p/>
 * He begins by delivering a present to the house at his starting location, and then an elf at the North Pole calls him
 * via radio and tells him where to move next. Moves are always exactly one house to the north (^), south (v), east (>),
 * or west (<). After each move, he delivers another present to the house at his new location.
 * <p/>
 * However, the elf back at the north pole has had a little too much eggnog, and so his directions are a little off,
 * and Santa ends up visiting some houses more than once. How many houses receive at least one present?
 * <p/>
 * For example:
 * <p/>
 * > delivers presents to 2 houses: one at the starting location, and one to the east.
 * ^>v< delivers presents to 4 houses in a square, including twice to the house at his starting/ending location.
 * ^v^v^v^v^v delivers a bunch of presents to some very lucky children at only 2 houses.
 * --- Part Two ---
 * <p/>
 * The next year, to speed up the process, Santa creates a robot version of himself, Robo-Santa, to deliver presents
 * with him.
 * <p/>
 * Santa and Robo-Santa start at the same location (delivering two presents to the same starting house), then take turns
 * moving based on instructions from the elf, who is eggnoggedly reading from the same script as the previous year.
 * <p/>
 * This year, how many houses receive at least one present?
 * <p/>
 * For example:
 *      ^v delivers presents to 3 houses, because Santa goes north, and then Robo-Santa goes south.
 *      ^>v< now delivers presents to 3 houses, and Santa and Robo-Santa end up back where they started.
 *      ^v^v^v^v^v now delivers presents to 11 houses, with Santa going one direction and Robo-Santa going the other.
 * source: http://adventofcode.com/day/3
 * 
 * @author Sims
 *
 */
public class DrunkElves {

	private final static String PUZZLE_INPUT_PATH = "resources/day3/input.txt";

	public static void main(String[] args) throws Exception {

		int housesVisited = visitAndCountHouses(
				InputReader.getFileInputAsString(PUZZLE_INPUT_PATH), false);

		System.out.println(String.format(
				"%d houses got a present with 1 Santa", housesVisited));

		housesVisited = visitAndCountHouses(
				InputReader.getFileInputAsString(PUZZLE_INPUT_PATH), true);

		System.out.println(String.format(
				"%d houses got a present with 2 Santas", housesVisited));
	}

	/**
	 * Visit the houses specified in the directions. 1 direction (the band)
	 * means 2 houses will be visited.
	 * 
	 * @param directions
	 * @param hasRobotHelper
	 * @return
	 */
	public static int visitAndCountHouses(String directions,
			final boolean hasRobotHelper) {

		if (directions == null || directions.length() == 0) {
			return 0;
		}

		Santa ogSanta = new Santa(0, 0);
		Santa roboSanta = null;
		boolean isSantaDelivering = true;

		if (hasRobotHelper == true) {
			roboSanta = new Santa(0, 0);
		}

		for (int i = 0; i < directions.length(); i++) {
			if (isSantaDelivering == true) {
				moveAndAddHouseToSet(directions.charAt(i), ogSanta);
				isSantaDelivering = (hasRobotHelper) ? false : true;
			} else if (isSantaDelivering == false) {
				moveAndAddHouseToSet(directions.charAt(i), roboSanta);
				isSantaDelivering = true;
			}
		}

		if (hasRobotHelper == true) {
			ogSanta.getHousesVisited().addAll(roboSanta.getHousesVisited());
		}

		return ogSanta.getHousesVisited().size();
	}

	/**
	 * Moves Santa in the direction specified, and adds the house (Point) to the
	 * Set of houses that Santa has visited.
	 * 
	 * @param direction
	 * @param santa
	 */
	private static void moveAndAddHouseToSet(char direction, Santa santa) {

		if (santa == null) {
			throw new IllegalArgumentException("Santa object cannot be null!");
		}

		switch (direction) {
		case '^':
			santa.getCurrentPosition().y++;
			break;
		case 'v':
			santa.getCurrentPosition().y--;
			break;
		case '<':
			santa.getCurrentPosition().x--;
			break;
		case '>':
			santa.getCurrentPosition().x++;
			break;
		}

		santa.getHousesVisited().add(
				new Point(santa.getCurrentPosition().x, santa
						.getCurrentPosition().y));
	}
}
