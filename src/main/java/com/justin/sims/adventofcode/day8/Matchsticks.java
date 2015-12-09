package com.justin.sims.adventofcode.day8;

import com.justin.sims.adventofcode.utils.InputReader;

import java.util.List;

public class Matchsticks {
	private static final String PUZZLE_INPUT_PATH = "resources/day8/input.txt";
	private static final String HEX_PATTERN = "\\\\[xX][0-9A-Fa-f]{2}";
	private static final String ESCAPED_DOUBLE_QUOTE_PATTERN = "\\\"";
	private static final String DOUBLE_QUOTE_PATTERN = "(\")+";
	private static final String BACKSLASH_PATTERN = "\\\\";
	
	public static void main(String[] args) {
		List<String> input = InputReader.getFileInputAsList(PUZZLE_INPUT_PATH);
		
		int literal = input.stream()
                .mapToInt(i -> i.length())
                .sum();
		
		int inMemory = input.stream()
                .map(x -> x.replace(BACKSLASH_PATTERN, "B"))
                .map(x -> x.replace(ESCAPED_DOUBLE_QUOTE_PATTERN, "Q"))
                .map(x -> x.replaceAll(DOUBLE_QUOTE_PATTERN, ""))
                .map(x -> x.replaceAll(HEX_PATTERN, "H"))
                .mapToInt(x -> x.length())
                .sum();
		
		System.out.println(String.format("literal = %d", literal));
		System.out.println(String.format("memory = %d", inMemory));
		System.out.println(String.format("Total chars = %d",literal - inMemory));
		
		/**
		 * PART TWO
		 */
		
		int inMemory2 = input.stream()
				.map(x -> x.replaceAll(HEX_PATTERN, "HHHHH"))
                .map(x -> x.replace(ESCAPED_DOUBLE_QUOTE_PATTERN, "QQQQ"))
                .map(x -> x.replace(BACKSLASH_PATTERN, "HHHH"))
                .mapToInt(x -> x.length() + 4)
                .sum();
		
		System.out.println("--- PART TWO ---");
		System.out.println(String.format("literal = %d", literal));
		System.out.println(String.format("memory = %d", inMemory2));
		System.out.println(String.format("Total chars = %d", inMemory2 - literal));
		
	}

}
