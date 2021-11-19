package com.java8.problems;

import java.util.Arrays;

public class MaxProduct {

	
	public static void main(String[] args) {
		
		int[] ary = {-100,-20,20,1,5,6,7,8,9};
		
		System.out.println(findMaxProduct(ary));
		System.out.println(findMaxProductImproved(ary));
	}
	
	// Complexity n^2
	private static int findMaxProduct(int[] ary) {
		int maxProduct = 0;
		for(int i=0; i < ary.length; i++) {
			for(int j = i+1; j< ary.length; j++) {
				if(ary[i]*ary[j] > maxProduct) {
					maxProduct = ary[i]*ary[j];
				}
			}
		}
		return maxProduct;
	}
	
	
	// using sorting 
	private static int findMaxProductImproved(int[] ary) {
		//nlog(n)
		Arrays.sort(ary);
		
		int maxProduct = ary[ary.length - 2] * ary[ary.length - 1];
		int minProduct = ary[0] * ary[1]; // in case both are are -ve, multiplying will make them +ve
		
		return maxProduct > minProduct ? maxProduct : minProduct;
	}
	
	
}
