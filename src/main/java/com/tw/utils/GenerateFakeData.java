package com.tw.utils;

import com.github.javafaker.Faker;

public final class GenerateFakeData {
	
	private static Faker faker = new Faker();
	
	
	public static String getEmailAddress() {
		return faker.internet().emailAddress();
	}
	
	public static String getPassword() {
		return faker.internet().password();
	}
	
	public static String getFirstName() {
		
		return faker.name().firstName();
	}
	
	public static String getLastName() {
		return faker.name().lastName();
	}
	
	public static String getFullName() {
		return faker.name().fullName();
	}
	
	public static String getJob() {
		return faker.company().profession();
	}

}
