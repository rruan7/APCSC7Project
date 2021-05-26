/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

public class BubbleSort implements ISorter {
	
	public BubbleSort() { }
	
	public ISortStats sort(int[] array) { //Bubble Sort method
		long start = System.nanoTime();
		int comparisons = 0;
		int moves = 0;
		
		int counter = -1; //Sets counter to arbitrary non-zero value
		while (counter != 0) { //Loop that runs as long as counter isn't 0
			counter = 0; //Reset counter to 0 within loop
			for (int i = 1; i < array.length; i++) { //Iterate through array, swapping pairs of numbers that aren't in order
				comparisons++;
				if (array[i] < array[i - 1]) {
					counter++;
					int temp = array[i]; //Swapping
					array[i] = array[i - 1];
					array[i - 1] = temp;
					moves += 3;
				}
			}
		}
		
		long end = System.nanoTime();
		ISortStats s = new SortStats("Bubble Sort", array.length, comparisons, moves, end - start);
		return s;
	}
}
