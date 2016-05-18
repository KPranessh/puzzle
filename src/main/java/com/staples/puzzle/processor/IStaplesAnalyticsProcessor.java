package com.staples.puzzle.processor;

import com.staples.puzzle.bean.StaplesReportBean;

/**
 * Interface to the {@link StaplesAnalyticsProcessor}
 * This interface exposes the method to the main analytics processor
 * to generate the Final Analytics Report as an instance of
 * {@link StaplesReportBean}.
 *  
 * @author KANPR001
 *
 */
public interface IStaplesAnalyticsProcessor {

	/**
	 * This method executes the business logic to gather all the 
	 * Order information to generate the final analytics report.
	 * 
	 * @param reportType
	 * @return StaplesReportBean
	 */
	public StaplesReportBean getAnalyticsReport(String reportType);
}
