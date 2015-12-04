package com.justin.sims.adventofcode.day3;

import java.awt.Point;

import com.justin.sims.adventofcode.utils.InputReader;

/**
 * 
 * @author Sims
 *
 */
public class DrunkElves {

	private final static String PUZZLE_INPUT_PATH = "resources/day3/input.txt";

	public static void main(String[] args) throws Exception {

		int housesVisited = visitAndCountHouses(
				InputReader.getFileInputAsString(PUZZLE_INPUT_PATH), false);
		
		System.out.println(String.format("%d houses got a present with 1 Santa", housesVisited) );

		housesVisited = visitAndCountHouses(
				InputReader.getFileInputAsString(PUZZLE_INPUT_PATH), true);
		
		System.out.println(String.format("%d houses got a present with 2 Santas", housesVisited) );
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
