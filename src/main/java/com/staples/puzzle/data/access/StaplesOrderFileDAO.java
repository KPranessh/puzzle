package com.staples.puzzle.data.access;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.staples.puzzle.bean.OrderDataBean;
import com.staples.puzzle.util.StaplesHelper;

/**
 * DAO Class to represent the Merchant Order Data.
 * This class maintains the data in a {@link Map}.
 * 
 * @author KANPR001
 *
 */
public class StaplesOrderFileDAO implements IStaplesAnalyticsFileDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StaplesOrderFileDAO.class);
	
	private static final String FILE_PATH = "./staples_data.csv";
	private static final String FILE_DELIMITER = ",";
	private static final String ORDER_TYPE = "STAPLES_ORDER";	
	private static final Boolean FIRST_LINE_HEADER  = true;
	private static final int  PRICE_CONVERSION = StaplesHelper.CENT_TO_DOLLAR;
	
	private FileHandler fileHandler = null;
	
	/**
	 * Constructor to assign a singleton instance of {@link FileHandler}
	 * to the {@link StaplesOrderFileDAO}
	 * 
	 * @param ipFileHandler
	 */
	public StaplesOrderFileDAO(FileHandler ipFileHandler){
		this.fileHandler = ipFileHandler;
	}
	
	/**
	 * Method to retrieve the Staples Order Data from the
	 * staples_data.csv file.
	 * This method populates the order data in a {@link HashMap}
	 * with OrderID as the key.
	 * 
	 * @return orderData
	 */
	public Map<Integer, OrderDataBean> getOrderData(){
		long startTime = System.currentTimeMillis();
		
		Map<Integer, OrderDataBean> orderData = null;
		
		String currentLine = null;
		BufferedReader ipFileReader = null;
		OrderDataBean currOrderDataBean = null;
		Integer orderID = null;
		try{
			//Getting the File Handle to read the Staples Order data csv file
			ipFileReader = this.fileHandler.getReadFileHandle(FILE_PATH);
			
			int idx = 0;
			String[] currOrderDetails = null;
			while((currentLine = ipFileReader.readLine()) != null){
				
				//Skip the first line if it contains Column Header
				if(FIRST_LINE_HEADER && (idx==0)){
					idx++;
					continue;
				}
				
				//Populating the Order Data Map
				if(!currentLine.isEmpty()){
					currOrderDetails = currentLine.split(FILE_DELIMITER);
					
					if(currOrderDetails.length > 4){
						orderID = StaplesHelper.stringToInteger(currOrderDetails[0],0);
						
						currOrderDataBean = new OrderDataBean(StaplesHelper.convertStrToDollar(currOrderDetails[1], 0.0, PRICE_CONVERSION), 
																StaplesHelper.convertStrToDollar(currOrderDetails[2], 0.0, PRICE_CONVERSION), 
																StaplesHelper.convertStrToDollar(currOrderDetails[3], 0.0, PRICE_CONVERSION), 
																currOrderDetails[4], 
																orderID, 
																ORDER_TYPE);
						
						if(null == orderData){
							orderData = new HashMap<Integer, OrderDataBean>();
						}
						orderData.put(orderID, currOrderDataBean);						
					}
				}
			}
			
			if(orderData != null){
				LOGGER.info("Staples Order File Size ["+orderData.size()+"]");
			}
		}
		catch(FileNotFoundException fnfe){
			LOGGER.error("Unable to find file ["+ FILE_PATH+"]!");			
		}
		catch(IOException ioe){
			LOGGER.error("Exception in reading from the file ["+ FILE_PATH+"]!");
		}
		finally{
			this.fileHandler.closeReadFileHandle(ipFileReader);
			currentLine = null;
			ipFileReader = null;
			currOrderDataBean = null;
			orderID = null;
		}
		
		LOGGER.info("StaplesOrderFileDAO.getOrderData::ExecutionTime::["+(System.currentTimeMillis() - startTime)+"] ms");
		return orderData;
	}
}	//EOF StaplesOrderFileDAO.java