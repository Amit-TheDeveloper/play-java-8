package com.java8.functions;

import java.util.Optional;
import java.util.stream.IntStream;

// Test String is same when read forward or backwards. Case ignored
public class Palindrome {
	
	
	public static void main(String[] args) {
		
		String input_a = "malayalam";
		Palindrome palindrome = new Palindrome();
		System.out.println(palindrome.testPlaindorme(input_a) ? "Matched" : "Not Matched");
		
	}
	
	private boolean testPlaindorme(String input) {
		
		// Algo : 
		// Get char array
		// get the mid index of array
		// Iterate and check characters till mid if chars are same when iterated backwards and forwards.
		Optional<String> tempObj = Optional.of(input);
		return tempObj.isPresent() ? doTest(tempObj) : false;
	}
	
	private boolean doTest(Optional<String> tempObj) {
		char[] inputChars = tempObj.get().toCharArray();
		return (IntStream.rangeClosed(0, inputChars.length/2).allMatch(i -> inputChars[i] == inputChars[(inputChars.length - i)-1]));
	}

}
