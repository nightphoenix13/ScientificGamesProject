package com.scientificgames.main;

/*
 * Simple pojo to hold birth and death year of a person.
 * Author: Zack Rosales
 */
public class BirthAndDeathYears {

	// class attributes for birth and death year
	private Integer birthYear;
	private Integer deathYear;
	
	// class constructor
	BirthAndDeathYears(Integer birth, Integer death){
		birthYear = birth;
		deathYear = death;
	}
	
	// getters and setters
	public Integer getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}
	public Integer getDeathYear() {
		return deathYear;
	}
	public void setDeathYear(Integer deathYear) {
		this.deathYear = deathYear;
	}
}
