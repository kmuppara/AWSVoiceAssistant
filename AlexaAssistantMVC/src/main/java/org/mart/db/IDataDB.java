package org.mart.db;

public interface IDataDB {

	String itemLocator(String itemNm);

	String itemLocator(String itemNm, String offerNm);

	String offerFinder(String itemNm);

	String productDetails(String itemNm);

	String recomendations(String itemNm);

	String trendingItems(String itemNm);

}