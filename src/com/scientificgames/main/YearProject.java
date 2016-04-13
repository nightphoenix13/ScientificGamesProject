package com.scientificgames.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * YearProject class makes a list of people with random birth and death years, and then 
 * finds out what year(s) the largest number of people are alive.
 */
public class YearProject {

	public static void main(String[] args) {
		
		// List of people's birth and death years
		ArrayList<BirthAndDeathYears> yearList = (ArrayList<BirthAndDeathYears>) getRandomYearRanges();
		
		// Array to hold the count for each year
		Integer[] yearCount = new Integer[101];
		
		// Sets all entries in the array to 0
		for (int x = 0; x < 101; x++){
			yearCount[x] = 0;
		}
		
		// Cycles through each BirthAndDeathYears record and adds 1 to the year count for each year they were alive
		for (BirthAndDeathYears record : yearList){
			for (int x = record.getBirthYear(); x <= record.getDeathYear(); x++){
				yearCount[x - 1900] = yearCount[x - 1900] + 1;
			}
		}
		
		// used to hold the highest number of people alive
		Integer highest = 0;
		
		// finds the highest number of people alive
		for (int x = 0; x < yearCount.length; x++){
			if (yearCount[x] > highest){
				highest = yearCount[x];
			}
		}
		
		// used to hold the index(es) matching the highest number
		ArrayList<Integer> indexes = new ArrayList<>();
		
		// finds all indexes matching the highest number
		for (int x = 0; x < yearCount.length; x++){
			if (yearCount[x] == highest){
				indexes.add(x);
			}
		}
		
		// if/else for output depending on if there are one result or many.
		if (indexes.size() == 1){
			System.out.println("There is 1 year with the most number of people alive(" + highest + ").");
			System.out.println("That year is " + (indexes.get(0) + 1900));
		} else {
			System.out.println("There are " + indexes.size() + " years tied for the most number of people alive (" + highest + ").");
			System.out.print("Those years are: ");
			for (Integer num : indexes){
				System.out.print(num + 1900 + " ");
			}
		}
	}
	
	// method to randomly generate birth and death years within the range of 1900 and 2000
	private static List<BirthAndDeathYears> getRandomYearRanges(){
		
		// ArrayList to hold the birth and death years for 100 instances of BirthAndDeathYears
		ArrayList<BirthAndDeathYears> yearList = new ArrayList<>();
		
		// generates random year ranges and adds them to the ArrayList 
		for (int x = 0; x < 100; x++){
			Random ran = new Random();
			Integer birth = ran.nextInt(100 + 1) + 1900;
			Integer spacer = 2000 - birth;
			Integer death = ran.nextInt(spacer + 1) + birth;
			yearList.add(new BirthAndDeathYears(birth, death));
		}
		
		// returns ArrayList
		return yearList;
	}

}
