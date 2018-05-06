package com.ubs.opsit.interviews.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Test class for TimeConverterImpl
 * @author sandeep
 *
 */
public class TimeConverterImplTest {

	TimeConverterImpl timeConverter;
	@Before
	public void setUp() {
		timeConverter = new TimeConverterImpl();
	}
	
	//time = 00:00:00
	private String timeMidnight1 = "Y\r\n" + 
			"OOOO\r\n" + 
			"OOOO\r\n" + 
			"OOOOOOOOOOO\r\n" + 
			"OOOO"
			;

	//time = 24:00:00
	private String timeMidnight2 = "Y\r\n" + 
			"RRRR\r\n" + 
			"RRRR\r\n" + 
			"OOOOOOOOOOO\r\n" + 
			"OOOO"
			;
	
	//time = 13:17:01
	private String timeAfternoon = "O\r\n" + 
			"RROO\r\n" + 
			"RRRO\r\n" + 
			"YYROOOOOOOO\r\n" + 
			"YYOO";
	
	//time = 23:59:59
	private String timeBeforeMidnight = "O\r\n" + 
			"RRRR\r\n" + 
			"RRRO\r\n" + 
			"YYRYYRYYRYY\r\n" + 
			"YYYY";
	@Test
	/**
	 * To test boundary time 00:00:00
	 */
	public void convertTimeMidnight1() {
		assertEquals(timeMidnight1, timeConverter.convertTime("00:00:00"));
	}

	@Test
	/**
	 * To test boundary time 24:00:00
	 */
	public void convertTimeMidnight2() {
		assertEquals(timeMidnight2, timeConverter.convertTime("24:00:00"));
	}
	
	@Test
	/**
	 * To test afternoon time 13:17:01
	 */
	public void convertTimeAfternoon() {
		assertEquals(timeAfternoon, timeConverter.convertTime("13:17:01"));
	}
	
	@Test
	/**
	 * To test before midnight time 23:59:59
	 */
	public void convertTimeBeforeMidnight() {
		assertEquals(timeBeforeMidnight, timeConverter.convertTime("23:59:59"));
	}
}
