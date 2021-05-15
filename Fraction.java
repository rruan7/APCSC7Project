/* Renee Ruan
 * P3 APCS Peterson
 * 08 February 2021
 * Chapter 8 Project
 */

//constructor for fraction with two int parameters given
public class Fraction {  
	private int numerator; //private integer field representing numerator
	private int denominator; //private integer field representing denominator
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		
		if (this.denominator == 0) { //test if denominator is 0
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		
		int j = 1;
		while (j <= Math.abs(this.numerator) / 2 && Math.abs(this.numerator) > 1) { //while loop to simplify fraction
			if (Math.abs(this.denominator) % Math.abs(this.numerator) == 0) { //checks if denominator is perfectly divisible by numerator
				this.denominator = this.denominator / this.numerator;
				this.numerator = this.numerator / Math.abs(this.numerator); //checks if numerator and denominator have other common factors
			} else if ((Math.abs(this.numerator) % j == 0) && (Math.abs(this.denominator) % j == 0)) {
				this.numerator = this.numerator / j;
				this.denominator = this.denominator / j;
				j = 1; //set j back to 1 to restart check for factors
			} 
			j++; //increment j
		}
		
		if (this.denominator < 0) { //transfer negative sign to numerator for style
			this.denominator = this.denominator * -1;
			this.numerator = this.numerator * -1;
		}
	}
	
	//constructor for whole number fraction
	public Fraction(int wholeNumber) {
		this.numerator = wholeNumber;
		this.denominator = 1;
	}
	
	//constructor for improper fraction given as a string
	public Fraction(String improperFraction) {
		char sign = 'a';
		
		//find sign if applicable and substring
		if (improperFraction.charAt(0) == '+' || improperFraction.charAt(0) == '-') {
			sign = improperFraction.charAt(0);
			improperFraction = improperFraction.substring(1);
		}
		
		int dashIndex = improperFraction.indexOf('/'); //find the index of the dash
		this.numerator = Integer.parseInt(improperFraction.substring(0, dashIndex)); //substring for numerator and convert to int
		this.denominator = Integer.parseInt(improperFraction.substring(dashIndex + 1)); //substring for denominator and convert to int
		
		if (this.denominator == 0) { //check if denominator is 0
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		
		//while loop to simplify fraction
		int j = 1;
		while (j <= Math.abs(this.numerator) / 2 && Math.abs(this.numerator) > 1) {
			if (Math.abs(this.denominator) % Math.abs(this.numerator) == 0) { //checks if denominator is perfectly divisible by numerator
				this.denominator = this.denominator / this.numerator;
				this.numerator = this.numerator / Math.abs(this.numerator);
			} else if ((Math.abs(this.numerator) % j == 0) && (Math.abs(this.denominator) % j == 0)) { //checks if numerator and denominator have other common factors
				this.numerator = this.numerator / j;
				this.denominator = this.denominator / j;
				j = 1;
			} 
			j++;
		}
		
		if (sign == '-') {
			this.numerator = this.numerator * -1; //multiply numerator by -1 if sign is negative
		}
		
		if (this.denominator < 0) { //transfer negative sign to numerator for style
			this.denominator = this.denominator * -1;
			this.numerator = this.numerator * -1;
		}
	}
	
	public int getNumerator() { //method that returns numerator
		return numerator;
	}
	
	public int getDenominator() { //method that returns denominator
		return denominator;
	}
	
	public Fraction add(Fraction fraction) { //method that adds fraction with another fraction
		//find numerators when both fractions have a common denominator
		int num1 = this.numerator * fraction.denominator;
		int num2 = fraction.numerator * this.denominator;
		int newDenom = this.denominator * fraction.denominator;
		
		//find the new numerator
		int newNum = num1 + num2;
		
		if (newDenom == 0) { //check if denominator is 0
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		
		if (newDenom < 0) { //transfer negative sign to numerator for style
			newDenom = newDenom * -1;
			newNum = newNum * -1;
		}
		
		//create and return new fraction object
		Fraction newFraction = new Fraction(newNum, newDenom);
		return newFraction;
	}
	
	public Fraction subtract(Fraction fraction) { //method that subtracts another fraction from this fraction
		//find numerators when both fractions have a common denominator
		int num1 = this.numerator * fraction.denominator;
		int num2 = fraction.numerator * this.denominator;
		int newDenom = this.denominator * fraction.denominator;

		//find the new numerator
		int newNum = num1 - num2;
		
		if (newDenom == 0) { //check if denominator is 0
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		
		if (newDenom < 0) { //transfer negative sign to numerator for style
			newDenom = newDenom * -1;
			newNum = newNum * -1;
		}
		
		//create and return new fraction object
		Fraction newFraction = new Fraction(newNum, newDenom);
		return newFraction;
	}
	
	public Fraction multiply(Fraction fraction) { //method that multiplies this fraction with another fraction
		int newNum = this.numerator * fraction.numerator;
		int newDenom = this.denominator * fraction.denominator;
		
		if (newDenom == 0) { //check if denominator is 0
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		
		if (newDenom < 0) { //transfer negative sign to numerator for style
			newDenom = newDenom * -1;
			newNum = newNum * -1;
		}
		
		//create and return new fraction object
		Fraction newFraction = new Fraction(newNum, newDenom);
		return newFraction;
	}
	
	public Fraction divide(Fraction fraction) { //method that divides this fraction with another fraction
		int newNum = this.numerator * fraction.denominator;
		int newDenom = this.denominator * fraction.numerator;
		
		if (newDenom == 0) { //check if denominator is 0
			throw new IllegalArgumentException("Denominator cannot be 0");
		}
		
		if (newDenom < 0) { //transfer negative sign to numerator for style
			newDenom = newDenom * -1;
			newNum = newNum * -1;
		}

		//create and return new fraction object
		Fraction newFraction = new Fraction(newNum, newDenom);
		return newFraction;
	}
	
	public String toString() { //method that returns string form of a proper fraction or whole number
		if (numerator == 0) { //if the fraction equals 0
			return "0";
		} else if (denominator == 1) { //for positive whole numbers
			return "" + numerator;
		} else if (denominator == -1) { //for negative whole numbers
			return "" + numerator * -1;
		} else { //for proper fractions
			return numerator + "/" + denominator;
		}
	}
	
	public String toMixedNumberString() { //method that returns string form of an improper fraction, proper fraction, or whole number
		if (numerator == 0) { //if the fraction equals 0
			return "0";
		} else if (denominator == 1) { //for positive whole numbers
			return "" + numerator;
		} else if (denominator == -1) { //for negative whole numbers
			return "" + numerator * -1;
		} else if (Math.abs(numerator) > Math.abs(denominator)) { //for improper fractions
			int wholeNum = numerator / denominator;
			int newNum = numerator % denominator;
			return wholeNum + "_" + Math.abs(newNum) + "/" + Math.abs(denominator);
		} else { //for proper fractions
			return numerator + "/" + denominator;
		}
	}
	
	public int compareTo(Fraction fraction) { //method that compares this fraction with another
		//find numerators when both fractions have a common denominator
		int num1 = this.numerator * fraction.denominator;
		int num2 = fraction.numerator * this.denominator;
		
		if (num1 > num2) { //if this fraction is greater
			return 1;
		} else if (num2 > num1) { //if this fraction is smaller
			return -1;
		} else { //if the two fractions are equivalent
			return 0;
		}
	}
}
