package com.sss.products.tests;

import java.text.SimpleDateFormat;
import java.util.*;

class JavaTest {
	// E.g. Input: Automation, Output: noitamotuA
	// Please don't use method such as s.reverse()
	public static String reverseStringWithoutUsingStringMethod(String s) {
		String reverseString="";
		int zero = 0;
		for(int i=s.length()-1;i>=zero ;i--){
			reverseString += s.charAt(i);
		}

		return reverseString;
	}
	
	// Sort the integer in ASC order without using the built-in method such as ArrayUtils.sort
	public static Integer[] sortIntegers(Integer[] array) {
		int n = array.length;
		for (int i = 0; i <= n - 1; i++) {
			int miniIndex = i;
			for (int j = i; j <= n - 1; j++) {
				if (array[j] < array[miniIndex]) {
					miniIndex = j;
				}
			}
			int tempVar = array[miniIndex];
			array[miniIndex] = array[i];
			array[i] = tempVar;
		}

		return array;
	}
	
	// Check if the given date is within the date range
	public static boolean isInDateRange(Date givenDate, Date startDate, Date endDate) {
        return givenDate.after(startDate) && givenDate.before(endDate);
    }
	
	// sort the given String in ASC order without using method like Arrays.sort
	public static char[] sortStringInAscOrder(String input) {
		char[] charArray = input.toCharArray();
		int n = charArray.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				// Compare adjacent characters and swap if needed
				if (charArray[j] > charArray[j + 1]) {
					// Swap characters
					char temp = charArray[j];
					charArray[j] = charArray[j + 1];
					charArray[j + 1] = temp;
				}
			}
		}
		return charArray;
	}
	
	// Given a Alphanumeric, please return a character with the lowest occurrence
	// E.g. AbcdAbc123123, the answer is d as it only occurs once
	// If there is more than 1 char with the same lowest occurrence, return the first char in ASC order
	/*public static char lowestOccurrence(String input) {
		return 'd';
	}*/
	public static char[] lowestOccurrence(String input) {
		char[] charArray = input.toCharArray();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		for (char c : charArray) {
			hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
		}
		String result = "";
		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			if (entry.getValue() == 1) {
				result +=entry.getKey();
			}
		}
		return result.toCharArray();
	}

	// Given the array of Integer, please apply the provided equations (+, -, x)
	// E.g. input: 1, 2, 3; equations: x*x, x*2-3, x*5+1
	// Answer: 1st equation: 1*1, 2*2, 3*3 = 1, 4, 9
	//         2nd equation: 1*2-3, 4*2-3, 9*2-3 = -1, 5, 15
	//         3rd equation: -1*5+1, 5*5+1, 15*5+1 = -4, 26, 76
	//         return { -4, 26, 76 }
	public static Integer[]  solveEquations(Integer[] input, String[] equations) {
		return new Integer[] { 10, 20, 30 };
	}
	
	
	public static void main(String[] args) {
		System.out.println("Test 1: " + reverseStringWithoutUsingStringMethod("Automation"));
		Integer[] intArray = new Integer[] { 10, 12, 54, 1, 2, -9, 8 };
		System.out.print("Test 2: ");
		for (Integer i : sortIntegers(intArray)) {
			System.out.print(i + ", ");
		}
		
		System.out.println();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			Date startDate = sdf.parse("2024-12-01 13:09:22");
			Date endDate = sdf.parse("2025-01-09 20:10:12");
			Date givenDate = sdf.parse("2025-02-02 00:11:22");
			System.out.println("Test 3: " + isInDateRange(givenDate, startDate, endDate));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		char[] sorted = sortStringInAscOrder("testingNG311");
		System.out.print("Test 4 :");
		for (char c: sorted) {
			System.out.print(c + ", ");
		}
		System.out.println();
		System.out.print("Test 5: ");
		for (char c: lowestOccurrence("Abc1dd23affbc1ee23u3278")) {
			System.out.print(c + ", ");
		}
		System.out.println();
		System.out.print("Test 6: ");
		Integer[] equationArray = solveEquations(new Integer [] { 1, 2, 3 }, new String[] { "x*x", "x*3-5", "x+6-10" });
		for (Integer i : equationArray) {
			System.out.print(i + ", ");
		}
	}
}

