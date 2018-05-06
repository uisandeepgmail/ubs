package com.ubs.opsit.interviews;

public interface TimeConverter {

	/**
	 * Method that will take the given time and convert it to
	 * the Berlin clock time format.
	 * @param aTime given time to convert.
	 * @return time converted to the Berlin clock time format.   
	 */

	String convertTime(String aTime);

}
