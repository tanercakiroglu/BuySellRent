package com.buysellrent.domain.response;

public class ErrorResponse extends BaseResponse {
		public ErrorResponse(String tag, boolean status) {
		super(tag, status);
		// TODO Auto-generated constructor stub
	}

		private Object error ;

		public Object getError() {
			return error;
		}

		public void setError(Object error) {
			this.error = error;
		}
		
}
