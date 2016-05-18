package com.staples.puzzle.util;

/**
 * Class which contains all the constants used within Staples
 * Analytics Application
 * 
 * @author KANPR001
 *
 */
public class StaplesConstants {

	/**
	 * DAO Constants
	 */
	public static final String STAPLES_ORDER_DATA_FILE = "staples_data.csv";
	public static final String MERCHANT_ORDER_DATA_FILE = "external_data.psv";	
	public static final String DELIMITER_PIPE = "|";
	public static final String DELIMITER_COMMA = ",";
	
	/**
	 * Application Setup Constants
	 */
	public static final String JETTY_SERVER_INSTANCE = "server";
	public static final String APP_CONFIG_FILE_PATH = "../config.yml";
	
	/**
	 * HTTP Request Parameters Constants
	 */
	public static final String SESSION_TYPE_SORT_DESC = "session-type-desc";
	public static final String ORDER_ID_SORT_ASC = "order-id-asc";
	public static final String UNIT_PRICE_DOLLARS_SORT_ASC = "unit-price-dollars-asc";
	
	/**
	 * Other Constants
	 */
	public static final String UNKNOWN = "UNKNOWN";
}	//EOF StaplesConstants.java
