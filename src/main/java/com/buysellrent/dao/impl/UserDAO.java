package com.buysellrent.dao.impl;

import com.buysellrent.DTO.User;
import com.buysellrent.base.dao.BaseJDBCDAO;
import com.buysellrent.idao.IUserDAO;

public class UserDAO extends BaseJDBCDAO implements IUserDAO {

	@Override
	public boolean checkCredential(User credential) {
		User userFromDB = new User();

		userFromDB.setFirstName("kb");
		userFromDB.setLastName("gc");
		userFromDB.setUsername("kb");
		userFromDB.setPassword("123*-+");
		userFromDB.setEmail("merchant@test.com");

		
		if (userFromDB.getEmail().equals(credential.getEmail())
				&& userFromDB.getPassword().equals(credential.getPassword()))
			return true;
		else {
			return false;
		}
	}

}
