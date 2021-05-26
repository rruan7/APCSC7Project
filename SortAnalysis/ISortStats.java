/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 13 Project
 * 24 May 2021
 */

public interface ISortStats {
	String getAlgorithm();
	int getNumItems();
	int getNumComparisons();
	int getNumMoves();
	long getNumNanoseconds();
}
