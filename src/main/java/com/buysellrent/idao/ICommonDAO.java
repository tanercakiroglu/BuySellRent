package com.buysellrent.idao;

import java.util.List;

import com.buysellrent.DTO.Country;

public interface ICommonDAO {

	public List<Country> getAllCountries() ;
	public List<Country> getCountry(String countryCode) ;
	public int insertCountry(Country country) ;
}
