package com.ubs.opsit.interviews.utility;

import java.util.StringTokenizer;

/**
 * Helper class to convert the given time to Berlin clock format
 * 
 * @author sandeep
 *
 */
public class TimeConverterHelper {

	enum TimeComponent {HOUR, MINUTE};
	/**
	 * Method to separate the time components hh, mn and sec from the given time.
	 * 
	 * @param aTime given time.
	 * @return String array containing the hh, min and sec.
	 */
	public static String[] calculateTimeComponents(String aTime) {
		StringTokenizer st = new StringTokenizer(aTime, ":");
		String[] timeArray = new String[3];
		int counter = 0;
		while(st.hasMoreTokens()) {
			timeArray[counter] = st.nextToken();
			counter ++;
		}
		return timeArray;
	}
	
	/**
	 * Get the seconds related time in Berlin clock format.
	 * 
	 * @param seconds - given seconds
	 * @return - String either O or Y.
	 */
	public static String computeSecondsString(String seconds) {
		if(Integer.parseInt(seconds) % 2 == 0 ) {
			return "Y";
		} 
		return "O";
	}
	
	/**
	 * Get the minutes related time in Berlin clock format.
	 * 
	 * @param minutes - given minutes
	 * @return - String of minutes bulb status.
	 */
	public static String computeMinutesString(String minutes) {
		char[] firstRowValue = {'O','O','O','O','O','O','O','O','O','O','O'};
		char[] secondRowValue = {'O','O','O','O'};
		return findTimeComponentBulbStatus(minutes, 5, TimeComponent.MINUTE, firstRowValue, secondRowValue);	}

	/**
	 * Get the hour related time in Berlin clock format.
	 * 
	 * @param hour - given hours
	 * @return - String of hour bulb status.
	 */
	public static String computeHoursString(String hours) {
		char[] firstRowValue = {'O','O','O','O'};
		char[] secondRowValue = {'O','O','O','O'};
		
		return findTimeComponentBulbStatus(hours, 5, TimeComponent.HOUR, firstRowValue, secondRowValue);
	}
	
	/**
	 * This is a generic method which irrespective of hour or minutes given as input will convert it to the
	 * Berlin clock format.
	 * 
	 * @param aTime given time.
	 * @param factor division factor. Eg. each minute bulb represents 5 minutes, each hour
	 * 					hour bulb represents 5 hours in upper rows.
	 * @param timeComponentType - hour or minute.
	 * @param firstRow - char array for first row. At runtime it can be either minute or hour.
	 * @param secondRow - char array for second row. At runtime it can be either minute or hour.
	 * @return String representation of either minute or hour in Berlin clock format.
	 */
	private static String findTimeComponentBulbStatus(String aTime, int factor, TimeComponent timeComponentType, char[] firstRow, char[] secondRow) {
		
		String returnValue = "";
		boolean hourComponent = false;
		if(TimeComponent.HOUR.equals(timeComponentType)) {
			hourComponent = true;
		}
		int aTimeValue = Integer.parseInt(aTime);
		int aTime1 = aTimeValue/factor ;
		int aTime2 = aTimeValue%factor ;
		
		for(int i = 0; i < aTime1; i++) {
			if(hourComponent) {
				firstRow[i] = 'R';
			} else {
				if(i%3 == 2) {
					firstRow[i] = 'R';
				} else {
					firstRow[i] = 'Y';
				}
				
			}
		}
		
		for(int i = 0; i < aTime2; i++) {
			if(hourComponent) {
				secondRow[i] = 'R';
			} else {
				secondRow[i] = 'Y';
			}
		}
		
		returnValue = String.valueOf(firstRow) + "\r\n" +String.valueOf(secondRow);
		
		return returnValue;
	}

}
