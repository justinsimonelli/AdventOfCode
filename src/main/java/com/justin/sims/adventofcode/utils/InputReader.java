package com.justin.sims.adventofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

	/**
	 * Given the <code>filePath</code> param, load the input and return it as a
	 * string.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException
	 */
	private static Stream<String> readInputFromFile(String filePath)
			throws IOException {

		return Files.lines(Paths.get(filePath));

	}

	/**
	 * Get the Stream as a single String.
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileInputAsString(String filePath) {

		try (Stream<String> stream = readInputFromFile(filePath)) {

			return stream.collect(Collectors.joining());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Get the Stream as a list of String(s).
	 * 
	 * @param filePath
	 * @return
	 */
	public static List<String> getFileInputAsList(String filePath) {
		try (Stream<String> stream = readInputFromFile(filePath)) {

			return stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public static List<Integer[]> convertStringDimensionsToIntegers(
			List<String> input) {
		if (input == null || input.isEmpty()) {
			throw new IllegalArgumentException("input is null or empty.");
		}

		List<Integer[]> intList = new ArrayList<>();
		input.forEach(presentDimensions -> {
			String[] dimsString = presentDimensions.toLowerCase().split("x");
			if (dimsString == null || dimsString.length == 0) {
				throw new IllegalArgumentException(
						"unable to parse dimensions.");
			}

			Integer[] dims = new Integer[dimsString.length];

			for (int i = 0; i < dimsString.length; i++) {
				dims[i] = Integer.valueOf(dimsString[i]);
			}
			
			bubbleSort(dims);
			
			intList.add(dims);
		});
		return intList;
	}

	public static void bubbleSort(Integer[] input) {
		if (input == null || input.length == 0) {
			throw new IllegalArgumentException("input is null or empty.");
		}

		int temp;
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = 1; j < input.length - i; j++) {
				if (input[j - 1] > input[j]) {
					temp = input[j - 1];
					input[j - 1] = input[j];
					input[j] = temp;
				}
			}
		}
	}
}
