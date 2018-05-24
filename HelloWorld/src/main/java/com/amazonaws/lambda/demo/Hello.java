package com.amazonaws.lambda.demo;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Hello implements RequestHandler<Map<String, Object>, Object> {

    @Override
    public Object handleRequest(Map<String, Object> input, Context context) {
       // context.getLogger().log("Input: " + input);
    	Map<String, Object> request = (Map<String, Object>) input.get("request");
    	Map<String, Object> intentMap =  (Map<String, Object>)request.get("intent");
    	String name = (String)intentMap.get("name");
    	String confirmationStatus = (String)intentMap.get("confirmationStatus");
    	OutputSpeech ops = new  OutputSpeech("PlainText", "Welcome to d mart, How can i help you?");
    	ResponseObj response = new ResponseObj(new IntentObj(ops));
        return response;
    }
    
    /*public static void main(String[] args) {
    	OutputSpeech ops = new  OutputSpeech("PlainText", "Hello Guru..");
    	ResponseObj response = new ResponseObj(new IntentObj(ops));
        System.out.println(response);

    }*/

}
