package com.justin.sims.adventofcode.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;

import com.justin.sims.adventofcode.utils.InputReader;

public class SomeAssemblyRequired {
	private static final String PUZZLE_INPUT_PATH = "resources/day7/input.txt";
	private static Map<String, String> mappings = new HashMap<>();
	private static final List<String> input = InputReader
			.getFileInputAsList(PUZZLE_INPUT_PATH);
	private static Map<String, Integer> values = new HashMap<>();

	public static void main(String[] args) {
		init();
		int val = getDirectionsForWire("a");
		System.out.println("'a' has a value of " + val);
		
		System.out.println("--- PART TWO ---");
		values.clear();
		mappings.clear();
		init();
		mappings.put("b", String.valueOf(val));
		int val2 = getDirectionsForWire("a");
		System.out.println("'a' has a new value of " + val2 + " after assigning 'b' to " + val);
		
	}

	private static int getDirectionsForWire(String wire) {
		
		if( NumberUtils.isDigits(mappings.get(wire)) ){
			return Integer.parseInt(mappings.get(wire));
		}
		
		if (!values.containsKey(wire)) {

			String instruction = mappings.get(wire);
			Integer value = null;

			if (instruction.length() <= 2) {
				return getDirectionsForWire(instruction);
			} else {
				value = performOperation(instruction);
			}
			
			values.put(wire, value);

		}

		return values.get(wire);
	}

	private static void init() {
		generateMappingsFromInput(input);
	}

	private static int performOperation(String operation) {

		String[] instructions = splitInstruction(operation);
			
		if( instructions[0].trim().startsWith("NOT")  ){
			return 65535 - getDirectionsForWire(instructions[1]);
		}
		
		Integer leftVal = ( NumberUtils.isDigits(instructions[0]) ) ? Integer.parseInt(instructions[0]) : getDirectionsForWire(instructions[0]);		
		Integer rightVal = ( NumberUtils.isDigits(instructions[2]) ) ? Integer.parseInt(instructions[2]) : getDirectionsForWire(instructions[2]);
		
		switch (instructions[1]) {
		case "LSHIFT":
			return leftVal << rightVal;
		case "RSHIFT":
			return leftVal >> rightVal;
		case "AND":
			return leftVal & rightVal;
		case "OR":
			return leftVal | rightVal;
		}
		
		return 0;

	}

	private static String[] splitInstruction(String instruction) {
		return instruction.trim().split(" ");
	}

	private static void generateMappingsFromInput(List<String> input) {
		input.forEach(i -> {
			String[] instructions = i.split("->");
			mappings.put(instructions[1].trim(), instructions[0].trim());
		});
	}

}
