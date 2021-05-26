/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

public class SelectionSort implements ISorter {
	
	public SelectionSort() { }
	
	public ISortStats sort(int[] array) { //Selection Sort method
		long start = System.nanoTime();
		int comparisons = 0;
		int moves = 0;
		
		for (int i = 0; i < array.length; i++) { //Index i that increases up to the index of the last element of the array
			int smallest = i; //Initialize int to hold smallest value
			for (int j = i; j < array.length; j++) { //Find smallest int in the array between index i and the end of the array
				comparisons++;
				if (array[j] < array[smallest]) {
					smallest = j;
				}
			}
			int temp = array[i]; //Swap smallest with the element at index i
			array[i] = array[smallest];
			array[smallest] = temp;
			moves += 3;
		}
		
		long end = System.nanoTime();
		ISortStats s = new SortStats("Selection Sort", array.length, comparisons, moves, end - start);
		return s;
	}
}
