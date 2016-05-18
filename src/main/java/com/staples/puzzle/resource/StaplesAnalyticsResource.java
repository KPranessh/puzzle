package com.staples.puzzle.resource;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.staples.puzzle.bean.StaplesReportBean;
import com.staples.puzzle.processor.IStaplesAnalyticsProcessor;
import com.staples.puzzle.processor.StaplesAnalyticsProcessor;


/**
 * Resource Class that returns StaplesReportBean Instance representing the Analytics Report
 *  a) Parent URI --> /analytics
 *  b) Output Format --> JSON
 *  c) Singleton --> Stateless Resource
 *  
 * @author KANPR001
 *
 */
@Path ("/analytics")
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class StaplesAnalyticsResource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(StaplesAnalyticsResource.class);
	
	/**
	 * Default constructor
	 */
	public StaplesAnalyticsResource(){
		LOGGER.info("StaplesAnalyticsResource - Instance created");
	}
	
	/**
	 * Main resource method to process the HTTP-GET requests for the below
	 * URI patterns 
	 *  a) /report?order_by=session-type-desc
	 *  b) /report?order_by=order-id-asc
	 *  c) /report?order_by=unit-price-dollars-asc
	 *  
	 * @param orderBy - request parameter to determine the sorting of final analytics report output
	 * @return outputReport - final report as instance of {@link StaplesReportBean}
	 */
	@GET
	@Path("/report")	
	public StaplesReportBean getAnalyticsReport(@QueryParam("order_by") String orderBy){		
		StaplesReportBean outputReport = null;
		IStaplesAnalyticsProcessor analytics_processor = null;
		
		try{
			analytics_processor = StaplesAnalyticsProcessor.getInstance();		
			outputReport = analytics_processor.getAnalyticsReport(orderBy);
		}
		finally{
			analytics_processor = null;
		}
		
		return outputReport;
	}
}	//EOF AnalyticsReportResource.java