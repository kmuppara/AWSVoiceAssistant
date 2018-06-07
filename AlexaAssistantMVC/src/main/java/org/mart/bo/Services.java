package org.mart.bo;

import java.util.Map;

import org.mart.db.DataDB;
import org.mart.db.IDataDB;
import org.mart.response.IntentObj;
import org.mart.response.OutputSpeech;
import org.mart.response.ResponseObj;

public class Services implements IServices {

	// I couldn't find that one, but I'm working on adding more local businesses.

	OutputSpeech ops = null;
	ResponseObj response = null;
	private static IDataDB db = new DataDB();

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.bo.IServices#launchAlexa(java.util.Map)
	 */
	@Override
	public ResponseObj launchAlexa(Map<String, Object> request) {
		ops = new OutputSpeech("PlainText",
				"Welcome to my mart. We are here to assist you in locating items, finding offers, product details, Purchase history and recommendation on items. How can i assist you?");

		response = new ResponseObj(new IntentObj(ops));

		return response;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.bo.IServices#intentRequest(java.util.Map)
	 */
	@Override
	public ResponseObj intentRequest(Map<String, Object> request) {

		@SuppressWarnings("unchecked")
		Map<String, Object> intentMap = (Map<String, Object>) request.get("intent");
		String intentName = (String) intentMap.get("name");
		String confirmationStatus = (String) intentMap.get("confirmationStatus");

		String data = "Ooops, I couldn't find that one, but I'm working on adding more local businesses.";
		String dialogState = (String) request.get("dialogState");

		//////////
		if ("ItemLocator".equalsIgnoreCase(intentName)) {

			@SuppressWarnings("unchecked")
			Map<String, Object> slotMap = (Map<String, Object>) intentMap.get("slots");
			@SuppressWarnings("unchecked")
			Map<String, Object> itemMap = (Map<String, Object>) slotMap.get("item");
			@SuppressWarnings("unchecked")
			Map<String, Object> offersMap = (Map<String, Object>) slotMap.get("offers");
			String itemNm = (String) itemMap.get("value");
			String offerNm = (String) offersMap.get("value");
			data = db.itemLocator(itemNm, offerNm);

			if ("NONE".equalsIgnoreCase(confirmationStatus)
					&& ("STARTED".equalsIgnoreCase(dialogState) || "IN_PROGRESS".equalsIgnoreCase(dialogState))) {
				response = new ResponseObj(new IntentObj(dialogState));
			} else if ("CONFIRMED".equalsIgnoreCase(confirmationStatus)) {
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			} else {// DENIED CASE
				data = "That's cool. Seems you changed your mind. Please let us know if you still want any other information.";
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			}
		}

		/////////
		else if ("offerFinder".equalsIgnoreCase(intentName)) {
			@SuppressWarnings("unchecked")
			Map<String, Object> slotMap = (Map<String, Object>) intentMap.get("slots");
			@SuppressWarnings("unchecked")
			Map<String, Object> itemMap = (Map<String, Object>) slotMap.get("item");
			String itemNm = (String) itemMap.get("value");
			data = db.offerFinder(itemNm);

			if ("NONE".equalsIgnoreCase(confirmationStatus)
					&& ("STARTED".equalsIgnoreCase(dialogState) || "IN_PROGRESS".equalsIgnoreCase(dialogState))) {
				response = new ResponseObj(new IntentObj(dialogState));
			} else if ("CONFIRMED".equalsIgnoreCase(confirmationStatus)) {
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			} else {// DENIED CASE
				data = "That's cool. Seems you changed your mind. Please let us know if you still want any other information.";
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			}
		}

		////////////
		else if ("ProductDetails".equalsIgnoreCase(intentName)) {
			@SuppressWarnings("unchecked")
			Map<String, Object> slotMap = (Map<String, Object>) intentMap.get("slots");
			@SuppressWarnings("unchecked")
			Map<String, Object> itemMap = (Map<String, Object>) slotMap.get("item");
			String itemNm = (String) itemMap.get("value");
			data = db.productDetails(itemNm);

			if ("NONE".equalsIgnoreCase(confirmationStatus)
					&& ("STARTED".equalsIgnoreCase(dialogState) || "IN_PROGRESS".equalsIgnoreCase(dialogState))) {
				response = new ResponseObj(new IntentObj(dialogState));
			} else if ("CONFIRMED".equalsIgnoreCase(confirmationStatus)) {
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			} else {// DENIED CASE
				data = "That's cool. Seems you changed your mind. Please let us know if you still want any other information.";
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			}
		}

		///////////
		else if ("PurchaseHistory".equalsIgnoreCase(intentName)) {
			/*
			 * data =
			 * "You have purchased one cooker with fully automated and two soaps. Would you like to buy any of them once again?"
			 * ; ops = new OutputSpeech("PlainText", data); response = new ResponseObj(new
			 * IntentObj(ops));
			 */

			/*
			 * Map<String, Object> slotMap = (Map<String, Object>) intentMap.get("slots");
			 * Map<String, Object> custMap = (Map<String, Object>)
			 * slotMap.get("CustomerId"); String custId = (String)custMap.get("value");
			 * //data = db.itemLocator(custId);
			 */

			data = "We are very sorry David to say that cookers are not available at this moment. We will try to make it available soon in the inventory.";

			if ("NONE".equalsIgnoreCase(confirmationStatus)
					&& ("STARTED".equalsIgnoreCase(dialogState) || "IN_PROGRESS".equalsIgnoreCase(dialogState))) {
				response = new ResponseObj(new IntentObj(dialogState));
			} else if ("CONFIRMED".equalsIgnoreCase(confirmationStatus)) {
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			} else {// DENIED CASE
				data = "That's cool. Seems you changed your mind. Please let us know if you still want any other information.";
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			}
		}

		//////////
		else if ("Recommendations".equalsIgnoreCase(intentName)) {
			@SuppressWarnings("unchecked")
			Map<String, Object> slotMap = (Map<String, Object>) intentMap.get("slots");
			@SuppressWarnings("unchecked")
			Map<String, Object> itemMap = (Map<String, Object>) slotMap.get("item");
			String itemNm = (String) itemMap.get("value");
			data = db.recomendations(itemNm);

			if ("NONE".equalsIgnoreCase(confirmationStatus)
					&& ("STARTED".equalsIgnoreCase(dialogState) || "IN_PROGRESS".equalsIgnoreCase(dialogState))) {
				response = new ResponseObj(new IntentObj(dialogState));
			} else if ("CONFIRMED".equalsIgnoreCase(confirmationStatus)) {
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			} else {// DENIED CASE
				data = "That's cool. Seems you changed your mind. Please let us know if you still want any other information.";
				ops = new OutputSpeech("PlainText", data);
				response = new ResponseObj(new IntentObj(ops));
			}
		}

		/////////
		else if ("TrendingItems".equalsIgnoreCase(intentName)) {
			data = db.trendingItems(intentName);
			ops = new OutputSpeech("PlainText", data);
			response = new ResponseObj(new IntentObj(ops));
		}

		else if ("AMAZON.FallbackIntent".equalsIgnoreCase(intentName)) {
			ops = new OutputSpeech("PlainText",
					"Hmm. We did not get you. Please ask some other to assist you in a better way.");
			response = new ResponseObj(new IntentObj(ops));
		}

		else if ("AMAZON.HelpIntent".equalsIgnoreCase(intentName)) {
			// ops = new OutputSpeech("PlainText", "Welcome to big bazaar, We are here to
			// assist you in locating items, finding offers, product details, Purchase
			// history and recommendation on items.");
			ops = new OutputSpeech("", "Thank for visiting big bazaar. It's please to assist you. Have a great day!!");
			response = new ResponseObj(new IntentObj(ops));
		}

		else if ("AMAZON.StopIntent".equalsIgnoreCase(intentName)
				|| "AMAZON.CancelIntent".equalsIgnoreCase(intentName)) {
			ops = new OutputSpeech("PlainText",
					"Thank for visiting big bazaar. It's pleasure to assist you. Have a great day!!");
			response = new ResponseObj(new IntentObj(ops));
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.mart.bo.IServices#endRequest(java.util.Map)
	 */
	@Override
	public ResponseObj endRequest(Map<String, Object> request) {
		OutputSpeech ops = new OutputSpeech("PlainText",
				"Thank for visiting big bazaar. It's please to assist you. Have a great day!!");
		ResponseObj response = new ResponseObj(new IntentObj(ops));
		return response;
	}

}
