package day3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.justin.sims.adventofcode.day3.DrunkElves;


public class DrunkElvesTest {

	@Test
	public void testNullInput(){
		assertEquals(0, DrunkElves.visitAndCountHouses(null, false));
	}
	
	@Test
	public void testEmptyInput(){
		assertEquals(0, DrunkElves.visitAndCountHouses("", false));
	}
	
}
