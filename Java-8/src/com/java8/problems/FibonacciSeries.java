package com.java8.problems;

//Fibonacci Test
public class FibonacciSeries {

    // 7 > 0 1 1 2 3 5 8

    public static void main(String[] args) {
        System.out.println(isPalindrome("MALAYALAM"));
    }

    public static boolean isPalindrome(String input) {
            int j = 0;
            for(int i=input.length()-1; i > input.length()/2; i-- ) {
                    if(input.charAt(i) != input.charAt(j)) {
                        return  false;
                    } j++;
            }
        return true;
    }
}
