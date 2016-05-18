package com.staples.puzzle.data.access;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton Utility class with functionalities for file handling.
 * This class is used for retrieving Staples and Merchant Order data
 * from csv files.
 * 
 * @author KANPR001
 *
 */
public class FileHandler{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FileHandler.class);
		
	private static FileHandler fileHandler_instance = null;
	
	/**
	 * Default constructor
	 */
	private FileHandler(){
		LOGGER.info("FileHandler - Instance created");
	}
	
	/**
	 * Public exposed method to either retrieve FileHandler instance
	 * if already present or create a new one.
	 * 
	 * @return fileHandler_instance - instance of the FileHandler
	 */
	public static FileHandler getInstance(){
		if(null == fileHandler_instance){
			fileHandler_instance = new FileHandler();
		}
		return fileHandler_instance;
	}
	
	/**
	 * Method to obtain a read handle to the input File as an instance of
	 * {@link BufferedReader}.
	 * 
	 * @param ipFilePath - path of either Staples or Merchant order data file
	 * @return fileHandle - instance of BufferedReader
	 * @throws FileNotFoundException
	 */
	public BufferedReader getReadFileHandle(String ipFilePath) throws FileNotFoundException{
		long startTime = System.currentTimeMillis();
		
    	BufferedReader fileHandle = null;    	
    	try{
    		fileHandle = new BufferedReader(new FileReader(ipFilePath));
    	}
    	catch(FileNotFoundException fnfe){
    		LOGGER.error("Unable to Create a Read File Handle!");
    		LOGGER.error(fnfe.getMessage());
    		fileHandle = null;
    		throw fnfe;
    	}
    	
    	LOGGER.info("FileHandler.getReadFileHandle::ExecutionTime::["+(System.currentTimeMillis() - startTime)+"] ms");
    	return fileHandle;
    }
	
	/**
	 * Method to close an instance of input {@link BufferedReader}
	 * @param ipFileHandle
	 */
	public void closeReadFileHandle(BufferedReader ipFileHandle){		
		try{
			if(ipFileHandle != null){
				ipFileHandle.close();
			}
		}
		catch(IOException ioe){
			LOGGER.error("Unable to close the input File Handle\n" + ioe.getMessage());
		}		
	}
}	//EOF FileHandlerImpl.java