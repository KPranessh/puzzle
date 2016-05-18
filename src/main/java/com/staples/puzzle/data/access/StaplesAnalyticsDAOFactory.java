package com.staples.puzzle.data.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.staples.puzzle.bean.OrderDataBean;

/**
 * Factory class for spawning instances of {@link StaplesOrderFileDAO} and
 * {@link MerchantOrderFileDAO}.
 * These Data Access Objects are responsible for retrieving the Order details and
 * populating them in instances of {@link OrderDataBean}.
 * 
 * @author KANPR001
 *
 */
public class StaplesAnalyticsDAOFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(StaplesAnalyticsDAOFactory.class);
	
	/**
	 * Singleton instance of the staples analytics DAO Factory
	 */
	private static StaplesAnalyticsDAOFactory factory_instance = null;
	
	/**
	 * Default constructor
	 */
	private StaplesAnalyticsDAOFactory(){
		LOGGER.info("StaplesAnalyticsDAOFactory - Instance created");
	}
	
	/**
	 * Public exposed method to either retrieve {@link StaplesAnalyticsDAOFactory} instance
	 * if already present or create a new one.
	 * 
	 * @return factory_instance - instance of the StaplesAnalyticsDAOFactory
	 */
	public static StaplesAnalyticsDAOFactory getInstance(){
		if(null == factory_instance){
			factory_instance = new StaplesAnalyticsDAOFactory();
		}
		return factory_instance;
	}
	
	/**
	 * Factory method to instantiate {@link StaplesOrderFileDAO}.
	 * 
	 * @param FileHandler instance
	 * @return instance of {@link StaplesOrderFileDAO} referenced by {@link IStaplesAnalyticsFileDAO}
	 */
	public IStaplesAnalyticsFileDAO getStaplesOrderFileDAO(){
		return new StaplesOrderFileDAO(FileHandler.getInstance());
	}
	
	/**
	 * Factory method to instantiate {@link MerchantOrderFileDAO}.
	 * 
	 * @param FileHandler instance
	 * @return instance of {@link MerchantOrderFileDAO} referenced by {@link IStaplesAnalyticsFileDAO}
	 */
	public IStaplesAnalyticsFileDAO getMerchantOrderFileDAO(){
		return new MerchantOrderFileDAO(FileHandler.getInstance());
	}
}	//EOF StaplesAnalyticsDAOFactory.java 