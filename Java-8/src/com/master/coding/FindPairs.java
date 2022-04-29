package com.master.coding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//For given input array, find pairs with matching input sum.
public class FindPairs {

	public static void main(String[] args) {
		Arrays.asList(find2IndexsForSum(10)).stream().forEach(System.out::println);
		Arrays.asList(find2IndexsForSum(11)).stream().forEach(System.out::println);
		Arrays.asList(find2IndexsForSum(13)).stream().forEach(System.out::println);
		
		System.out.println("=====================================");
		Arrays.asList(find2IndexsForSum_Opt(10)).stream().forEach(System.out::println);
		Arrays.asList(find2IndexsForSum_Opt(11)).stream().forEach(System.out::println);
		Arrays.asList(find2IndexsForSum_Opt(13)).stream().forEach(System.out::println);
		
		
		System.out.println("=====================================");
		Arrays.asList(find2IndexsForSum_Opt2(10)).stream().forEach(System.out::println);
		Arrays.asList(find2IndexsForSum_Opt2(11)).stream().forEach(System.out::println);
		Arrays.asList(find2IndexsForSum_Opt2(13)).stream().forEach(System.out::println);
	}

	// O(n^2) Not good
	private static List<String> find2IndexsForSum(int sum) {
		int[] input = { 3, 6, 8, 0, 1, -2, 4, 9, -3 };
		List<String> result = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == sum) {
					result.add(input[i] + "," + input[j]);
				}
			}
		}

		return result;
	}

	// Optimal O(n log n) Two shifting pointers approach
	private static List<String> find2IndexsForSum_Opt(int sum) {
		int[] input = { 3, 6, 8, 0, 1, -2, 4, 9, -3 };
		List<String> result = new ArrayList<>();
		Arrays.sort(input); //n log n
		int i = 0;
		int j = input.length-1;
		while (i < j ) {
			if (input[i] + input[j] == sum) {
				result.add(input[i] + "," + input[j]);
				i++;j--;
			} else if(input[i] + input[j] > sum) {
				j--;
			} else {
				i++;
			}
		}
		return result;
	}
	
	//T: O(n) Good using additional space. space trade off for performance.
	private static List<String> find2IndexsForSum_Opt2(int sum) {
		int[] input = { 3, 6, 8, 0, 1, -2, 4, 9, -3 };
		List<String> result = new ArrayList<>();
		Map<Integer, Integer> noMap = new HashMap();
		for(int i=0; i < input.length; i++) {
			int n2find = sum - input[i];
			if(noMap.get(input[i]) != null && noMap.get(input[i]) >= 0) {
				result.add(input[i] + "," + input[noMap.get(input[i])]);
			} else {
				noMap.put(n2find, i);
			}
		}
		return result;
	}

}
