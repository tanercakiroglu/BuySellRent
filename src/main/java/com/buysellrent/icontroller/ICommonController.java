package com.buysellrent.icontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buysellrent.DTO.Country;
import com.buysellrent.exception.BussinesException;

public interface ICommonController {
	
	 @RequestMapping(value="/getAllCountries",method = RequestMethod.GET)
	 public @ResponseBody String getAllCountries() throws BussinesException;
	 
	 @RequestMapping(value="/getCountry/{countryCode}",method = RequestMethod.GET)
	 public @ResponseBody String getAllCountries(String countryCode) throws BussinesException;
	 
	 @RequestMapping(value="/insertCountry",method = RequestMethod.POST)
	 public @ResponseBody String insertCountry(Country country) throws BussinesException;

}
