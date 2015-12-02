package com.justin.sims.adventofcode.day1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.justin.sims.adventofcode.day1.FloorFinder;

public class FloorFinderTest {
	
	@Test
	public void testFloorFinderWithEmptyInput(){
		assertEquals(null, FloorFinder.solvePuzzle(""));
	}
	
	@Test
	public void testFloorFinderWithNullInput(){
		assertEquals(null, FloorFinder.solvePuzzle(null));
	}

	@Test
	public void testFloorFinderWithGivenExamples() {

		// should return 0
		assertEquals(0, FloorFinder.solvePuzzle("(())").get(FloorFinder.FLOOR_KEY).intValue() );
		assertEquals(0, FloorFinder.solvePuzzle("()()").get(FloorFinder.FLOOR_KEY).intValue());

		// should return 3
		assertEquals(3, FloorFinder.solvePuzzle("(((").get(FloorFinder.FLOOR_KEY).intValue());
		assertEquals(3, FloorFinder.solvePuzzle("(()(()(").get(FloorFinder.FLOOR_KEY).intValue());
		assertEquals(3, FloorFinder.solvePuzzle("))(((((").get(FloorFinder.FLOOR_KEY).intValue());

		// should return -1
		assertEquals(-1, FloorFinder.solvePuzzle("())").get(FloorFinder.FLOOR_KEY).intValue());
		assertEquals(-1, FloorFinder.solvePuzzle("))(").get(FloorFinder.FLOOR_KEY).intValue());

		// should return -3
		assertEquals(-3, FloorFinder.solvePuzzle(")))").get(FloorFinder.FLOOR_KEY).intValue());
		assertEquals(-3, FloorFinder.solvePuzzle(")())())").get(FloorFinder.FLOOR_KEY).intValue());

	}
	
	@Test
	public void testEnteringAndExitingBasementReturningOnlyFirstInstance(){
		assertEquals(7, FloorFinder.solvePuzzle("()()())(()())").get(FloorFinder.BASEMENT_KEY).intValue());
	}

}
