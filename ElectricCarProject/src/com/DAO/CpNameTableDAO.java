package com.DAO;

public class CpNameTableDAO {

	
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(city_Low_NO_PK)+1) AS max_NO FROM CITY_LOW_TB;");
	}
}