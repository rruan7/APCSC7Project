/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

public class SortStats implements ISortStats {
	private String algorithm;
	private int numItems;
	private int numComparisons;
	private int numMoves;
	private long numNanoseconds;
	
	public SortStats(String algorithm, int numItems, int numComparisons, int numMoves, long numNanoseconds) { //Constructor
		this.algorithm = algorithm;
		this.numItems = numItems;
		this.numComparisons = numComparisons;
		this.numMoves = numMoves;
		this.numNanoseconds = numNanoseconds;
	}
	
	public String getAlgorithm() { //Method to return algorithm type
		return this.algorithm;
	}
	
	public int getNumItems() { //Method to return number of items
		return this.numItems;
	}
	
	public int getNumComparisons() { //Method to return number of comparisons
		return this.numComparisons;
	}
	
	public int getNumMoves() { //Method to return number of moves
		return this.numMoves;
	}
	
	public long getNumNanoseconds() { //Method to return number of nanoseconds
		return this.numNanoseconds;
	}
	
	public String toString() { //toString method
		return "Algorithm: " + this.algorithm + ",\n" + "NumItems: " + this.numItems + ",\n" + "NumComparisons: " + this.numComparisons + ",\n" + "NumMoves: " + this.numMoves + ",\n" + "NumNanoseconds: " + this.numNanoseconds + "\n";
	}
}
