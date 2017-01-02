package com.buysellrent.idao;

import com.buysellrent.DTO.User;

public interface IUserDAO {
	
	/**
	 * @comment database query
	 * @param credential
	 * @return
	 */
	public boolean checkCredential(User credential);


}
