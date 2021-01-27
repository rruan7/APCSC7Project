/* Renee Ruan
 * APCS P3 Peterson
 * Chapter 7 Project
 * 21 January 2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

public class Sum {

	public static final int SIZE = 25; //class int for size
	
	public static void main(String[] args) throws FileNotFoundException { //main method
		readFile();
	}
	
	public static void readFile() throws FileNotFoundException {
		File file = new File("sum.txt"); //create file object
		Scanner scanner = new Scanner(file); //create scanner object and open file
		while (scanner.hasNextLine()) { //scanner to read each line
			String line = scanner.nextLine(); 
			Scanner lineScan2 = new Scanner(line); //create linescanner to scan individual line
			int nums2 = 0; //int to keep track of number of tokens in that line
			while (lineScan2.hasNext()) {
				nums2++;
				String num = lineScan2.next();
			}
			int[][] numLine = new int[nums2][SIZE]; //create 2d array with specified dimensions to hold all numbers on a single line
			int nums = 0; //second int to keep track of number of tokens in that line again
			Scanner lineScan = new Scanner(line); //create second linescanner to scan the same line again
			while (lineScan.hasNext()) {
				nums++;
				String num = lineScan.next();
				int[] temparr = arr(num); //set temparr array equal to the array outputted from the arr() method
				for (int i = 0; i < SIZE; i++) { //replacing values in numLine array with values of temparr
					numLine[nums - 1][i] = temparr[i]; //repeated for each token on that line
				}
			}
			arrToInt(numLine); //prints out the numbers being added in a nice format
			int[] resultArr = add(numLine); //resultArr is the array that stores the sum of each line
			// System.out.println(Arrays.toString(resultArr));
			arrToInt2(resultArr); //prints out the sum in a nice format
		}
	}
	
	public static void arrToInt(int[][] arr) { //prints out the numbers being added in a nice format
		int count = 0; //keeps track of how many numbers are being added
		for (int i = 0; i < arr.length; i++) {
			String value = ""; //empty string for number value
			for (int j = 0; j < arr[0].length; j++) {
				value += arr[i][j]; //adds digits of number to empty string
			}
				
			count++;
			if (count > 1) { //if more than one number is being added, print a plus sign before the subsequent numbers
				System.out.print(" + ");
			}
				
			while(value.indexOf("0") == 0) { //eliminates leading zeroes
				   value = value.substring(1);
			}
				       
			if(value.isEmpty()) { //if string is empty after eliminating leading zeroes, set value equal to zero
			    value = "0";
			}
					 
			// value = value.replaceAll("^0*", "");
			System.out.print(value); //prints value

		}
	}
	
	public static void arrToInt2(int[] arr) { //prints sum in a nice format
		String value = ""; //empty string to store sum as string
		for (int i = 0; i < arr.length; i++) {
			value += arr[i]; //adds digits to value string
		}
		
		while(value.indexOf("0") == 0) { //eliminates leading zeroes
		    value = value.substring(1);
		}
		       
		if(value.isEmpty()) { //if string is empty after eliminating leading zeroes, set value to zero
		    value = "0";
		}
	
		System.out.print(" = " + value); //print sum value
		System.out.println();
	}
	
	public static int[] arr(String num) { //method that turns number in string form into array
		int[] array = new int[SIZE]; //create new array of size SIZE
		for (int i = 0; i < num.length(); i++) { //add digits to array from string right to left
			array[SIZE - 1 - i] = Character.getNumericValue(num.charAt(num.length() - 1 - i));
		}
		for (int i = 0; i < SIZE - num.length(); i++) { //sets remaining values in array to zero
			array[i] = 0;
		}
		// System.out.println(Arrays.toString(array));
		return array;
	}
	
	public static int[] add(int[][] numLine) { //method that takes in 2d array as parameter and returns the sum of the indiviual numbers within that 2d array
		int[] sumArr = new int[SIZE]; //create new array of size SIZE
		int carryOver = 0; //integer for carryover in addition
		for (int i = SIZE - 1; i >= 0; i--) { //start adding from rightmost column
			int sum = 0;
			for (int j = 0; j < numLine.length; j++) { //iterates through each row
				sum += numLine[j][i]; //sums values
			}
			sum += carryOver; //add carryover 
			sumArr[i] = sum % 10; //add correct digit to array containing sums
			carryOver = sum / 10; //set carryOver to new carryover value
		}
		// System.out.println(Arrays.toString(sumArr));
		return sumArr;
	}
	

}
