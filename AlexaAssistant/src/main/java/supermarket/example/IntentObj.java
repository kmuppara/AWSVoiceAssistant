package supermarket.example;

import java.util.ArrayList;
import java.util.List;

public class IntentObj {

	OutputSpeech outputSpeech;
	@SuppressWarnings("unused")
	private String shouldEndSession = null;
	List<Directive> directives = null;

	public IntentObj(OutputSpeech outputSpeech) {
		super();
		this.outputSpeech = outputSpeech;
		this.shouldEndSession = "true";
		/*this.directives = new Directive("Dialog.Delegate");*/
	}

	public IntentObj(String dialogState) {
		super();
		this.shouldEndSession = "false";
		Directive d = new Directive("Dialog.Delegate");
		this.directives =  new ArrayList<>();
		this.directives.add(d);
	}

	public OutputSpeech getOutputSpeech() {
		return outputSpeech;
	}

	public void setOutputSpeech(OutputSpeech outputSpeech) {
		this.outputSpeech = outputSpeech;
	}

	public String getShouldEndSession() {
		return shouldEndSession;
	}

	public void setShouldEndSession(String shouldEndSession) {
		this.shouldEndSession = shouldEndSession;
	}

	public List<Directive> getDirectives() {
		return directives;
	}

	public void setDirectives(List<Directive> directives) {
		this.directives = directives;
	}

	

	
	
	
}
