package com.ubs.opsit.interviews.impl;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.utility.TimeConverterHelper;

/**
 * Class that actually converts the given time to Berlin clock format.
 * 
 * @author sandeep
 *
 */
public class TimeConverterImpl implements TimeConverter {

	private String hour = "";
	private String minute = "";
	private String second = "";
	
	
	/**
	 * Method that will take the given time and convert it to
	 * the Berlin clock time format.
	 * @param aTime given time to convert.
	 * @return time converted to the Berlin clock time format.   
	 */
	@Override
	public String convertTime(String aTime) {
		
		String[] timeArray = TimeConverterHelper.calculateTimeComponents(aTime);
		initializeTimeComponents(timeArray);
		String secondsString = TimeConverterHelper.computeSecondsString(second);
		String minutesString = TimeConverterHelper.computeMinutesString(minute);
		String hoursString = TimeConverterHelper.computeHoursString(hour);
		
		return secondsString + "\r\n" + hoursString + "\r\n" + minutesString;
}
	
	/**
	 * Initialize the time components(hh, min and sec) to the given time.
	 * @param timeArray An array of min, sec and hours.
	 */
	private void initializeTimeComponents(String[] timeArray) {
		this.hour = timeArray[0];
		this.minute = timeArray[1];
		this.second = timeArray[2];
	}
}