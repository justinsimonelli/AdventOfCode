package com.justin.sims.adventofcode.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Santa is trying to deliver presents in a large apartment building, but he
 * can't find the right floor - the directions he got are a little confusing. He
 * starts on the ground floor (floor 0) and then follows the instructions one
 * character at a time. An opening parenthesis, (, means he should go up one
 * floor, and a closing parenthesis, ), means he should go down one floor. The
 * apartment building is very tall, and the basement is very deep; he will never
 * find the top or bottom floors. For example:
 * 
 * (()) and ()() both result in floor 0. ((( and (()(()( both result in floor 3.
 * ))((((( also results in floor 3. ()) and ))( both result in floor -1 (the
 * first basement level). ))) and )())()) both result in floor -3. To what floor
 * do the instructions take Santa?
 * 
 * @author Sims
 *
 */
public class FloorFinder {

	private final static String PUZZLE_INPUT_PATH = "resources/day1/input.txt";

	public static void main(String[] args) {
		Integer floorSantaIsOn = solvePuzzle( getPuzzleInput(PUZZLE_INPUT_PATH) );
		
		System.out.println("Santa is on floor " + floorSantaIsOn);

	}

	/**
	 * Given the path to the file, try to read it and return the string
	 * representation of the input.
	 * 
	 * @param path
	 * @return
	 */
	public static String getPuzzleInput(String path) {

		try (Stream<String> stream = Files.lines(Paths.get(PUZZLE_INPUT_PATH))) {

			return stream.collect(Collectors.joining());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Solve the puzzle!
	 * 
	 * @param input
	 * @return
	 */
	public static int solvePuzzle(String input){
		
		if( input == null || input.length() == 0 )
		{
			return 0;
		}
		
		AtomicInteger direction = new AtomicInteger();

		input.chars().mapToObj(i -> (char) i).forEach(directionChar -> {
			if( '(' == directionChar ){
				direction.incrementAndGet();
			}else if( ')' == directionChar ){
				direction.decrementAndGet();
			}
		});
		
		
		return direction.get();
	}

}
