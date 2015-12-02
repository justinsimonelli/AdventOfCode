package com.justin.sims.adventofcode.day1;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.justin.sims.adventofcode.day1.FloorFinder;

public class FloorFinderTests {
	
	@Test
	public void testFloorFinderWithEmptyInput(){
		assertEquals(0, FloorFinder.solvePuzzle(""));
	}
	
	@Test
	public void testFloorFinderWithNullInput(){
		assertEquals(0, FloorFinder.solvePuzzle(null));
	}

	@Test
	public void testFloorFinderWithGivenExamples() {

		// should return 0
		assertEquals(0, FloorFinder.solvePuzzle("(())"));
		assertEquals(0, FloorFinder.solvePuzzle("()()"));

		// should return 3
		assertEquals(3, FloorFinder.solvePuzzle("((("));
		assertEquals(3, FloorFinder.solvePuzzle("(()(()("));
		assertEquals(3, FloorFinder.solvePuzzle("))((((("));

		// should return -1
		assertEquals(-1, FloorFinder.solvePuzzle("())"));
		assertEquals(-1, FloorFinder.solvePuzzle("))("));

		// should return -3
		assertEquals(-3, FloorFinder.solvePuzzle(")))"));
		assertEquals(-3, FloorFinder.solvePuzzle(")())())"));

	}

}
