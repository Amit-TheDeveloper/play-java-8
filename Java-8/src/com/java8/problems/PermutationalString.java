package com.java8.problems;

public class PermutationalString {

	public static void main(String[] args) {
		
		
		String input = "ABCD";
		
		printPermutation(input, "", 0);

	}

	static void printPermutation(String input, String perm, int idx) {
		if(input.length() == 0) {
			System.out.println(perm);
			return;
		}
		
		for(int i=0; i<input.length(); i++) {
			char currentChar = input.charAt(i);
			String ninput = input.substring(0,i) + input.substring(i+1);
			printPermutation(ninput, perm+currentChar, idx+1);
		}
		
	}
	
}
