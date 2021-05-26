/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

import java.util.Arrays;

public class MergeSort implements ISorter {
	
	private int comparisons;
	private int moves;
	
	public MergeSort() { }
	
	public ISortStats sort(int[] array) { //Main Merge Sort method
		
		long start = System.nanoTime();
		comparisons = 0;
		moves = 0;
		
		mergeSort(array);

		long end = System.nanoTime();
		ISortStats s = new SortStats("Merge Sort", array.length, comparisons, moves, end - start);
		return s;
	}
	
	public int[] mergeSort(int[] array) {
        if (array.length > 1) { //If array length is greater than 1...
            int[] left = Arrays.copyOfRange(array, 0, array.length / 2); //Create new array for first half of original array
            int[] right = Arrays.copyOfRange(array, array.length / 2, array.length); //Create new array for second half of original array

            mergeSort(left); //Recursive call
            mergeSort(right);

            merge(left, right, array); //Call merge method to merge left and right halves back into a single array
        }
        return array;
    }

    public void merge(int[] left, int[] right, int[] array) {
        int il = 0; //Index for left array
        int ir = 0; //Index for right array
        int i = 0; //Index for resulting full array

        while (il < left.length && ir < right.length) { //While both left index and right index in bounds for respective arrays...
            if (left[il] < right[ir]) { //If value in left array at left index less than value in right array at right index...
            	array[i] = left[il];
                il++;
            } else { //If value in right array at right index less than value in left array at left index...
            	array[i] = right[ir];
                ir++;
            }
            moves++;
            comparisons++;
            i++; //Increment i
        }
        
        //When one array runs out of elements to copy over...
        System.arraycopy(left, il, array, i, left.length - il); //Copy over remaining elements from left array (if any) into result array
        System.arraycopy(right, ir, array, i, right.length - ir); //Copy over remaining elements from right array (if any) into result array
    }

}
