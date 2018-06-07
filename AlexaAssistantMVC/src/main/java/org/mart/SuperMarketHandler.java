package org.mart;

import java.util.Map;

import org.mart.bo.IServices;
import org.mart.bo.Services;
import org.mart.response.ResponseObj;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SuperMarketHandler implements RequestHandler<Map<String, Object>, Object> {

	ResponseObj response = null;

	@Override
	public Object handleRequest(Map<String, Object> input, Context context) {

		@SuppressWarnings("unchecked")
		Map<String, Object> request = (Map<String, Object>) input.get("request");
		String requestType = (String) request.get("type");
		IServices services = new Services();
		if ("LaunchRequest".equalsIgnoreCase(requestType))
			response = services.launchAlexa(request);
		else if ("IntentRequest".equalsIgnoreCase(requestType)) {
			response = services.intentRequest(request);
		} else {
			response = services.endRequest(request);
		}

		return response;
	}

}
