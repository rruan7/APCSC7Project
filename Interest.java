/* Renee Ruan
 * APCS P3
 * Chapter 3 Project
 * 23 October 2020
 */

import java.util.Scanner;

public class Interest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s1 = "Enter your initial investment: ";
		String s2 = "Enter your annual deposit: ";
		String s3 = "Enter number of years: ";
		String s4 = "Enter interest rate: ";
		results(initialInvestment(scanner, s1), annualDeposit(scanner, s2), years(scanner, s3), interestRate(scanner, s4)); //call results method with returns from user input methods

	}
	
	//user input for initial investment
	public static double initialInvestment(Scanner scanner, String string) {
		System.out.println(string);
		double input = scanner.nextDouble();
		return input;
	}
	
	//user input for annual deposit
	public static double annualDeposit(Scanner scanner, String string) {
		System.out.println(string);
		double input = scanner.nextDouble();
		return input;
	}
	
	//user input for number of years
	public static int years(Scanner scanner, String string) {
		System.out.println(string);
		int input = scanner.nextInt();
		return input;
	}
	
	//user input for interest rate
	public static double interestRate(Scanner scanner, String string) {
		System.out.println(string);
		double input = scanner.nextDouble();
		return input;
	}
	
	//prints table of results
	public static void results(double initialInvestment, double annualDeposit, int years, double interestRate) {
		double balance = initialInvestment; //keeps track of balance
		System.out.println("Year\tInterest\tDeposit\t\tBalance"); //print headers
		System.out.println("start\t\t\t\t\t" + initialInvestment); //print initial investment
		for (int i = 1; i <= years; i++) {
			System.out.print(i + "\t"); //print number of years
			double interest = (int)(balance * interestRate) / 100.00; //calculates annual interest and truncates
			System.out.print(interest + "\t\t"); //print annual interest
			System.out.print(annualDeposit + "\t\t"); //print annual deposit
			balance = balance + annualDeposit + interest; //updating value of balance
			balance = (int)(balance * 100) / 100.00; //truncation
			System.out.print(balance); //print annual balance
			System.out.println();
		}
	}

}
