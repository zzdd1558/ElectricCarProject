package com.DAO;

public class ChargerTypeTableDAO{

	public int getMaxNo() throws Exception{
		return CommonDAO.getMaxNo("SELECT (MAX(charger_Type_CD_PK)+1) AS max_NO FROM CHARGER_TYPE_TB");
	}
}