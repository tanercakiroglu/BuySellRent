package com.buysellrent.domain.response;

public class CheckCredentialResponse extends BaseResponse {

	private String token;
	
	

	

	public CheckCredentialResponse(String tag, boolean status, String token) {
		super(tag, status);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
