package com.ubs.opsit.interviews.impl;

public class TimeConverterMain {

	public static void main(String[] args) {
		
		TimeConverterImpl tcImpl = new TimeConverterImpl();
		
		//midnight
		System.out.println(tcImpl.convertTime("00:00:00"));
		
		//midnight
		System.out.println(tcImpl.convertTime("24:00:00"));
		
		//afternoon
		System.out.println(tcImpl.convertTime("13:17:01"));
		
		//before midnight
		System.out.println(tcImpl.convertTime("23:59:59"));
		

	}

}
