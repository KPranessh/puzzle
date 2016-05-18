package com.staples.puzzle.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent the summary of all the Staples and
 * Merchant orders
 * @author KANPR001
 *
 */
public class SummaryBean {
	
	private SummaryDataBean staples_summary;
	private SummaryDataBean merchant_summary;
	
	/**
	 * class constructor to set the Staples and Merchant summary
	 * @param staples_summary
	 * @param merchant_summary
	 */
	public SummaryBean(SummaryDataBean staples_summary, SummaryDataBean merchant_summary) {
		super();
		this.staples_summary = staples_summary;
		this.merchant_summary = merchant_summary;
	}

	/**
	 * getter method for summary of all Staples orders
	 * @return staples_summary
	 */
	@JsonProperty("staples-summary")
	public SummaryDataBean getStaples_summary() {
		return staples_summary;
	}
	
	/**
	 * setter method for summary of all Staples orders
	 * @param staples_summary
	 */
	@JsonProperty("staples-summary")
	public void setStaples_summary(SummaryDataBean staples_summary) {
		this.staples_summary = staples_summary;
	}
	
	/**
	 * getter method for summary of all Merchant orders
	 * @return merchant_summary
	 */
	@JsonProperty("merchant-summary")
	public SummaryDataBean getMerchant_summary() {
		return merchant_summary;
	}
	
	/**
	 * setter method for summary of all Merchant orders
	 * @param merchant_summary
	 */
	@JsonProperty("merchant-summary")
	public void setMerchant_summary(SummaryDataBean merchant_summary) {
		this.merchant_summary = merchant_summary;
	}
}	//EOF SummaryBean.java