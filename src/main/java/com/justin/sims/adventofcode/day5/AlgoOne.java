package com.justin.sims.adventofcode.day5;

public class AlgoOne extends NaughtyOrNiceAlgo {

	@Override
	public int determineIfNaughtyOrNice(String input) {
		int numberOfGoodCharsFound = 0;
		boolean containsGoodDouble = false;
		boolean containsUnallowableChars = false;

		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			char prev = input.charAt(i - 1);

			numberOfGoodCharsFound += doesVowelListContainChar(prev);
			numberOfGoodCharsFound += ( i == input.length() -1 ) ? doesVowelListContainChar(c) : 0;

			if (unallowableDoubleChars.matcher(
					String.valueOf(prev) + String.valueOf(c)).find()) {
				containsUnallowableChars = true;
			} else if (c == prev) {
				containsGoodDouble = true;
			}
		}

		return (numberOfGoodCharsFound > 2 && containsGoodDouble && containsUnallowableChars == false) ? 1
				: 0;
	}
	
	private int doesVowelListContainChar(char c){
		return (vowels.contains(c)) ? 1 : 0;
	}

}
