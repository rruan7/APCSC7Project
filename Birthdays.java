/* Renee Ruan
 * P3 APCS Peterson
 * Chapter 4 Birthday Project
 */

import java.util.*;

public class Birthdays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		initialization(scanner);
	}
	
	public static void initialization(Scanner scanner) { //asks for current month/day
		System.out.print("Please enter today's date (month day): ");
		int curMonth = scanner.nextInt(); //get user input for current month
		int curDay = scanner.nextInt(); //get user input for current day
		System.out.println("Today is " + curMonth + "/" + curDay + "/2020, day #" + absDayNum(curMonth, curDay) + " of the year.");
		System.out.println();
		birthday(curMonth, curDay, scanner); //call next method for birthdays
	}
	
	public static void birthday(int curMonth, int curDay, Scanner scanner) { //asks for two birthdays
		//person #1 birthday
		System.out.print("Please enter person #1's birthday (month day): ");
		int month1 = scanner.nextInt(); //get birth month
		int day1 = scanner.nextInt(); //get birth day
		//prints day# of birthday1
		System.out.print(month1 + "/" + day1 + "/2020 falls on day #" + absDayNum(month1, day1) + " of 365. ");
		
		//print days remaining until next birthday for person #1
		if (daysRemaining(curMonth, curDay, month1, day1) != 0) {
			System.out.println("Your next birthday is in " + daysRemaining(curMonth, curDay, month1, day1) + " days.");
			System.out.println();
		} else {
			System.out.println("Happy birthday!");
			System.out.println();
		}
	
		
		//person #2 birthday
		System.out.print("Please enter person #2's birthday (month day): ");
		int month2 = scanner.nextInt(); //get birth month
		int day2 = scanner.nextInt(); //get birth day
		//prints day# of birthday2
		System.out.print(month2 + "/" + day2 + "/2020 falls on day #" + absDayNum(month2, day2) + " of 365. ");
		
		//print days remaining until next birthday for person #2
		if (daysRemaining(curMonth, curDay, month2, day2) != 0) {
			System.out.println("Your next birthday is in " + daysRemaining(curMonth, curDay, month2, day2) + " days.");
			System.out.println();
		} else {
			System.out.println("Happy birthday!");
			System.out.println();
		}
		
		//compare person #1 days remaining and person #2 days remaining
		if (daysRemaining(curMonth, curDay, month1, day1) < daysRemaining(curMonth, curDay, month2, day2)) {
			System.out.println("Person #1's birthday is sooner."); //if person 1's birthday is sooner
		} else if (daysRemaining(curMonth, curDay, month2, day2) < daysRemaining(curMonth, curDay, month1, day1)) {
			System.out.println("Person #2's birthday is sooner."); //if person 2's birthday is sooner
		} else {
			System.out.println("Person #1 and Person #2 have the same birthday."); //if they have the same birthday
		}
		
		System.out.println();
		System.out.println("Did you know? January 1st is called New Years Day!"); //fun fact
		
	}
	
	public static int absDayNum(int month, int day) { //returns the absolute day # of today's date
		int totalDays = 0; //keep track of number of days
		for (int i = 1; i < month; i++) {
			totalDays += daysInMonth(i); //update value of totalDays based on # of days in each month
		}
		totalDays += day; //add remaining days onto totalDays
		return totalDays;
	}
	
	public static int daysInMonth(int month) { //method returning # of days in each month
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 2) {
			return 28;
		} else if (month == 4 || month == 6 || month == 9 || month == 11){
			return 30;
		} else {
			throw new IndexOutOfBoundsException("Please enter a valid month!");
		}
	}
	
	public static int daysRemaining(int curMonth, int curDay, int month, int day) { //days remaining until next birthday
		int totalDays = 0; //keep track of total days
		
		if (month < curMonth) { //if birth month has already passed this year
			if (day < curDay) { //if birth day is before today's day
				for (int i = month; i < curMonth; i++) {
					totalDays += daysInMonth(i);
				}
				totalDays += (curDay - day);
				totalDays = 365 - totalDays;
				return totalDays;
			} else if (day > curDay) { //if birth day is after today's day
				for (int i = month; i < curMonth; i++) {
					totalDays += daysInMonth(i);
				}
				totalDays -= (day - curDay);
				totalDays = 365 - totalDays;
				return totalDays;
			} else { //if birth day is today's day
				for (int i = month; i < curMonth; i++) {
					totalDays += daysInMonth(i);
				}
				totalDays = 365 - totalDays;
				return totalDays;
			}
			
		} else if (month > curMonth) { //if birth month hasn't passed yet this year
			if (day < curDay) { //if birth day is before today's day
				for (int i = curMonth; i < month; i++) {
					totalDays += daysInMonth(i);
				}
				totalDays -= (curDay - day);
				return totalDays;
			} else if (day > curDay) { //if birth day is after today's day
				for (int i = curMonth; i < month; i++) {
					totalDays += daysInMonth(i);
				}
				totalDays += (day - curDay);
				return totalDays;
			} else { //if birth day is today's day
				for (int i = curMonth; i < month; i++) {
					totalDays += daysInMonth(i);
				}
				return totalDays;
			}
			
		} else { //if this month is the birth month
			if (day < curDay) { //if birth day is before today's day
				totalDays += (curDay - day);
				totalDays = 365 - totalDays;
				return totalDays;
			} else if (day > curDay) { //if birth day is after today's day
				totalDays += (day - curDay);
				return totalDays;
			} else { //if birth day is today's day
				return 0;
			}
		}
	}

}
