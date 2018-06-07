package org.mart.bo;

import java.util.Map;

import org.mart.response.ResponseObj;

public interface IServices {

	ResponseObj launchAlexa(Map<String, Object> request);

	ResponseObj intentRequest(Map<String, Object> request);

	ResponseObj endRequest(Map<String, Object> request);

}