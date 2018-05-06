package com.ubs.opsit.interviews.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test class for the helper class TimeConverterHelper
 * 
 * @author sandeep
 *
 */
public class TimeConverterHelperTest {

	/**
	 * Test to ascertain that the given time is separated into correct hh, mm and ss components.
	 */
	@Test
	public void calculateTimeComponents() {
		String[] timeArray = TimeConverterHelper.calculateTimeComponents("00:00:00");
		assertEquals(3, timeArray.length);
		assertEquals("00", timeArray[0]);
		assertEquals("00", timeArray[1]);
		assertEquals("00", timeArray[2]);
		
		timeArray = TimeConverterHelper.calculateTimeComponents("23:59:00");
		assertEquals(3, timeArray.length);
		assertEquals("23", timeArray[0]);
		assertEquals("59", timeArray[1]);
		assertEquals("00", timeArray[2]);
		
	}

	
	/**
	 * Test to check the seconds related Berlin time String.
	 */
	@Test
	public void computeSecondsString() {
		assertEquals("Y", TimeConverterHelper.computeSecondsString("00"));
		assertEquals("Y", TimeConverterHelper.computeSecondsString("20"));
		assertEquals("O", TimeConverterHelper.computeSecondsString("21"));
	}
	
	/**
	 * Test to check the minutes related Berlin time String.
	 */
	@Test
	public void computeMinutesString() {
		assertEquals("OOOOOOOOOOO\r\nOOOO", TimeConverterHelper.computeMinutesString("00"));
		assertEquals("OOOOOOOOOOO\r\nYYYY", TimeConverterHelper.computeMinutesString("04"));
		assertEquals("OOOOOOOOOOO\r\nYYYO", TimeConverterHelper.computeMinutesString("03"));
		assertEquals("OOOOOOOOOOO\r\nYYOO", TimeConverterHelper.computeMinutesString("02"));
		assertEquals("OOOOOOOOOOO\r\nYOOO", TimeConverterHelper.computeMinutesString("01"));
		assertEquals("YOOOOOOOOOO\r\nOOOO", TimeConverterHelper.computeMinutesString("05"));
		assertEquals("YOOOOOOOOOO\r\nYYYY", TimeConverterHelper.computeMinutesString("09"));
		assertEquals("YYOOOOOOOOO\r\nOOOO", TimeConverterHelper.computeMinutesString("10"));
		assertEquals("YYOOOOOOOOO\r\nYYYY", TimeConverterHelper.computeMinutesString("14"));
		assertEquals("YYROOOOOOOO\r\nOOOO", TimeConverterHelper.computeMinutesString("15"));
		assertEquals("YYRYOOOOOOO\r\nOOOO", TimeConverterHelper.computeMinutesString("20"));
		assertEquals("YYRYYROOOOO\r\nOOOO", TimeConverterHelper.computeMinutesString("30"));
		assertEquals("YYRYYRYYROO\r\nOOOO", TimeConverterHelper.computeMinutesString("45"));
		assertEquals("YYRYYRYYRYY\r\nYYYY", TimeConverterHelper.computeMinutesString("59"));
		assertEquals("YYRYYRYYRYO\r\nYYOO", TimeConverterHelper.computeMinutesString("52"));
	}
	
	
	/**
	 * Test to check the hour related Berlin time String.
	 */
	@Test
	public void computeHourString() {
		assertEquals("OOOO\r\nOOOO", TimeConverterHelper.computeHoursString("00"));
		assertEquals("OOOO\r\nROOO", TimeConverterHelper.computeHoursString("01"));
		assertEquals("OOOO\r\nRROO", TimeConverterHelper.computeHoursString("02"));
		assertEquals("OOOO\r\nRRRO", TimeConverterHelper.computeHoursString("03"));
		assertEquals("OOOO\r\nRRRR", TimeConverterHelper.computeHoursString("04"));
		assertEquals("ROOO\r\nOOOO", TimeConverterHelper.computeHoursString("05"));
		assertEquals("ROOO\r\nRRRO", TimeConverterHelper.computeHoursString("08"));
		assertEquals("RROO\r\nOOOO", TimeConverterHelper.computeHoursString("10"));
		assertEquals("RRRO\r\nOOOO", TimeConverterHelper.computeHoursString("15"));
		assertEquals("RRRR\r\nOOOO", TimeConverterHelper.computeHoursString("20"));
		assertEquals("RRRR\r\nRROO", TimeConverterHelper.computeHoursString("22"));
		assertEquals("RRRR\r\nRRRR", TimeConverterHelper.computeHoursString("24"));
	}
	


}
