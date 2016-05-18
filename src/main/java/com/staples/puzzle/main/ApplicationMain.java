package com.staples.puzzle.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.staples.puzzle.resource.StaplesAnalyticsResource;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;

/**
 * Main Execution Class for the
 * STAPLES ANALYTICS REST API.
 * 
 * @author KANPR001
 *
 */
public class ApplicationMain extends Application<Configuration>{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMain.class);
	
	/**
	 * Application's entry point.
	 * 
	 * @param args
	 * @throws Exception
	 */
    public static void main(String[] args) throws Exception{
    	LOGGER.info("Started Staples Puzzle Application!!");
    	    	
    	//Execution from the UBER jar
    	new ApplicationMain().run(args);
    	
    	//Execution from the Eclipse IDE
//    	new ApplicationMain().run(new String[] {StaplesConstants.JETTY_SERVER_INSTANCE, 
//									StaplesConstants.APP_CONFIG_FILE_PATH});
    }
    
    /**
     * Method which binds instance of {@link StaplesAnalyticsResource} to the 
     * application's Jersey {@link Environment}.
     * 
     * @param config - Dropwizard configuration
     * @param env - Dropwizard setup environment
     */
    public void run(Configuration config, Environment env){    	
    	StaplesAnalyticsResource obj = new StaplesAnalyticsResource();    	
    	env.jersey().register(obj);    	    	
    }
}	//EOF ApplicationMain.java