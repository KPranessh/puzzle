package com.staples.puzzle.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.staples.puzzle.util.StaplesConstants;

/**
 * Class to store the Order level details.
 * This applies to both Staples and Merchant Orders.
 * 
 * @author KANPR001
 *
 */
public class OrderDataBean {
	
	private Double unit_price_dollars;
	private Double merchant_discount_dollars;
	private Double staples_discount_dollars;
	private String session_type;
	private Integer order_id;
	private String data_type;
	
	
	/**
	 * class constructor to set the Order details with the input parameters passed.
	 * 
	 * @param unit_price_dollars
	 * @param merchant_discount_dollars
	 * @param staples_discount_dollars
	 * @param session_type
	 * @param order_id
	 * @param data_type
	 */
	public OrderDataBean(Double unit_price_dollars, Double merchant_discount_dollars, Double staples_discount_dollars,
			String session_type, Integer order_id, String data_type) {
		super();
		this.unit_price_dollars = unit_price_dollars;
		this.merchant_discount_dollars = merchant_discount_dollars;
		this.staples_discount_dollars = staples_discount_dollars;
		this.session_type = session_type;
		this.order_id = order_id;
		this.data_type = data_type;
	}
	
	/**
	 * default class constructor to set the Order details with default values
	 */
	public OrderDataBean() {
		super();
		this.unit_price_dollars = 0.0d;
		this.merchant_discount_dollars = 0.0d;
		this.staples_discount_dollars = 0.0d;
		this.session_type = StaplesConstants.UNKNOWN;
		this.order_id = 0;
		this.data_type = StaplesConstants.UNKNOWN;
	}

	/**
	 * getter method for the Order type.
	 * Can have either of the values (STAPLES_DATA or MERCHANT_DATA)
	 * @return data_type
	 */
	@JsonIgnore
	public String getData_type() {
		return data_type;
	}

	/**
	 * setter method for the Order type.
	 * Can have either of the values (STAPLES_DATA or MERCHANT_DATA)
	 * @param data_type
	 */
	@JsonIgnore
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

	/**
	 * getter method for unit price total of the Order
	 * @return unit_price_dollars
	 */
	@JsonProperty("unit-price-dollars")
	public Double getUnit_price_dollars() {
		return unit_price_dollars;
	}
	
	/**
	 * setter method for unit price total of the Order
	 * @param unit_price_dollars
	 */
	@JsonProperty("unit-price-dollars")
	public void setUnit_price_dollars(Double unit_price_dollars) {
		this.unit_price_dollars = unit_price_dollars;
	}
	
	/**
	 * getter method for the discount offered by merchant for the Order
	 * @return merchant_discount_dollars
	 */
	@JsonProperty("merchant-discount-dollars")
	public Double getMerchant_discount_dollars() {
		return merchant_discount_dollars;
	}
	
	/**
	 * setter method for the discount offered by merchant for the Order
	 * @param merchant_discount_dollars
	 */
	@JsonProperty("merchant-discount-dollars")
	public void setMerchant_discount_dollars(Double merchant_discount_dollars) {
		this.merchant_discount_dollars = merchant_discount_dollars;
	}
	
	/**
	 * getter method for the discount offered by Staples for the Order
	 * @return staples_discount_dollars
	 */
	@JsonProperty("staples-discount-dollars")
	public Double getStaples_discount_dollars() {
		return staples_discount_dollars;
	}
	
	/**
	 * setter method for the discount offered by Staples for the Order
	 * @param staples_discount_dollars
	 */
	@JsonProperty("staples-discount-dollars")
	public void setStaples_discount_dollars(Double staples_discount_dollars) {
		this.staples_discount_dollars = staples_discount_dollars;
	}

	/**
	 * getter method for session type for the Order
	 * @return
	 */
	@JsonProperty("session-type")
	public String getSession_type() {
		return session_type;
	}

	/**
	 * setter method for session type for the Order
	 * @param session_type
	 */
	@JsonProperty("session-type")
	public void setSession_type(String session_type) {
		this.session_type = session_type;
	}

	/**
	 * getter method for the ID associated to the Order
	 * @return order_id
	 */
	@JsonProperty("order-id")
	public Integer getOrder_id() {
		return order_id;
	}

	/**
	 * setter method for the ID associated to the Order
	 * @param order_id
	 */
	@JsonProperty("order-id")
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
} //EOF OrderDataBean.java