package com.justin.sims.adventofcode.day4;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * --- Day 4: The Ideal Stocking Stuffer ---
 * 
 * Santa needs help mining some AdventCoins (very similar to bitcoins) to use as
 * gifts for all the economically forward-thinking little girls and boys.
 * 
 * To do this, he needs to find MD5 hashes which, in hexadecimal, start with at
 * least five zeroes. The input to the MD5 hash is some secret key (your puzzle
 * input, given below) followed by a number in decimal. To mine AdventCoins, you
 * must find Santa the lowest positive number (no leading zeroes: 1, 2, 3, ...)
 * that produces such a hash.
 * 
 * For example:
 * 
 * If your secret key is abcdef, the answer is 609043, because the MD5 hash of
 * abcdef609043 starts with five zeroes (000001dbbfa...), and it is the lowest
 * such number to do so. If your secret key is pqrstuv, the lowest number it
 * combines with to make an MD5 hash starting with five zeroes is 1048970; that
 * is, the MD5 hash of pqrstuv1048970 looks like 000006136ef....
 * 
 * @author Sims
 *
 */
public class AdventCoins {
	private static final String KEY_HASH_VALUE = "hashValue";
	private static final String KEY_HEX_VALUE = "hexValue";

	public static void main(String[] args) {

		String input = "yzbqklnj";
		int numLeadingZeros = 5;
		System.out.println("Number of leading zeros required: "
				+ numLeadingZeros);
		System.out.println("Input: " + input);

		Map<String, String> data = findSmallestHashValueForInput(input,
				numLeadingZeros);

		System.out.println("Smallest hash: " + data.get(KEY_HASH_VALUE));
		System.out.println("Digested(hex): " + data.get(KEY_HEX_VALUE));
		System.out.println("\n");

		numLeadingZeros = 6;
		System.out.println("Number of leading zeros required: "
				+ numLeadingZeros);
		System.out.println("Input: " + input);

		data = findSmallestHashValueForInput(input, numLeadingZeros);

		System.out.println("Smallest hash: " + data.get(KEY_HASH_VALUE));
		System.out.println("Digested(hex): " + data.get(KEY_HEX_VALUE));

	}

	public static Map<String, String> findSmallestHashValueForInput(
			String input, int numLeadingZeros) {
		Map<String, String> dataMap = new HashMap<>();
		if (input == null || input.length() == 0) {
			return dataMap;
		}

		int loopMax = 100;
		String digestPrefix = "";
		for (int i = 0; i <= numLeadingZeros; i++) {
			loopMax *= 10;
			digestPrefix += "0";
		}

		System.out.println("\nAttemping to hash...\n");

		for (int i = 0; i < loopMax; i++) {
			String digest = DigestUtils.md5Hex(input + i);
			if (digest.startsWith(digestPrefix.substring(0, numLeadingZeros))) {
				dataMap.put(KEY_HASH_VALUE, String.valueOf(i));
				dataMap.put(KEY_HEX_VALUE, digest);
				break;
			}
		}

		return dataMap;
	}
}
