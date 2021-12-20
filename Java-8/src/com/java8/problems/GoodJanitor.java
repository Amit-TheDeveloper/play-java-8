package com.java8.problems;

import java.util.Arrays;

public class GoodJanitor {

	public static void main(String[] args) {
		double[] arr = {1.01, 1.991, 1.32, 1.4};    
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int count = 0;
        while(left <= right){
            if(left == right){
                count++;
                break;
            }
            if(arr[left] + arr[right] <= 3.0){
                left++;
                right--;
                count++;
            }
            else{
                right--;
                count++;
            }
        }
        System.out.println(count);

	}

}
