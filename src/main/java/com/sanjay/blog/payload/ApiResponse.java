package com.sanjay.blog.payload;

public class ApiResponse {
	private String msg;
	private boolean success;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public ApiResponse(String msg, boolean success) {
		super();
		this.msg = msg;
		this.success = success;
	}
	
	
}
