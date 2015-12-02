package com.justin.sims.adventofcode.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputReader {

	/**
	 * Given the <code>filePath</code> param,
	 * load the input and return it as a string.
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	private static Stream<String> readInputFromFile(String filePath) throws IOException{
		
		return Files.lines(Paths.get(filePath));

	}
	
	/**
	 * Get the Stream as a single String.
	 * 
	 * @param filePath
	 * @return
	 */
	public static String getFileInputAsString(String filePath){
		
		try (Stream<String> stream = readInputFromFile(filePath)) {

			return stream.collect(Collectors.joining());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static List<String> getFileInputAsList( String filePath ){
		try (Stream<String> stream = readInputFromFile(filePath)) {

			return stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
