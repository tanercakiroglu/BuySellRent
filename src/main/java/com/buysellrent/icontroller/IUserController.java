package com.buysellrent.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buysellrent.DTO.User;
import com.buysellrent.exception.BussinesException;

public interface IUserController {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody String checkCredentail(User credential) throws BussinesException;

}
