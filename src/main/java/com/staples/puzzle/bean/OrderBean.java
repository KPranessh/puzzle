package com.staples.puzzle.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to store Staples and Merchant Order data. 
 * 
 * @author KANPR001
 *
 */
public class OrderBean{
	
	private OrderDataBean staples_data; 
	private OrderDataBean merchant_data;	
	
	/**
	 * class constructor to initialize Staples and Merchant data with the 
	 * input OrderDataBean(s).
	 * 
	 * @param staples_data
	 * @param merchant_data
	 */
	public OrderBean(OrderDataBean staples_data, OrderDataBean merchant_data) {
		super();
		this.staples_data = staples_data;
		this.merchant_data = merchant_data;
	}

	/**
	 * default class constructor initializing empty Staples and 
	 * Merchant Order data.
	 */
	public OrderBean(){
		this.staples_data = new OrderDataBean();
		this.merchant_data = new OrderDataBean();;
	}
	
	/**
	 * getter method to return Staples Order data as
	 * an instance of OrderDataBean
	 * @return staples_data
	 */
	@JsonProperty("staples-data")
	public OrderDataBean getStaples_data() {
		return staples_data;
	}
	
	/**
	 * setter method to set Staples Order data with the
	 * input OrderDataBean
	 * @param staples_data
	 */
	@JsonProperty("staples-data")
	public void setStaples_data(OrderDataBean staples_data) {
		this.staples_data = staples_data;
	}
	
	/**
	 * getter method to return Merchant Order data as
	 * an instance of OrderDataBean
	 * @return merchant_data
	 */
	@JsonProperty("merchant-data")
	public OrderDataBean getMerchant_data() {
		return merchant_data;
	}
	
	/**
	 * setter method to set Merchant Order data with the
	 * input OrderDataBean
	 * @param merchant_data
	 */
	@JsonProperty("merchant-data")
	public void setMerchant_data(OrderDataBean merchant_data) {
		this.merchant_data = merchant_data;
	}
}	//EOF OrderBean.java