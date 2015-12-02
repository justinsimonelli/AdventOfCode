package com.justin.sims.adventofcode.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import com.justin.sims.adventofcode.utils.InputReader;

/**
 * <p>--- <b>Day 1: Not Quite Lisp</b> ---</p>
 * 
 * <p>Santa is trying to deliver presents in a large apartment building, but he
 * can't find the right floor - the directions he got are a little confusing. He
 * starts on the ground floor (floor 0) and then follows the instructions one
 * character at a time. </p>
 * 
 * <p>An opening parenthesis, <b>(</b>, means he should go up one floor, 
 * and a closing parenthesis, <b>)</b>, means he should go down one floor. 
 * The apartment building is very tall, 
 * and the basement is very deep; he will never find the top or bottom floors.
 * </p> 
 * <p>For example:
 * 	<ul>
 * 		<li>(()) and ()() both result in floor 0.</li> 
 * 		<li>((( and (()(()( both result in floor 3.</li>
 * 		<li>))((((( also results in floor 3. </li>
 * 		<li>()) and ))( both result in floor -1 (the first basement level).</li> 
 * 		<li>))) and )())()) both result in floor -3.</li>
 * 	</ul> 
 * To what floor do the instructions take Santa?</p>
 * 
 * @author Sims
 *
 */
public class FloorFinder {

	private final static String PUZZLE_INPUT_PATH = "resources/day1/input.txt";
	public final static String FLOOR_KEY = "floor";
	public final static String BASEMENT_KEY = "basement";

	public static void main(String[] args) {
		Map<String, Integer> floorMap = solvePuzzle( InputReader.getFileInputAsString(PUZZLE_INPUT_PATH) );
		
		System.out.println("Santa is on floor " + floorMap.get(FLOOR_KEY));
		System.out.println("Santa first entered the basement at index " + floorMap.get(BASEMENT_KEY));

	}
	
	/**
	 * Solve the puzzle!
	 * 
	 * @param input
	 * @return
	 */
	public static Map<String, Integer> solvePuzzle(String input){
		
		if( input == null || input.length() == 0 )
		{
			return null;
		}
		
		AtomicInteger currentFloor = new AtomicInteger();
		Map<String, Integer> floorMap = new HashMap<>();
		AtomicBoolean hasEnteredBasement = new AtomicBoolean(false);
		
		IntStream.range(0, input.length()).forEach(idx -> {
			if( '(' == input.charAt(idx) ){
				currentFloor.incrementAndGet();
			}else if( ')' == input.charAt(idx) ){
				currentFloor.decrementAndGet();
			}
			
			if( currentFloor.get() == -1 && hasEnteredBasement.get() == false ){
				//idx+1 since this is 1 based instead of 0 based
				floorMap.put(BASEMENT_KEY, idx + 1);
				hasEnteredBasement.getAndSet(true);
			}
		});
		
		floorMap.put(FLOOR_KEY, currentFloor.get());
		
		return floorMap;
	}

}
