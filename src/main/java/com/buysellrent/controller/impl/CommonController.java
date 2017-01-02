package com.buysellrent.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.buysellrent.DTO.Country;
import com.buysellrent.aspect.exceptionhandler.HandleException;
import com.buysellrent.aspect.logger.Loggable;
import com.buysellrent.exception.BussinesException;
import com.buysellrent.icontroller.ICommonController;
import com.buysellrent.iservice.ICommonService;
import com.buysellrent.util.Constants;
import com.buysellrent.util.Util;

@RestController
public class CommonController implements ICommonController {

	
	 @Autowired
	 private ICommonService commonService;
	 
	 
	 

	@HandleException
	@Loggable
	@Override
	public String getAllCountries() throws BussinesException {
		return Util.constructJSON(commonService.getAllCountries());
	}

	@HandleException
	@Loggable
	@Override
	public String getAllCountries(@PathVariable String countryCode) throws BussinesException {
		return Util.constructJSON(commonService.getCountry(countryCode));
	}

	@HandleException
	@Loggable
	@Override
	public String insertCountry(Country country) throws BussinesException {
		if (country == null || Util.isNullOREmpty(country.getCode()) || Util.isNullOREmpty(country.getName())
				|| Util.isNullOREmpty(country.getPhoneCode()) || !Util.isNullOREmpty(country.getTripleCode()))
			throw new BussinesException(Constants.INVALID_PARAMETERS);
		return Util.constructJSON(commonService.insertCountry(country));
	}
}