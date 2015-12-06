package com.justin.sims.adventofcode.day5;

public class AlgoOne extends NaughtyOrNiceAlgo {

	@Override
	public int determineIfNaughtyOrNice(String input) {
		int goodStrings = 0;
		int numberOfGoodCharsFound = 0;
		boolean containsGoodDouble = false;
		boolean containsUnallowableChars = false;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			char nextChar = (i != input.length() - 1) ? input.charAt(i + 1)
					: '0';
			String doubleString = String.valueOf(c)
					+ String.valueOf(nextChar);

			if (vowels.contains(c)) {
				numberOfGoodCharsFound++;
			}

			if (unallowableDoubleChars.matcher(doubleString).find()) {
				containsUnallowableChars = true;
			} else if (c == nextChar) {
				containsGoodDouble = true;
			}
		}
		if (numberOfGoodCharsFound >= 3 && containsGoodDouble
				&& containsUnallowableChars == false) {
			goodStrings++;
		}
		return goodStrings;
	}
	

}
