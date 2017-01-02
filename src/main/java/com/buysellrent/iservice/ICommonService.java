package com.buysellrent.iservice;

import java.util.List;

import com.buysellrent.DTO.Country;


public interface ICommonService {

	
	public List<Country> getAllCountries() ;
	public List<Country> getCountry(String countryCode) ;
	public int insertCountry(Country country) ;
}
