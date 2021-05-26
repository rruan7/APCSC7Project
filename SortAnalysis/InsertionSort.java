/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

public class InsertionSort implements ISorter {
	
	public InsertionSort() { }
	
	public ISortStats sort(int[] array) { //Insertion Sort method
		
		long start = System.nanoTime();
		int comparisons = 0;
		int moves = 0;
		
		for (int i = 1; i < array.length; i++) { //Iterate through entire array
			int temp = array[i]; //Set int temp to current element of array
			comparisons++;
			while (i - 1 >= 0 && temp < array[i - 1]) { //If the element before temp is greater than temp...
				array[i] = array[i - 1]; //Shift elements in the array right until temp is no longer greater than the element before it
				moves++;
				i--;
				comparisons++;
			}
			array[i] = temp; //Re-add temp into the array
			moves++;
		}
		
		long end = System.nanoTime();
		ISortStats s = new SortStats("Insertion Sort", array.length, comparisons, moves, end - start);
		return s;
	}
}
