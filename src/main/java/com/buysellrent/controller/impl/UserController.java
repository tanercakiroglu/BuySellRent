package com.buysellrent.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.buysellrent.DTO.User;
import com.buysellrent.aspect.exceptionhandler.HandleException;
import com.buysellrent.aspect.logger.Loggable;
import com.buysellrent.domain.response.CheckCredentialResponse;
import com.buysellrent.exception.BussinesException;
import com.buysellrent.icontroller.IUserController;
import com.buysellrent.iservice.IUserService;
import com.buysellrent.util.Constants;
import com.buysellrent.util.Util;

@RestController
public class UserController implements IUserController {

	@Autowired
	private IUserService userService;

	@HandleException
	@Loggable
	@Override
	public String checkCredentail(@RequestBody User credential) throws BussinesException {
		if (credential == null || Util.isNullOREmpty(credential.getEmail())
				|| Util.isNullOREmpty(credential.getPassword()))
			throw new BussinesException(Constants.INVALID_PARAMETERS);
        CheckCredentialResponse response=userService.checkCredential(credential);
        if(response==null)
        	throw new BussinesException(Constants.CREDENTIAL_NOT_VALID);
        
		return Util.constructJSON(response);
	}

}
