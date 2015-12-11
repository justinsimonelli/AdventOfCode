package com.justin.sims.adventofcode.day10;

public class LookAndSay {

	public static void main(String[] args) {		
		String input = "1113222113";
		for( int i=0; i<50; i++ ){
			input = lookAndSay(input);
		}
		
		System.out.println(input.length());
		
	}

	private static String lookAndSay(String input) {
		String[] arr = input.split("");
		
		int multiplier = 1;
		
		if( arr.length == 1 ){
			return String.valueOf((10 * multiplier) + Integer.parseInt(arr[0]));
		}
		
		StringBuilder value = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if( i == 0 ){
				continue;
			}
		
			boolean currentMatchesPrevious = ( arr[i].equals(arr[i-1]) );
			
			if( currentMatchesPrevious ){
				multiplier++;
			}
			
			if( i+1 < arr.length ){
				if( currentMatchesPrevious ){
					continue;
				}else{
					value.append((10 * multiplier) + Integer.parseInt(arr[i -1 ]));
					multiplier = 1;
				}
			}else{
				if( currentMatchesPrevious ){
					value.append((10 * multiplier) + Integer.parseInt(arr[i]));
				}else{
					value.append((10 * multiplier) + Integer.parseInt(arr[i -1 ]));
					value.append((10  + Integer.parseInt(arr[i])));
				}
			}
			
			
		}

		return value.toString();
	}
}
