package com.DAO;

public class CityMiddleTableDAO {

	
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(city_Middle_NO_PK)+1) AS max_NO FROM CITY_MIDDLE_TB");
	}
}