package com.buysellrent.iservice;

import com.buysellrent.DTO.User;
import com.buysellrent.domain.response.CheckCredentialResponse;

public interface IUserService {

	/**
	 * @comment implements bussines logic
	 * @param credential
	 * @return
	 */
	public CheckCredentialResponse checkCredential(User credential);
}
