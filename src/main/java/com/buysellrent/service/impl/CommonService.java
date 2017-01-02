package com.buysellrent.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.buysellrent.DTO.Country;
import com.buysellrent.idao.ICommonDAO;
import com.buysellrent.iservice.ICommonService;


public class CommonService implements ICommonService {

	@Qualifier("commonDAO")
	@Autowired
	private ICommonDAO commonDAO;
	
	@Override
	public List<Country> getAllCountries() {
		return commonDAO.getAllCountries();
	}

	@Override
	public List<Country> getCountry(String countryCode) {
		return commonDAO.getCountry(countryCode);
	}

	@Override
	public int insertCountry(Country country) {
		return  commonDAO.insertCountry(country);
	}

}
