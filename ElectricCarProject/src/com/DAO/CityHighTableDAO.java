package com.DAO;


public class CityHighTableDAO{

	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(city_High_NO_PK)+1) AS max_NO FROM CITY_HIGH_TB");
	}
}