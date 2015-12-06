package com.justin.sims.adventofcode.day5;

public class AlgoTwo extends NaughtyOrNiceAlgo {

	@Override
	public int determineIfNaughtyOrNice(String input) {
		boolean repeatedLetter = false;
		boolean repeatedGroup = false;

		for (int i = 2; i < input.length(); i++) {
			if (input.length() < 3) {
				throw new IllegalArgumentException(
						"Input needs to be at least 3 characters long to follow the rules.");
			}
			char current = input.charAt(i);

			if (current == input.charAt(i - 2))
				repeatedLetter = true;
			if (input.substring(i).contains(
					String.valueOf(input.charAt(i - 2)) + String.valueOf(input.charAt(i - 1))))
				repeatedGroup = true;

		}

		return (repeatedLetter && repeatedGroup) ? 1 : 0;
	}

}
