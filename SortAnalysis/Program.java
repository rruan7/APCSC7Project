import java.util.Arrays;
import java.util.Random;

/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

public class Program {
	public static void main(String[] args) {
		Random r = new Random(); //Creating random object
		
		/* First set of tests (varying array size with elements filled randomly)*/
		
		System.out.println("FIRST SET OF TESTS");
		System.out.println();
		
		for (int i = 2; i <= 4096; i *= 2) { //Creating four arrays per size (ranging in powers of two from 2-4096)
			int[] arr1 = new int[i];
			int[] arr2 = new int[i];
			int[] arr3 = new int[i];
			int[] arr4 = new int[i];
			
			for (int j = 0; j < i; j++) { //Filling all four arrays (per size) with random ints
				arr1[j] = r.nextInt(10000);
				arr2[j] = r.nextInt(10000);
				arr3[j] = r.nextInt(10000);
				arr4[j] = r.nextInt(10000);
			}
			
			System.out.println("Bubble Sort (Array Size " + i + ")"); //Bubble Sort
			BubbleSort b = new BubbleSort();
			ISortStats ss1 = b.sort(arr1);
			System.out.println(Check.isInOrder(arr1));
			System.out.println(ss1);
			
			System.out.println("Selection Sort (Array Size " + i + ")"); //Selection Sort
			SelectionSort s = new SelectionSort();
			ISortStats ss2 = s.sort(arr2);
			System.out.println(Check.isInOrder(arr2));
			System.out.println(ss2);
			
			System.out.println("Insertion Sort (Array Size " + i + ")"); //Insertion Sort
			InsertionSort in = new InsertionSort();
			ISortStats ss3 = in.sort(arr3);
			System.out.println(Check.isInOrder(arr3));
			System.out.println(ss3);
			
			System.out.println("Merge Sort (Array Size " + i + ")"); //Merge Sort
			MergeSort m = new MergeSort();
			ISortStats ss4 = m.sort(arr4);
			System.out.println(Check.isInOrder(arr4));
			System.out.println(ss4);
		}
		
		/* Second set of tests (arrays size 4096 in order and reverse order)*/
		
		System.out.println("SECOND SET OF TESTS");
		System.out.println();
		
		int[] arr1 = new int[4096]; //Creating four arrays of size 4096
		int[] arr2 = new int[4096];
		int[] arr3 = new int[4096];
		int[] arr4 = new int[4096];
		
		int num1 = Integer.MAX_VALUE; //Initializing four ints with value Integer.MAX_VALUE
		int num2 = Integer.MAX_VALUE;
		int num3 = Integer.MAX_VALUE;
		int num4 = Integer.MAX_VALUE;
		
		for (int i = 0; i < 4096; i++) { //Filling four arrays with descending numbers
			num1 = num1 - r.nextInt(4096);
			arr1[i] = num1;
			num2 = num2 - r.nextInt(4096);
			arr2[i] = num2;
			num3 = num3 - r.nextInt(4096);
			arr3[i] = num3;
			num4 = num4 - r.nextInt(4096);
			arr4[i] = num4;
		}
		
		//Reverse Order
		
		System.out.println("Bubble Sort (Reverse Order)"); //Bubble Sort
		BubbleSort b1 = new BubbleSort();
		ISortStats ss1 = b1.sort(arr1);
		System.out.println(Check.isInOrder(arr1));
		System.out.println(ss1);
		
		System.out.println("Selection Sort (Reverse Order)"); //Selection Sort
		SelectionSort s1 = new SelectionSort();
		ISortStats ss2 = s1.sort(arr2);
		System.out.println(Check.isInOrder(arr2));
		System.out.println(ss2);
		
		System.out.println("Insertion Sort (Reverse Order)"); //Insertion Sort
		InsertionSort in1 = new InsertionSort();
		ISortStats ss3 = in1.sort(arr3);
		System.out.println(Check.isInOrder(arr3));
		System.out.println(ss3);
		
		System.out.println("Merge Sort (Reverse Order)"); //Merge Sort
		MergeSort m1 = new MergeSort();
		ISortStats ss4 = m1.sort(arr4);
		System.out.println(Check.isInOrder(arr4));
		System.out.println(ss4);
		
		//In order
		
		System.out.println("Bubble Sort (In Order)"); //Bubble Sort
		BubbleSort b2 = new BubbleSort();
		ISortStats ss5 = b2.sort(arr1);
		System.out.println(Check.isInOrder(arr1));
		System.out.println(ss5);
		
		System.out.println("Selection Sort (In Order)"); //Selection Sort
		SelectionSort s2 = new SelectionSort();
		ISortStats ss6 = s2.sort(arr2);
		System.out.println(Check.isInOrder(arr2));
		System.out.println(ss6);
		
		System.out.println("Insertion Sort (In Order)"); //Insertion Sort
		InsertionSort in2 = new InsertionSort();
		ISortStats ss7 = in2.sort(arr3);
		System.out.println(Check.isInOrder(arr3));
		System.out.println(ss7);
		
		System.out.println("Merge Sort (In Order)"); //Merge Sort
		MergeSort m2 = new MergeSort();
		ISortStats ss8 = m2.sort(arr4);
		System.out.println(Check.isInOrder(arr4));
		System.out.println(ss8);
	}

}
	