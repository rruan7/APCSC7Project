/* Renee Ruan
 * P3 APCS Peterson
 * 20 April 2021
 */

public class WordComparator implements Comparable<WordComparator> {
	private String text;
	public WordComparator(String text) { //Constructor that takes String as a parameter
		this.text = text;
	}
	
	public String getText() { //Method to return text field
		return this.text;
	}
	
	public int compareTo(WordComparator A) { //compareTo() method that compares the text field of two WordComparator objects
		if (this.getText().length() < A.getText().length()) {
			return -1;
		} else if (this.getText().length() > A.getText().length()) {
			return 1;
		} else {
			for (int i = 0; i < A.getText().length(); i++) {
				if (this.getText().charAt(i) < A.getText().charAt(i)) {
					return -1;
				} else if (this.getText().charAt(i) > A.getText().charAt(i)) {
					return 1;
				} 
			}
			return 0;
		}
	}
	
	public String toString() { //toString() method
		return this.getText();
	}
}
