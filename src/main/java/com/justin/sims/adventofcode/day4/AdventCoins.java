package com.justin.sims.adventofcode.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

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

		System.out.println("\tSmallest hash: " + data.get(KEY_HASH_VALUE));
		System.out.println("\tDigested(hex): " + data.get(KEY_HEX_VALUE));
		System.out.println("\n");

		numLeadingZeros = 6;
		System.out.println("Number of leading zeros required: "
				+ numLeadingZeros);
		System.out.println("Input: " + input);

		data = findSmallestHashValueForInput(input, numLeadingZeros);

		System.out.println("\tSmallest hash: " + data.get(KEY_HASH_VALUE));
		System.out.println("\tDigested(hex): " + data.get(KEY_HEX_VALUE));

	}

	/**
	 * Finds the smallest number that when hashed with
	 * the input, returns a hash value (String) that
	 * begins with the number of leading zeros specified.
	 * 
	 * @param input
	 * @param numLeadingZeros
	 * @return
	 */
	@SuppressWarnings("serial")
	public static Map<String, String> findSmallestHashValueForInput(
			String input, int numLeadingZeros) {

		AtomicInteger i = new AtomicInteger(0);
		Pattern p = Pattern.compile("^(0{" + numLeadingZeros + "})");
		System.out.println("\tHashing...");
		
		while (true) {
			String digest = DigestUtils.md5Hex(input + i.get());
			if (p.matcher(digest).find()) {
				return new HashMap<String, String>(){{
					put(KEY_HASH_VALUE, String.valueOf(i.get()));
					put(KEY_HEX_VALUE, digest);
			    }};
			}else if( i.get() == Integer.MAX_VALUE )
			{
				return null;
			}
			i.addAndGet(1);
		}
	}
}
