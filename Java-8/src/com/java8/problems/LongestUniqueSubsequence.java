package com.java8.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubsequence {

	public static void main(String[] args) {
		
		int[] inputT1 = {1, 2, 3, 4, 5, 1, 2, 3};
		int[] inputT2 = {1, 2, 4, 4, 5, 6, 7, 8, 3, 4, 5, 3, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4};
		System.out.println(getMaxLengthOfUniqueSubsequence(inputT1));
		System.out.println(getMaxLengthOfUniqueSubsequence(inputT2));
	}
	
	//Sliding window approach
	private static int getMaxLengthOfUniqueSubsequence(int[] input) {
		int i = 0;
		int j = 0;
		int max = 0;
		Set<Integer> subAry = new HashSet<Integer>();
		while(i < input.length) {
			int x = input[i];
			while(subAry.contains(x)) {
				subAry.remove(x);
				++j;
			}
			subAry.add(x);
			max = Math.max(max, i-j+1);
			i++;
		}
		return max;
	}

}
