package com.justin.sims.adventofcode.day9;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import com.justin.sims.adventofcode.utils.InputReader;

public class RouteOptimizer {
	private final static String PUZZLE_INPUT_PATH = "resources/day9/input.txt";
	private static TreeMap<Integer, String> routes = new TreeMap<>();
	private static List<String> locations = new ArrayList<>();
	private static List<String> permutations = new ArrayList<>();

	public static void main(String[] args) {
		List<String> input = InputReader.getFileInputAsList(PUZZLE_INPUT_PATH);

		input.forEach(i -> {
			String[] route = i.split("=");
			routes.put(Integer.parseInt(route[1].trim()), route[0].trim());

			String[] cities = route[0].split("to");
			if( !locations.contains(cities[0].trim()) ){
				locations.add(cities[0].trim());
			}
			
			if( !locations.contains(cities[1].trim()) ){
				locations.add(cities[1].trim());
			}
		});

		locations.forEach(s ->{
			System.out.println(s);
		});
		StringBuilder sb = new StringBuilder();
		boolean[] used = new boolean[locations.size()];
		//doPermute(sb, used, locations.size(), 0);
		//System.out.println(sb.toString());
	}

	private static void doPermute(StringBuilder outputString, boolean[] used,
			int inputLength, int level) {
		if (level == inputLength) {
			System.out.println(outputString.toString());
			return;
		}

		for (int i = 0; i < inputLength; ++i) {

			if (used[i])
				continue;

			outputString.append(locations.get(i) + "->");
			used[i] = true;
			doPermute(outputString, used, locations.size(), level + 1);
			used[i] = false;
			//outputString.setLength(outputString.length() - 1);
		}
	}

}
