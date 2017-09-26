package com.DAO;

public class ChargerDataTableDAO {

	public int getMaxNo() throws Exception{
		return CommonDAO.getMaxNo("SELECT (MAX(CHARGER_NO_PK)+1) AS max_NO FROM CHARGER_DATA_TB");
	}

}