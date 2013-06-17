package com.ruyicai.security;

import org.springframework.security.core.AuthenticationException;

public class MaxTryLoginException extends AuthenticationException {
	private String data = null;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public MaxTryLoginException(String errorCode) {
		super(errorCode);
	}
}
