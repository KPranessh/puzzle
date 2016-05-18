# staples-code-puzzle
git repository for staples code puzzle

# Staples Analytics REST API
A REST API application to generate a report on order snapshot from Staples and Merchants. This report shows the overall summary of orders and also digs into the details of individual orders as well. The output format of this API would be in JSON (Javascript Object Notation).

## API ROUTES
This application is a web service that supports the following routes...

	* /analytics/report?order_by=session-type-desc - Generate the report sorting the orders by session type in descending order
	* /analytics/report?order_by=order-id-asc - Generate the report sorting the orders by order id in ascending order
	* /analytics/report?order_by=unit-price-dollars-asc - Generate the report sorting the orders by unit price in ascending order

## INPUT DATA FILES

 1) staples_data.csv
	* Comma seperated Staples order data file
	* Located in /puzzle folder
	* Sample data
	
		Order ID,Unit Price Cents,Merchant Discount Cents,Staples Discount Cents,Session Type<br>
		3184,4959,2108,1928,control

 2) merchant_data.psv
	* Pipe seperated Merchant order data file
	* Located in /puzzle folder
	* Sample data

		Order ID|Unit Price Dollars|Staples Discount Dollars|Merchant Discount Dollars|Session Type<br>
		3184|49.59|21.08|19.28|CONTROL

## SAMPLE OUTPUT

	{
	  "summaries": {
		"staples-summary": {
		  "unit-price-dollars": 49.59,
		  "merchant-discount-dollars": 21.08,
		  "staples-discount-dollars": 19.28
		},
		"merchant-summary": {
		  "unit-price-dollars": 49.59,
		  "merchant-discount-dollars": 19.28,
		  "staples-discount-dollars": 21.08
		}
	  },
	  "orders": [
		{
		  "staples-data": {
			"unit-price-dollars": 49.59,
			"merchant-discount-dollars": 21.08,
			"staples-discount-dollars": 19.28,
			"session-type": "control",
			"order-id": 3184
		  },
		  "merchant-data": {
			"unit-price-dollars": 49.59,
			"merchant-discount-dollars": 19.28,
			"staples-discount-dollars": 21.08,
			"session-type": "CONTROL",
			"order-id": 3184
		  }
		}
	  ]
	}


## FIRING UP THE REST API

	* Go to /puzzle/target folder
	* Execute java -jar puzzle-0.1.0-SNAPSHOT.jar server ../config.yml
	* Access the Web Service using the URL http://localhost:8080/analytics/report?order_by=session-type-desc