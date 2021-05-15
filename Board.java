/* Renee Ruan
 * P3 APCS Peterson
 * 20 April 2021
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Board {
	
	private String[][] board; //String array to represent WordHunt board
	private WordList words; //WordList object containing valid words
	
	public Board(WordList wordlist, int size) {
		this.words = wordlist;
		board = new String[size][size];
		Random r = new Random();
		for (int i = 0; i < size * size; i++) {
			
		}
		for (int i = 0; i < size; i++) { //For-loop to fill WordHunt board with a random letter from random words
			for (int j = 0; j < size; j++) {
				String word = wordlist.get(r.nextInt(wordlist.size()));
				char c = word.charAt(r.nextInt(word.length()));
				board[i][j] = "" + c;
			}
		}
	}
	
	public void sortWords(ArrayList<String> wordsFound) { //Method to sort words (using comparator from WordComparator) and remove duplicates (resulting from two WordHunt paths making the same word)
		ArrayList<WordComparator> finalWords = new ArrayList<WordComparator>();
		for (int i = 0; i < wordsFound.size(); i++) {
			finalWords.add(new WordComparator(wordsFound.get(i)));
		}
		Collections.sort(finalWords); //Sorts finalWords based on compareTo() method in WordComparator
		for (int i = 0; i < finalWords.size() - 1; i++) { //For loops that remove duplicates
			for (int j = 0; j < finalWords.size() - 1; j++) {
				if (finalWords.get(i).compareTo(finalWords.get(j)) == 0) {
					finalWords.remove(i);
				}
			} 
		}
		printWords(finalWords); //Pass finalWords into printWords method
	}
	
	public void printWords(ArrayList<WordComparator> finalWords) { //Method to format printing of final word list
		System.out.println("Found " + finalWords.size() + " word(s)");
		System.out.println();
		boolean found = false; //Boolean to keep track of whether there are words of the specified length
		for (int i = finalWords.get(0).getText().length(); i <= finalWords.get(finalWords.size() - 1).getText().length(); i++) { //Counter i keeps track of word length
			for (int j = 0; j < finalWords.size(); j++) {
				if (i == finalWords.get(j).getText().length()) { //Set found to true if words of specified length are found
					found = true;
				}
			}
			if (found) { //If words of specified length are found, print the words
				System.out.println(i + " letter words");
				for (int j = 0; j < finalWords.size(); j++) {
					if (i == finalWords.get(j).getText().length()) {
						System.out.println(finalWords.get(j).getText().toUpperCase());
					}
				}
			}
			System.out.println();
			found = false; //Reset found boolean
		}
	}

	public ArrayList<String> find() { //Find method that user calls to display all possible words
		ArrayList<String> wordsFound = new ArrayList<String>();
		boolean[][] crumbs = new boolean[board[0].length][board.length]; //Array of booleans that keeps track of if a tile was searched already
		for (int i = 0; i < board[0].length; i++) { //For each starting letter on the WordHunt board, update the wordsFound ArrayList by running the second find() method (overloaded)
            for (int j = 0; j < board.length; j++) {
            	wordsFound = find("", crumbs, i, j, wordsFound);
            }
		}
		sortWords(wordsFound); //Call the sortWords method
		return wordsFound; //Returns wordsFound ArrayList
	}
	
	public ArrayList<String> find(String word, boolean[][] crumbs, int i, int j, ArrayList<String> wordsFound) { //Main find() method
		if (word.length() == words.getLongestWordLength()) { //Stop searching if word length is already at specified max
			if (words.contains(word)) { //If a word, add to wordsFound ArrayList
				wordsFound.add(word);
			}
		} else { //Continue searching if not max number of letters yet
			crumbs[i][j] = true;
	        word = word + board[i][j];
	  
	        if (words.contains(word)) { //If a word, add to wordsFound ArrayList
	            wordsFound.add(word);
	        }
	  
	        for (int row = i - 1; row <= i + 1; row++) { //For loop to search the 8 neighboring tiles for any given tile
	            for (int col = j - 1; col <= j + 1; col++) {
	                if (row >= 0 && col >= 0 && row < board[0].length && col < board.length && !crumbs[row][col]) {
	                    find(word, crumbs, row, col, wordsFound);
	                }
	            }
	        }
	  
	        word = word.substring(0, word.length() - 1); //Substring word to get rid of added letter
	        crumbs[i][j] = false; //Reset crumbs back to false
	    }
		return wordsFound; //returns wordsFound ArrayList
	}
	
	public String toString() { //toString() method that returns string representation of board
		String stringBoard = "";
		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board.length; j++) {
				stringBoard += board[i][j];
				stringBoard += " ";
			}
			stringBoard += "\n";
		}
		return stringBoard;
	}
}
