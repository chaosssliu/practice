package org.test.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String erroeMessage;
	private int errorCode;
	private String documentation;
	
	public ErrorMessage() {
		
	}
	
	public ErrorMessage(String erroeMessage, int errorCode, String documentation) {
		super();
		this.erroeMessage = erroeMessage;
		this.errorCode = errorCode;
		this.documentation = documentation;
	}
	
	public String getErroeMessage() {
		return erroeMessage;
	}
	public void setErroeMessage(String erroeMessage) {
		this.erroeMessage = erroeMessage;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getDocumentation() {
		return documentation;
	}
	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}
	
	
}
