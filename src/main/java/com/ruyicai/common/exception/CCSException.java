package com.ruyicai.common.exception;

public class CCSException extends Exception{
	
	private static final long serialVersionUID = -6215220568809692780L;
	
	private String data = null;
	private String[] arguments;
	private String resultCode;
	public String getData() {
		return data==null?"":data;
	}

	public void setData(String data) {
		this.data = data;
	}
	public String getResultCode() {
		return resultCode;
	}
	/*
	 * public String getMessage() { return message; }
	 * 
	 * public void setMessage(String message) { this.message = message; }
	 */
	public String[] getFields() {
		return arguments;
	}

	public CCSException(String errorCode){
		super(errorCode);
		this.resultCode = errorCode;
	}
	
	public CCSException(String errorCode, Throwable rootException){		
		super(errorCode, rootException);
	}
	public CCSException(String errorCode, String[] fields) {
		this.resultCode = errorCode;
		this.arguments = fields;
	}
	public CCSException(String errorCode, String data) {
		this.resultCode = errorCode;
		this.data = data;
	}
	
}
