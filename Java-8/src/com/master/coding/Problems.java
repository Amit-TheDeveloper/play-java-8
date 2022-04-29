package com.master.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problems {

	public static void main(String args[]) {
		Problems.shrink();
		Problems.getIntegers();
	}

	//Shrink string with char followed by no. of occurence.
	private static void shrink() {
		String input = "abbb vvvv s rttt rr eeee f";
		// String input = "a1b3 v4 s1 r1t3 r2 e4 f1";
		StringBuilder builder = new StringBuilder();
		int count = 1;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != ' ') {
				if ( i+1 >= input.length() || input.charAt(i) != input.charAt(i + 1)) {
					builder.append(input.charAt(i));
					builder.append(count);
					count = 0;
				} else {
					++count;
				}
			} else {
				builder.append(input.charAt(i));
				count = 0;
			}
		}
		System.out.print(builder.toString());
	}
	
	// Get list of integers from input string.
	public static List<Integer> getIntegers() {
		
		String input = "cv dd 4 k 2321 2 11 k4k2 66 4d";
		List<Integer> result = new ArrayList<>();
		
		int i = 0;
		StringBuilder tmp = new StringBuilder();
		while(i < input.length()) {
			if(Character.isDigit(input.charAt(i))) {
				tmp.append(input.charAt(i));
			} else {
				if(tmp.length() > 0) {
					result.add(Integer.parseInt(tmp.toString()));
				}
				tmp.delete(0, tmp.length());
			}
			i++;
		}
		
		System.out.println(result);
		return result;
	}
	
}
