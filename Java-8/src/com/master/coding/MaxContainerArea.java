package com.master.coding;


//Given an array of ints, where each integer represent a height of vertical line on graph.
//Find 2 lines representing a container that can hold maximum water. Also find the area of the container. 
public class MaxContainerArea {

	public static void main(String[] args) {
		int[] inputHeights = {7,1,2,3,9};
		System.out.println(findMaxArea(inputHeights));
		System.out.println(findMaxArea_Opt(inputHeights));
	}
	
	
	// Brute force approach
	//O(n^2) - Not good
	public static int findMaxArea(int[] inputHeights) {
		// Area = Height*Width
		//Height: To hold Max water, take second highest v line. Taking highest vline make water spill. 
		//Width: Width = index of next Height(bi) - index of current Height(ai)
		int maxArea = 0;
		for(int i=0; i < inputHeights.length; i++) {
			for(int j = i+1; j < inputHeights.length; j++) {
				int heigth = Math.min(inputHeights[i], inputHeights[j]);
				int width = j - i;
				maxArea = Math.max(maxArea, heigth*width);
			}
		}
		return maxArea;
	}
	
	//Two pointer approach T: O(n)
	public static int findMaxArea_Opt(int[] inputHeights) {
		int maxArea = 0;
		int i = 0;
		int j = inputHeights.length - 1;
		
		//Check which attribute is impacting the calculation.
		//Smaller height is considered, as it only impacts calculation. Increasing the height is of no use as water will spill. 
		// Every iteration move the index of smaller height
		while(i < j) {
			int minHeight = 0;
			int width = 0;
			width = j - i;
			if(inputHeights[i] < inputHeights[j]) {
				minHeight = inputHeights[i];
				i++;
			} else {
				minHeight = inputHeights[j];
				j--;
			}
			maxArea = Math.max(maxArea, minHeight*width);
		}
		return maxArea;
	
	}
	

}
