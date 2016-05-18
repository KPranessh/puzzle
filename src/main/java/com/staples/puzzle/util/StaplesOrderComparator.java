package com.staples.puzzle.util;

import java.util.Comparator;

import com.staples.puzzle.bean.OrderBean;
import com.staples.puzzle.bean.OrderDataBean;

/**
 * Custom comparator created for sorting {@link OrderBean} instances.
 * This class implements {@link Comparator}.
 * 
 * @author KANPR001
 *
 */
public class StaplesOrderComparator implements Comparator<OrderBean>{
	
	/**
	 * ENUM Datatype for representing the Sorting Sequence
	 *  a) ASC - Ascending
	 *  b) DESC - Descending
	 *  
	 * @author KANPR001
	 *
	 */
	public static enum SORT_TYPE{
		ASC,
		DESC
	}
	
	/**
	 * ENUM Datatype for representing the Sorting Fields
	 *  a) SESSION_TYPE - session type of Staples/ Merchant Order
	 *  b) ORDER_ID - Order ID of Staples/ Merchant Order
	 *  c) UNIT_PRICE_DOLLARS - Unit Price Dollar of Staples/ Merchant Order
	 *  
	 * @author KANPR001
	 *
	 */
	public static enum SORT_FIELD{
		SESSION_TYPE,
		ORDER_ID,
		UNIT_PRICE_DOLLARS
	}	
	
	private SORT_FIELD sort_field;
	private SORT_TYPE sort_by;
		
	/**
	 * Constructor to set the Sort Field and Sort Sequence for the current instance
	 * of {@link StaplesOrderComparator}.
	 * 
	 * @param sortField
	 * @param sortBy
	 */
	public StaplesOrderComparator(SORT_FIELD sortField, SORT_TYPE sortBy){
		this.sort_field = sortField;
		this.sort_by = sortBy;
	}
	
	/**
	 * Overridden method to compare 2 instances of {@link OrderBean}.
	 *  a) Retrieve Staples {@link OrderDataBean} for input 2 {@link OrderBean}
	 *  b) If the Staples OrderDataBean(s) are invalid, then retrieve the Merchant OrderDataBean(s)
	 *  c) Depending on the Sort Sequence, compare the values of required sort field
	 *  
	 * @param order1
	 * @param order2
	 */
	@Override
	public int compare(OrderBean order1, OrderBean order2){	
		int result = 0;
		
		OrderDataBean compareObj1 = order1.getStaples_data();
		OrderDataBean compareObj2 = order2.getStaples_data();
		
		if(StaplesConstants.UNKNOWN.equalsIgnoreCase(compareObj1.getSession_type()) ||
				StaplesConstants.UNKNOWN.equalsIgnoreCase(compareObj2.getSession_type())){
			compareObj1 = order1.getMerchant_data();
			compareObj2 = order2.getMerchant_data();
		}
				
		switch(sort_field){
		case SESSION_TYPE:
			if(sort_by == SORT_TYPE.ASC){
				result = compareObj1.getSession_type().compareTo(compareObj2.getSession_type());
			}
			else{
				result = compareObj2.getSession_type().compareTo(compareObj1.getSession_type());
			}
			break;
		case ORDER_ID:
			if(sort_by == SORT_TYPE.ASC){
				result = compareObj1.getOrder_id().compareTo(compareObj2.getOrder_id());
			}
			else{
				result = compareObj2.getOrder_id().compareTo(compareObj1.getOrder_id());
			}
			break;
		case UNIT_PRICE_DOLLARS:
			if(sort_by == SORT_TYPE.ASC){
				result = compareObj1.getUnit_price_dollars().compareTo(compareObj2.getUnit_price_dollars());
			}
			else{
				result = compareObj2.getUnit_price_dollars().compareTo(compareObj1.getUnit_price_dollars());
			}
			break;
		default:
			result = 0;
		}
		
		return result;
	}
}	//EOF StaplesOrderComparator.java