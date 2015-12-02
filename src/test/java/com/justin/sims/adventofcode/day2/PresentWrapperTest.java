package com.justin.sims.adventofcode.day2;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;


public class PresentWrapperTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testPresentWrapperWithEmptyInput(){
		PresentWrapper.calculateTotalWrappingPaperNeeded(Collections.emptyList());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPresentWrapperWithNullInput(){
		PresentWrapper.calculateTotalWrappingPaperNeeded(null);
	}
	
	@Test
	public void testPresentWrapperWithGivenExamples()
	{
		assertEquals(58, PresentWrapper.calculateTotalWrappingPaperNeeded(Arrays.asList("2x3x4")));
		assertEquals(43, PresentWrapper.calculateTotalWrappingPaperNeeded(Arrays.asList("1x1x10")));
	}
	
}
