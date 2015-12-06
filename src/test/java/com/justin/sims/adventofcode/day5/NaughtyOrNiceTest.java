package com.justin.sims.adventofcode.day5;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import com.justin.sims.adventofcode.utils.InputReader;

public class NaughtyOrNiceTest {
	private final NaughtyOrNiceAlgo algoOne = new AlgoOne();
	private final NaughtyOrNiceAlgo algoTwo = new AlgoTwo();

	/** ALGO ONE TESTS **/
	@Test
	public void testNaughtyOrNice_AlgoOne_OneGoodString() {
		assertEquals(
				1,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("ugknbfddgicrmopn"), algoOne));
	}

	@Test
	public void testNaughtyOrNice_AlgoOne_RepeatingOneGoodString() {
		assertEquals(1, NaughtyOrNice.findNumberOfGoodStrings(
				Arrays.asList("aaa"), algoOne));
	}

	@Test
	public void testNaughtyOrNice_AlgoOne_BadStringNoRepeats() {
		assertEquals(
				0,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("jchzalrnumimnmhp"), algoOne));
	}

	@Test
	public void testNaughtyOrNice_AlgoOne_BadStringContainsBadDouble() {
		assertEquals(
				0,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("haegwjzuvuyypxyu"), algoOne));
	}

	@Test
	public void testNaughtyOrNice_AlgoOne_BadStringOnlyOneVowel() {
		assertEquals(
				0,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("dvszwmarrgswjxmb"), algoOne));
	}

	@Test
	public void testNaughtyOrNice_AlgoOne_ChallengeInput() {
		assertEquals(258, NaughtyOrNice.findNumberOfGoodStrings(
				InputReader.getFileInputAsList("resources/day5/input.txt"),
				algoOne));
	}
	
	/** ALGO TWO TESTS **/
	@Test
	public void testNaughtyOrNice_AlgoTwo_OneGoodString() {
		assertEquals(
				1,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("qjhvhtzxzqqjkmpb"), algoTwo));
	}
	
	@Test
	public void testNaughtyOrNice_AlgoTwo_OneGoodString2() {
		assertEquals(
				1,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("xxyxx"), algoTwo));
	}
	
	@Test
	public void testNaughtyOrNice_AlgoTwo_BadNoRepeatWithLetterBetween() {
		assertEquals(
				0,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("uurcxstgmygtbstg"), algoTwo));
	}
	
	@Test
	public void testNaughtyOrNice_AlgoTwo_BadNoRepeatingPair() {
		assertEquals(
				0,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("ieodomkazucvgmuy"), algoTwo));
	}
	
	@Test
	public void testNaughtyOrNice_AlgoTwo_BadAllTheSame() {
		assertEquals(
				0,
				NaughtyOrNice.findNumberOfGoodStrings(
						Arrays.asList("aaa"), algoTwo));
	}
	
	@Test
	public void testNaughtyOrNice_AlgoTwo_ChallengeInput() {
		assertEquals(
				53,
				NaughtyOrNice.findNumberOfGoodStrings(
						InputReader.getFileInputAsList("resources/day5/input.txt"), algoTwo));
	}

}
