package com.ruyicai.common.exception;

public class CCSRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 6404868144627466435L;
	
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
	public CCSRuntimeException(String errorCode){
		super(errorCode);
	}
	
	public CCSRuntimeException(String errorCode,Throwable throwable){		
		super(errorCode,throwable);
	}
	public CCSRuntimeException(String errorCode, String[] fields) {
		this.resultCode = errorCode;
		this.arguments = fields;
	}
	public CCSRuntimeException(String errorCode, String data) {
		this.resultCode = errorCode;
		this.data = data;
	}
}
