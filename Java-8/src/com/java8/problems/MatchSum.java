package com.java8.problems;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 
 * MatchSum checks if sum of any two elements match the input number.
 * 
 * @author amchandra
 *
 *
 */
public class MatchSum {

	
	
	public static void main(String[] args) {
		
		int[] input = {1, 2, 3, 4, 5}; 
		
		System.out.println(MatchSum.isAMatch(input, 12) ? "YES" : "NO");
		
		multiplyExceptItself(input);
	}
	
	static boolean isAMatch(int[] input, int match) {
		HashSet<Integer> inputSet = new HashSet<Integer>();
		
		for(int i = 0; i < input.length; i++) {
			if(inputSet.contains(match - input[i])) {
				return true;
			}
			inputSet.add(input[i]);
		}
		
		return false;
	}
	
	static int[] multiplyExceptItself(int[] input) {
		
		int product = 1;
		for(int i = 0; i < input.length; i++) {
			product = product * input[i];
		}
		
		int[] result = new int[input.length];
		for(int i = 0; i < input.length; i++) {
			result[i] = product/input[i];
			System.out.println(result[i]);
		}
		return result;
	}

}
