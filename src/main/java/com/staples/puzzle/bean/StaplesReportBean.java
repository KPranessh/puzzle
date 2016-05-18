package com.staples.puzzle.bean;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent the final Analytics Report that includes
 *  a) Combined Summary of Staples data for all the Orders
 *  b) Combined Summary of Merchant data for all the Orders
 *  c) Details of Staples data at the individual Order level
 *  d) Details of Merchant data at the individual Order level
 *  
 * @author KANPR001
 *
 */
public class StaplesReportBean {
	
	private SummaryBean summaries;
	private List<OrderBean> orders;
	
	/**
	 * class constructor to set the Staples and Merchant summary data
	 * and their individual order details
	 * 
	 * @param summaries
	 * @param orders
	 */
	public StaplesReportBean(SummaryBean summaries, List<OrderBean> orders) {
		super();
		this.summaries = summaries;
		this.orders = orders;
	}
	
	/**
	 * method to add the details of an Order (Staples/ Merchant) to the report 
	 * @param order
	 */
	public void addOrder(OrderBean order){
		if(null == orders){
			orders = new ArrayList<OrderBean>();
		}
		orders.add(order);
	}
	
	/**
	 * method to add Summary of all the Orders (Staples/ Merchant) to the report
	 * @param summaryBean
	 */
	public void addSummary(SummaryBean summaryBean){
		this.summaries = summaryBean;
	}

	/**
	 * getter method for the summaries of all the orders (Staples/ Merchant)
	 * @return summaries
	 */
	@JsonProperty("summaries")
	public SummaryBean getSummaries() {
		return summaries;
	}
	
	/**
	 * setter method for the summaries of all the orders (Staples/ Merchant)
	 * @param summaries
	 */
	@JsonProperty("summaries")
	public void setSummaries(SummaryBean summaries) {
		this.summaries = summaries;
	}
	
	/**
	 * getter method for all the order details (Staples/ Merchant)
	 * @return orders
	 */
	@JsonProperty("orders")
	public List<OrderBean> getOrders() {
		return orders;
	}
	
	/**
	 * setter method for all the order details (Staples/ Merchant)
	 * @param orders
	 */
	@JsonProperty("orders")
	public void setOrders(List<OrderBean> orders) {
		this.orders = orders;
	}
}	//EOF StaplesReportBean.java