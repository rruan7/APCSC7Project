/* Renee (ronronrayraylayray) Ruan
 * P3 APCS Peterson
 * 20 April 2021
 */

public class Program {
	public static void main(String[] args) {
		System.out.println("Welcome to Boggle, by Renee Ruan"); //Welcome message
		WordList wordlist = new WordList("WordList.txt", 3, 8); //Create new WordList object 
		Board board = new Board(wordlist, 4); //Create new board object
		System.out.println(board); //Print board
		board.find(); //Run find method on board
	}
}
