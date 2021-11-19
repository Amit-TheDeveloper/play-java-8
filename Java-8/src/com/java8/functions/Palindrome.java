package com.java8.functions;

import java.util.Optional;
import java.util.stream.IntStream;

// Test String is same when read forward or backwards. Case ignored
public class Palindrome {
	
	
	public static void main(String[] args) {
		
		String input_a = "malayalam";
		System.out.println(testPlaindorme(input_a) ? "Matched" : "Not Matched");
		
	}
	
	private static boolean testPlaindorme(String input) {
		
		// Algo : 
		// Get char array
		// get the mid index of array
		// Iterate and check characters till mid if chars are same when iterated backwards and forwards.
		Optional<String> tempObj = Optional.of(input);
		if(tempObj.isPresent()) {
			char[] inputChars = tempObj.get().toCharArray();
			return (IntStream.rangeClosed(0, inputChars.length/2).allMatch(i -> inputChars[i] == inputChars[(inputChars.length - i)-1]));
		} else {
			System.out.println("Nothing to compare");
			return false;
		}
	}

}
