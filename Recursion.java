import java.util.Arrays;

public class Recursion {

	public static void main(String[] args) {
		// System.out.println(multiplyEvens(1));
		// permute("MARTY");
		// System.out.println(isReverse("RENEE", "EENER"));
		//printBinary(4, "");
		//System.out.println(mystery(5));
		int[][] a = new int[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				a[i][j] = 2;
			}
		}
		flood(a, 0, 0, 3);
	}
	
	public static void printBinary(int n, String s) {
		if (n <= 0) {
			System.out.println("");
		} else if (n == 1) {
			System.out.println(s + "0");
			System.out.println(s + "1");
		} else {
			s = "0" + s;
			printBinary(n - 1, s);
			s = s.substring(1);
			s = "1" + s;
			printBinary(n - 1, s);
			s = s.substring(1);
		}
	}
	
	public static int multiplyEvens(int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Value cannot be zero or less");
		} else if (n == 1) {
			return n * 2;
		} else {
			return n * 2 * multiplyEvens(n - 1);
		}
		
	}
	
	public static void permute(String word) {
		permute(word, " ");
	}
	
	public static void permute(String word, String empty) {
		if (word.length() == 0) {
			System.out.println(empty); // base case
		} else {
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i); // getting next chosen letter
				word = word.substring(0, i) + word.substring(i + 1); // removing next chosen letter from word
				empty += c; // adding next chosen letter to empty
				
				permute(word, empty); //recursion
				
				word = word.substring(0, i) + c + word.substring(i); // "unchoosing" next letter by adding it back to word
				empty = empty.substring(0, empty.length() - 1); //"unchoosing" next letter by removing the last letter from empty
			}
		}
	}
	
	public static boolean isReverse(String a, String b) {
	    return isReverse(a, b, "");
	}

	public static boolean isReverse(String a, String b, String c) {
	    if (a.length() == 0) {
	        System.out.println(c);
	        if (c.toLowerCase().equals(b.toLowerCase())) {
	            return true;
	        } else {
	            return false;
	        }
	    } else {
	        c += a.charAt(a.length() - 1);
	        a = a.substring(0, a.length() - 1);
	        return isReverse(a, b, c);
	    }
	}
	
	public static int mystery(int n) {
		if (n == 1 || n == 2) {
			return 2 * n;
		} else {
			return mystery(n - 1) - mystery(n - 2);
		}
	}
	
	public static void flood(int[][] a, int x, int y, int height) {
		if ((x + 1 < 0 || x + 1 >= a[0].length || a[x + 1][y] == -1) && (x - 1 < 0 || x - 1 >= a[0].length || a[x - 1][y] == -1) && (y + 1 < 0 || y + 1 >= a[0].length || a[x][y + 1] == -1) && (y - 1 < 0 || y - 1 >= a[0].length || a[x][y - 1] == -1)) {
			System.out.println("Flooding complete");
			System.out.println(Arrays.deepToString(a));
		} else {
			if (a[x][y] < height) {
				a[x][y] = -1;
			}
			
			for (int row = x - 1; row <= x + 1; row++) {
				if (row >= 0 && row < a[0].length && a[row][y] != -1) {
					flood(a, row, y, height);
				}	
			}
			
			for (int col = y - 1; col <= y + 1; col++) {
				if (col >= 0 && col < a.length && a[x][col] != -1) {
					flood(a, x, col, height);
				}
			}
		}
	}

}
