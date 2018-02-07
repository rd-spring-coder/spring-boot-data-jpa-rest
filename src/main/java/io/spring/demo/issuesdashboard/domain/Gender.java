package io.spring.demo.issuesdashboard.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

	MALE("M"),
	FEMALE("F");
	
	private String shortName;
	
	private Gender(String shortName){
		this.shortName = shortName;
	}
	
	@JsonValue
	public String getShortName(){
		return this.shortName;
	}
	
	public static Gender fromShortName(String shortName){
		switch(shortName){
		case "M":
			return Gender.MALE;
		case "F":
			return Gender.FEMALE;
		default:
			throw new IllegalArgumentException("shortName "+ shortName + " is not valid");
		}
	}
}
