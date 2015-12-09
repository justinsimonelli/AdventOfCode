package com.justin.sims.adventofcode.day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		
		try { 
			return Integer.parseInt(mappings.get(wire));
		} catch (NumberFormatException e) {

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

		Integer leftVal = null;
		Integer rightVal = null;
		Integer value = null;
		String[] instructions = splitInstruction(operation);
			
		if( instructions[0].trim().startsWith("NOT")  ){
			return 65535 - getDirectionsForWire(instructions[1]);
		}
		
		try {
			leftVal  = Integer.parseInt(instructions[0]);
		} catch (NumberFormatException e) {
			leftVal = getDirectionsForWire(instructions[0]);
		}
				
		if( instructions.length > 2 ){
			
			try {
				rightVal = Integer.parseInt(instructions[2]);
			} catch (NumberFormatException e) {
				rightVal = getDirectionsForWire(instructions[2]);
			}
			
			switch (instructions[1]) {
			case "LSHIFT":
				value = leftVal << rightVal;
				break;
			case "RSHIFT":
				value = leftVal >> rightVal;
				break;
			case "AND":
				value = leftVal & rightVal;
				break;
			case "OR":
				value = leftVal | rightVal;
				break;

			default:
				break;
			}
		}

		return value;

	}

	private static String[] splitInstruction(String instruction) {
		String[] instructions = instruction.trim().split(" ");

		return instructions;
	}

	private static void generateMappingsFromInput(List<String> input) {
		input.forEach(i -> {
			String[] instructions = i.split("->");
			mappings.put(instructions[1].trim(), instructions[0].trim());
		});
	}

}
