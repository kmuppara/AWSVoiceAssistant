package org.mart.response;

public class Directive {

	private String type = "Dialog.Delegate";

	public Directive(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
