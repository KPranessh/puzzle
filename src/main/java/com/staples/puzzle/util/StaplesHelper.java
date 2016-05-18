package com.staples.puzzle.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helper Class for the Staples Analytics Application
 * 
 * @author KANPR001
 *
 */
public class StaplesHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaplesHelper.class);
	
	public static final int CENT_TO_DOLLAR = 1;
	public static final int DOLLAR_TO_DOLLAR = 2;	
	
	/**
	 * Method to convert the String representation of the input
	 * double into an {@link Double} instance.
	 * 
	 * @param ipStr - string representation of a {@link Double}
	 * @param defaultValue - default Double value to be returned in case conversion fails
	 * @param conversionType - indicates if the input string needs to be converted 
	 *        to Dollars from Dollars or Cents
	 * @return returnValue - Double (converted or default)
	 */
	public static Double convertStrToDollar(String ipStr, Double defaultValue, int conversionType){
		
		Double dollarValue = defaultValue;
		try{
			if(CENT_TO_DOLLAR==conversionType){
				dollarValue = (Double.parseDouble(ipStr))/100;
			}
			else{
				dollarValue = (Double.parseDouble(ipStr));
			}			
		}
		catch(NumberFormatException nfe){
			LOGGER.warn("Invalid number format for..." + ipStr);
			dollarValue = defaultValue;
		}
		
		return dollarValue;
	}
	
	/**
	 * Method to convert the String representation of the input
	 * integer into an {@link Integer} instance.
	 * 
	 * @param ipStr - string representation of an integer
	 * @param defaultValue - default integer value to be returned in case conversion fails
	 * @return returnValue - Integer (converted or default)
	 */
	public static Integer stringToInteger(String ipStr, Integer defaultValue){		
		Integer returnValue = defaultValue;
		
		try{
			returnValue = Integer.parseInt(ipStr);
		}
		catch(NumberFormatException nfe){
			LOGGER.warn("Invalid number format for..." + ipStr);
			returnValue = defaultValue;
		}
		
		return returnValue;
	}
}	//EOF StaplesHelper.java