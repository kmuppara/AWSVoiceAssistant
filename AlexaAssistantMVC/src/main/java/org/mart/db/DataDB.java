package org.mart.db;

import java.util.HashMap;
import java.util.Map;

public class DataDB implements IDataDB {

	private static Map<String, String> itemsPlace = new HashMap<>();
	private static Map<String, String> offers = new HashMap<>();
	private static Map<String, String> productDetails = new HashMap<>();
	private static Map<String, String> recomendations = new HashMap<>();

	static {
		itemsPlace.put("grocery", "grocery is available in ground floor at first bay");
		itemsPlace.put("personal care", "personal care is available in ground floor at second bay");
		itemsPlace.put("toys", "toys are available in second floor at third bay");
		itemsPlace.put("home appliances", "home appliances are available in second floor at second bay");

		offers.put("grocery", "Ten percent discount on minimum purchase of five hundred rupees");
		offers.put("personal care", "Buy any two soaps and get one soap for free");
		offers.put("toys", "get a gift voucher on purchase of more than three items");
		offers.put("home appliances", "get an iron box on purchase of air conditioner ");

		productDetails.put("air conditioner",
				"The price ranges are ten thousand to twenty thousand. These are copper coiled and heavy weight gas filled.");
		productDetails.put("cooker", "Auto off facility. Cooking without flame. More comfortable and easy to use.");

		recomendations.put("soaps",
				"We recommend luxx since it is having good moisturing and cost is low compared to other's.");
		recomendations.put("biscuits", "We recommend parle g since it's a most purchased product.");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.db.IDataDB#itemLocator(java.lang.String)
	 */
	@Override
	public String itemLocator(String itemNm) {
		String data = itemsPlace.get(itemNm);
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.db.IDataDB#itemLocator(java.lang.String, java.lang.String)
	 */
	@Override
	public String itemLocator(String itemNm, String offerNm) {
		String data = itemsPlace.get(itemNm);
		if ("yes".equalsIgnoreCase(offerNm) || "offers".equalsIgnoreCase(offerNm))
			data += " And " + offers.get(itemNm);
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.db.IDataDB#offerFinder(java.lang.String)
	 */
	@Override
	public String offerFinder(String itemNm) {
		String data = offers.get(itemNm);
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.db.IDataDB#productDetails(java.lang.String)
	 */
	@Override
	public String productDetails(String itemNm) {
		String data = productDetails.get(itemNm);
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.db.IDataDB#recomendations(java.lang.String)
	 */
	@Override
	public String recomendations(String itemNm) {
		String data = recomendations.get(itemNm);
		return data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.db.IDataDB#trendingItems(java.lang.String)
	 */
	@Override
	public String trendingItems(String itemNm) {
		String data = "Trending items in the shopping inventory are footwear, home appliances and milk products. Thank you.";
		return data;
	}

}
