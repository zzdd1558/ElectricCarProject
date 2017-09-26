package com.DTO;

public class ChargerTypeTableDTO {
	
	private int chargerTypeCdPk; // charger_Type_CD_PK
	private String chargerTypeNm; // charger_Type_NM
	
	
	// 기본 생성자
	public ChargerTypeTableDTO() {
		// TODO Auto-generated constructor stub
	}


	public ChargerTypeTableDTO(int chargerTypeCdPk, String chargerTypeNm) {
		super();
		this.chargerTypeCdPk = chargerTypeCdPk;
		this.chargerTypeNm = chargerTypeNm;
	}


	// setter / getter
	public int getChargerTypeCdPk() {
		return chargerTypeCdPk;
	}


	public void setChargerTypeCdPk(int chargerTypeCdPk) {
		this.chargerTypeCdPk = chargerTypeCdPk;
	}


	public String getChargerTypeNm() {
		return chargerTypeNm;
	}


	public void setChargerTypeNm(String chargerTypeNm) {
		this.chargerTypeNm = chargerTypeNm;
	}
	
	
	
	
}
