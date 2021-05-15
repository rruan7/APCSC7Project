/* Renee Ruan
 * P3 APCS Peterson
 * Federal Tax Program
 * 12 November 2020
 */

import java.util.*;

public class FedTax {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean run = true; 
		while (run) {
			userInput(scanner); //continuously runs
		}
	}
	
	public static void userInput(Scanner scanner) { //ask user for salary
		System.out.println("Please enter your salary. "); 
		double salary = scanner.nextDouble();
		double tax = tax(salary);
		results(salary, tax);
	}
	
	public static void results(double salary, double tax) { //prints results of salary and tax
		System.out.println("salary: $" + salary);
		System.out.println("tax: $" + tax);
		System.out.println();
	}
	
	public static double tax(double salary) { //calculates tax and returns
		double tax = 0;
		if (salary > 0 && salary <= 7150) { //bracket 1
			tax = 0.10 * salary;
			return tax;
		} else if (salary > 7150 && salary <= 29050) { //bracket 2
			tax = 0.15 * (salary - 7150);
			tax += 715;
			return tax;
		} else if (salary > 29050 && salary <= 70350) { //bracket 3
			tax = 0.25 * (salary - 29050);
			tax += 4000;
			return tax;
		} else if (salary > 70350) { //bracket 4
			tax = 0.28 * (salary - 70350);
			tax += 14325;
			return tax;
		} else {
			throw new IndexOutOfBoundsException("Please enter a valid salary."); //for negative salaries
		}
	}

}
