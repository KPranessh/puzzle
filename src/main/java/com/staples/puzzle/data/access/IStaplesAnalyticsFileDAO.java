package com.staples.puzzle.data.access;

import java.util.Map;

import com.staples.puzzle.bean.OrderDataBean;

/**
 * Interface representation of a Staples Order File DAO.
 *  
 * @author KANPR001
 *
 */
public interface IStaplesAnalyticsFileDAO {
	
	/**
	 * Method to retrieve Staples/ Merchant Order data from
	 * their respective csv files
	 * @return {@link Map} of Order Data with order_id as the key
	 */
	public Map<Integer, OrderDataBean> getOrderData();

}	//EOF IStaplesAnalyticsFileDAO.java
