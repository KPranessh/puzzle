package com.staples.puzzle.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Class to represent the summary details of all Staples and Merchant orders
 * @author KANPR001
 *
 */
public class SummaryDataBean {
	
	private Double unit_price_dollars = 0.0d;
	private Double merchant_discount_dollars = 0.0d;
	private Double staples_discount_dollars = 0.0d;
	
	/**
	 * class constructor to set the summary details of all orders
	 * @param unit_price_dollars
	 * @param merchant_discount_dollars
	 * @param staples_discount_dollars
	 */
	public SummaryDataBean(Double unit_price_dollars, Double merchant_discount_dollars,
			Double staples_discount_dollars) {
		super();
		this.unit_price_dollars = unit_price_dollars;
		this.merchant_discount_dollars = merchant_discount_dollars;
		this.staples_discount_dollars = staples_discount_dollars;
	}
	
	/**
	 * class constructor to default the summary details of all orders
	 */
	public SummaryDataBean() {
		super();
		this.unit_price_dollars = 0.0d;
		this.merchant_discount_dollars = 0.0d;
		this.staples_discount_dollars = 0.0d;
	}

	/**
	 * getter method for the total unit price of all orders
	 * @return unit_price_dollars
	 */
	@JsonProperty("unit-price-dollars")
	public Double getUnit_price_dollars() {
		return unit_price_dollars;
	}
	
	/**
	 * setter method for the total unit price of all orders
	 * @param unit_price_dollars
	 */
	@JsonProperty("unit-price-dollars")
	public void setUnit_price_dollars(Double unit_price_dollars) {
		this.unit_price_dollars = unit_price_dollars;
	}
	
	/**
	 * getter method for the total discount offered by Merchant for all orders
	 * @return merchant_discount_dollars
	 */
	@JsonProperty("merchant-discount-dollars")
	public Double getMerchant_discount_dollars() {
		return merchant_discount_dollars;
	}
	
	/**
	 * setter method for the total discount offered by Merchant for all orders
	 * @param merchant_discount_dollars
	 */
	@JsonProperty("merchant-discount-dollars")
	public void setMerchant_discount_dollars(Double merchant_discount_dollars) {
		this.merchant_discount_dollars = merchant_discount_dollars;
	}
	
	/**
	 * getter method for the total discount offered by Staples for all orders
	 * @return staples_discount_dollars
	 */
	@JsonProperty("staples-discount-dollars")
	public Double getStaples_discount_dollars() {
		return staples_discount_dollars;
	}
	
	/**
	 * setter method for the total discount offered by Staples for all orders
	 * @param staples_discount_dollars
	 */
	@JsonProperty("staples-discount-dollars")
	public void setStaples_discount_dollars(Double staples_discount_dollars) {
		this.staples_discount_dollars = staples_discount_dollars;
	}
	
	/**
	 * method to add the input unit price to the existing
	 * total unit price of orders
	 * @param ipUnitPriceDollars
	 */
	@JsonIgnore
	public void addUnitPrice(Double ipUnitPriceDollars){
		this.unit_price_dollars += ipUnitPriceDollars;
	}
	
	/**
	 * method to add the input discount to the existing
	 * total discounts offered by Merchant
	 * @param ipMerchantDiscountDollars
	 */
	@JsonIgnore
	public void addMerchantDiscount(Double ipMerchantDiscountDollars){
		this.merchant_discount_dollars += ipMerchantDiscountDollars;
	}
	
	/**
	 * method to add the input discount to the existing
	 * total discounts offered by Staples
	 * @param ipStaplesDiscountDollars
	 */
	@JsonIgnore
	public void addStaplesDiscount(Double ipStaplesDiscountDollars){
		this.staples_discount_dollars += ipStaplesDiscountDollars;
	}
}	//EOF SummaryBean.java