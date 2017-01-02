package com.buysellrent.domain.response;

public abstract class BaseResponse {

	private String tag;
	private boolean status;
	
	
	
	public BaseResponse(String tag, boolean status) {
		super();
		this.tag = tag;
		this.status = status;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
