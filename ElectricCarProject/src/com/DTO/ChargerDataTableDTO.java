package com.DTO;

public class ChargerDataTableDTO {
	
	private int chargerNoPk; 	// charger_NO_PK
	private int csCodeCdFk; 	// cs_Code_CD_FK
	private int cpUniqueNo; 	// cp_unique_NO
	private int cpNameCdFk;		// cp_Name_CD_FK
	private int cpStatCdFk;		// cp_Stat_CD_FK
	private int cpTypeCdFk;		// cp_Type_CD_FK
	private int chargerTypeCdFk;// charger_Type_CD_FK
	private int cityLowNoFk;	// city_Low_NO_FK
	private String statUpdateDatetimeDt; //stat_Update_Datetime_DT
	private double lat;
	private double longi;
	
	
	//기본 생성자
	public ChargerDataTableDTO() {
		// TODO Auto-generated constructor stub
	}

	public ChargerDataTableDTO(int chargerNoPk, int csCodeCdFk, int cpUniqueNo, int cpNameCdFk, int cpStatCdFk,
			int cpTypeCdFk, int chargerTypeCdFk, int cityLowNoFk, String statUpdateDatetimeDt, double lat,
			double longi) {
		super();
		this.chargerNoPk = chargerNoPk;
		this.csCodeCdFk = csCodeCdFk;
		this.cpUniqueNo = cpUniqueNo;
		this.cpNameCdFk = cpNameCdFk;
		this.cpStatCdFk = cpStatCdFk;
		this.cpTypeCdFk = cpTypeCdFk;
		this.chargerTypeCdFk = chargerTypeCdFk;
		this.cityLowNoFk = cityLowNoFk;
		this.statUpdateDatetimeDt = statUpdateDatetimeDt;
		this.lat = lat;
		this.longi = longi;
	}

	
	// setter / getter
	public int getChargerNoPk() {
		return chargerNoPk;
	}

	public void setChargerNoPk(int chargerNoPk) {
		this.chargerNoPk = chargerNoPk;
	}

	public int getCsCodeCdFk() {
		return csCodeCdFk;
	}

	public void setCsCodeCdFk(int csCodeCdFk) {
		this.csCodeCdFk = csCodeCdFk;
	}

	public int getCpUniqueNo() {
		return cpUniqueNo;
	}

	public void setCpUniqueNo(int cpUniqueNo) {
		this.cpUniqueNo = cpUniqueNo;
	}

	public int getCpNameCdFk() {
		return cpNameCdFk;
	}

	public void setCpNameCdFk(int cpNameCdFk) {
		this.cpNameCdFk = cpNameCdFk;
	}

	public int getCpStatCdFk() {
		return cpStatCdFk;
	}

	public void setCpStatCdFk(int cpStatCdFk) {
		this.cpStatCdFk = cpStatCdFk;
	}

	public int getCpTypeCdFk() {
		return cpTypeCdFk;
	}

	public void setCpTypeCdFk(int cpTypeCdFk) {
		this.cpTypeCdFk = cpTypeCdFk;
	}

	public int getChargerTypeCdFk() {
		return chargerTypeCdFk;
	}

	public void setChargerTypeCdFk(int chargerTypeCdFk) {
		this.chargerTypeCdFk = chargerTypeCdFk;
	}

	public int getCityLowNoFk() {
		return cityLowNoFk;
	}

	public void setCityLowNoFk(int cityLowNoFk) {
		this.cityLowNoFk = cityLowNoFk;
	}

	public String getStatUpdateDatetimeDt() {
		return statUpdateDatetimeDt;
	}

	public void setStatUpdateDatetimeDt(String statUpdateDatetimeDt) {
		this.statUpdateDatetimeDt = statUpdateDatetimeDt;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLongi() {
		return longi;
	}

	public void setLongi(double longi) {
		this.longi = longi;
	}
}
