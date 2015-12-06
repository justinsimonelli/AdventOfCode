package com.justin.sims.adventofcode.day6;

import java.awt.Point;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.justin.sims.adventofcode.utils.InputReader;

public class ProbablyAFireHazard {
	private static final String PUZZLE_INPUT_PATH = "resources/day6/input.txt";
	private static final Pattern p = Pattern
			.compile("((turn on)|(turn off)|(toggle))(\\s+)([0-9,]+)(\\s+through\\s+)([0-9,]+)");
	private static final String TURN_ON = "turn on";
	private static final String TURN_OFF = "turn off";
	private static final String TOGGLE = "toggle";

	public static void main(String[] args) {
		List<String> instructions = InputReader
				.getFileInputAsList(PUZZLE_INPUT_PATH);

		Map<Point, Integer> lightGrid = new HashMap<>();
		System.out.println("Running...");
		for (String instruction : instructions) {
			Matcher m = p.matcher(instruction);
			if (m.find()) {
				String[] startingPoints = m.group(6).split(",");
				String[] endingPoints = m.group(8).split(",");
				Point startingPoint = new Point(
						Integer.parseInt(startingPoints[0]),
						Integer.parseInt(startingPoints[1]));
				Point endingPoint = new Point(
						Integer.parseInt(endingPoints[0]),
						Integer.parseInt(endingPoints[1]));
				switch (m.group(1)) {
				case TURN_ON:
					for (int i = startingPoint.x; i <= endingPoint.x; i++) {
						for (int j = startingPoint.y; j <= endingPoint.y; j++) {
							Point p = new Point(i, j);
							if (lightGrid.containsKey(p)) {
								lightGrid.put(p, lightGrid.get(p) + 1);
							} else {
								lightGrid.put(p, 1);
							}
						}
					}
					break;
				case TURN_OFF:
					for (int i = startingPoint.x; i <= endingPoint.x; i++) {
						for (int j = startingPoint.y; j <= endingPoint.y; j++) {
							Point p = new Point(i, j);
							if (lightGrid.containsKey(p)
									&& lightGrid.get(p) > 0) {
								lightGrid.put(p, lightGrid.get(p) - 1);
							} else {
								lightGrid.put(p, 0);
							}
						}
					}
					break;
				case TOGGLE:
					for (int i = startingPoint.x; i <= endingPoint.x; i++) {
						for (int j = startingPoint.y; j <= endingPoint.y; j++) {
							Point p = new Point(i, j);
							if (lightGrid.containsKey(p)) {
								lightGrid.put(p, lightGrid.get(p) + 2);
							} else {
								lightGrid.put(p, 2);
							}

						}
					}
					break;
				default:
					break;
				}
			}
		}

		int total = 0;
		for (int val : lightGrid.values()) {
			total += val;
		}

		System.out.println("Total brightness " + total);

	}
	
	/**
	 * NEED TO FIX THIS. WILL THROW AN NPE
	private static void performActionsOnGrid( Point startingPoint, Point endingPoint,
			Map<Point, Integer> grid, char operation, int value, Integer minimumValue, boolean useMinimumValueAsValue ){
		
			for (int i = startingPoint.x; i <= endingPoint.x; i++) {
				for (int j = startingPoint.y; j <= endingPoint.y; j++) {
					Point p = new Point(i, j);
					if (grid.containsKey(p)) {
						Integer brightness = (grid.get(p) == null) ? 0 : grid.get(p);
						switch(operation){
							case '+': brightness += value;
							case '-': brightness = ( minimumValue != null && brightness > minimumValue ) ? brightness -= value : minimumValue;
							grid.put(p, brightness);
						}
					} else {
						if( useMinimumValueAsValue == true ){
							grid.put(p, minimumValue);
						}else{
							grid.put(p, value);
						}
						
					}
	
				}
			}
	}
	
	**/

}
