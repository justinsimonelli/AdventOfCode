package com.justin.sims.adventofcode.day5;

public class AlgoOne extends NaughtyOrNiceAlgo {

	@Override
	public int determineIfNaughtyOrNice(String input) {
		int goodStrings = 0;
		int numberOfGoodCharsFound = 0;
		boolean containsGoodDouble = false;
		boolean containsUnallowableChars = false;

		for (int i = 1; i < input.length(); i++) {
			char c = input.charAt(i);
			char prev = input.charAt(i - 1);

			if (vowels.contains(prev))
				numberOfGoodCharsFound++;
			if (i == input.length() - 1 && vowels.contains(c))
				numberOfGoodCharsFound++;

			if (unallowableDoubleChars.matcher(
					String.valueOf(prev) + String.valueOf(c)).find()) {
				containsUnallowableChars = true;
			} else if (c == prev) {
				containsGoodDouble = true;
			}
		}
		if (numberOfGoodCharsFound > 2 && containsGoodDouble
				&& containsUnallowableChars == false) {
			goodStrings++;
		}
		return goodStrings;
	}

}
