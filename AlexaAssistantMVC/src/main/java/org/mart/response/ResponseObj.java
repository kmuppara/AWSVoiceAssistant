package org.mart.response;

public class ResponseObj {
	
	IntentObj response;

	public ResponseObj(IntentObj response) {
		this.response = response;
	}

	public IntentObj getResponse() {
		return response;
	}

	public void setResponse(IntentObj response) {
		this.response = response;
	}

}
