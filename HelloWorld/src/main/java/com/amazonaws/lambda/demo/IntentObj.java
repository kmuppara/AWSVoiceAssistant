package com.amazonaws.lambda.demo;

public class IntentObj {

	OutputSpeech outputSpeech;

	public IntentObj(OutputSpeech outputSpeech) {
		super();
		this.outputSpeech = outputSpeech;
	}

	public OutputSpeech getOutputSpeech() {
		return outputSpeech;
	}

	public void setOutputSpeech(OutputSpeech outputSpeech) {
		this.outputSpeech = outputSpeech;
	}
	
}

	
