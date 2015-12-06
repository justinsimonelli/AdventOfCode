package com.justin.sims.adventofcode.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class NaughtyOrNiceAlgo {
	protected static final Pattern unallowableDoubleChars = Pattern.compile("(ab)|(cd)|(pq)|(xy)");
	protected static final List<Character> vowels = getVowelList();

	private static List<Character> getVowelList() {
		List<Character> allowedVowels = new ArrayList<>();

		allowedVowels.add('a');
		allowedVowels.add('e');
		allowedVowels.add('i');
		allowedVowels.add('o');
		allowedVowels.add('u');

		return allowedVowels;
	}
	
	public abstract int determineIfNaughtyOrNice(String input);
	
	
}
