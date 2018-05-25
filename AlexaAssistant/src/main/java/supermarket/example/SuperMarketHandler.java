package supermarket.example;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SuperMarketHandler implements RequestHandler<Map<String, Object>, Object> {

	ResponseObj response = null;
	
	
    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
    	
    	Map<String, Object> request = (Map<String, Object>) input.get("request");
    	String requestType = (String)request.get("type");
    	Services services = new Services();
    	if("LaunchRequest".equalsIgnoreCase(requestType))
    		response = services.launchAlexa(request);
    	else if("IntentRequest".equalsIgnoreCase(requestType)){
    		response = services.intentRequest(request);
    	}
    	else{
    		response = services.endRequest(request);
    	}
    	
        return response;
    }

}
