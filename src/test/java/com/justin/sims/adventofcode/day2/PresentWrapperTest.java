package com.justin.sims.adventofcode.day2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import com.justin.sims.adventofcode.utils.strategy.MultiplicationStrategy;


public class PresentWrapperTest {
	
	private MultiplicationStrategy strategy = new MultiplicationStrategy();
	
	@Test(expected = IllegalArgumentException.class)
	public void testPresentWrapperWithEmptyInput(){
		PresentWrapper.calculateTotalMaterialNeeded(Collections.emptyList(), strategy);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPresentWrapperWithNullInput(){
		PresentWrapper.calculateTotalMaterialNeeded(null, strategy);
	}
	
	@Test
	public void testPresentWrapperWithGivenExamples()
	{
		assertEquals(58, PresentWrapper.calculateTotalMaterialNeeded(Arrays.asList("2x3x4"), strategy));
		assertEquals(43, PresentWrapper.calculateTotalMaterialNeeded(Arrays.asList("1x1x10"), strategy));
	}
	
}
