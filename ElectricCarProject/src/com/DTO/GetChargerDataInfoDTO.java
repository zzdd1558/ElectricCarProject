package com.DTO;

public class GetChargerDataInfoDTO {
	private int chargerDataNoPk; 	// CHARGER_DATA_NO_PK
	private String cityHighNm;		// CITY_HIGH_NM
	private String cityMiddleNm;	// CITY_MIDDLE_NM
	private String cityLowNm;		// CITY_LOW_NM
	private String csCodeNm;		// CS_CODE_NM
	private String cpNameNm;		// CP_NAME_NM
	private String cpStatNm;		// CP_STAT_NM
	private String chargerTypeNm;	// CHARGER_TYPE_NM
	private String cpTypeNm;		// CP_TYPE_NM
	private double lat;				// LAT
	private double longi;			// LONGI
	
	//기본 생성자
	public GetChargerDataInfoDTO() {
		// TODO Auto-generated constructor stub
	}

	public GetChargerDataInfoDTO(int chargerDataNoPk, String cityHighNm, String cityMiddleNm, String cityLowNm,
			String csCodeNm, String cpNameNm, String cpStatNm, String chargerTypeNm, String cpTypeNm, double lat,
			double longi) {
		super();
		this.chargerDataNoPk = chargerDataNoPk;
		this.cityHighNm = cityHighNm;
		this.cityMiddleNm = cityMiddleNm;
		this.cityLowNm = cityLowNm;
		this.csCodeNm = csCodeNm;
		this.cpNameNm = cpNameNm;
		this.cpStatNm = cpStatNm;
		this.chargerTypeNm = chargerTypeNm;
		this.cpTypeNm = cpTypeNm;
		this.lat = lat;
		this.longi = longi;
	}

	
	// setter / getter
	public int getChargerDataNoPk() {
		return chargerDataNoPk;
	}

	public void setChargerDataNoPk(int chargerDataNoPk) {
		this.chargerDataNoPk = chargerDataNoPk;
	}

	public String getCityHighNm() {
		return cityHighNm;
	}

	public void setCityHighNm(String cityHighNm) {
		this.cityHighNm = cityHighNm;
	}

	public String getCityMiddleNm() {
		return cityMiddleNm;
	}

	public void setCityMiddleNm(String cityMiddleNm) {
		this.cityMiddleNm = cityMiddleNm;
	}

	public String getCityLowNm() {
		return cityLowNm;
	}

	public void setCityLowNm(String cityLowNm) {
		this.cityLowNm = cityLowNm;
	}

	public String getCsCodeNm() {
		return csCodeNm;
	}

	public void setCsCodeNm(String csCodeNm) {
		this.csCodeNm = csCodeNm;
	}

	public String getCpNameNm() {
		return cpNameNm;
	}

	public void setCpNameNm(String cpNameNm) {
		this.cpNameNm = cpNameNm;
	}

	public String getCpStatNm() {
		return cpStatNm;
	}

	public void setCpStatNm(String cpStatNm) {
		this.cpStatNm = cpStatNm;
	}

	public String getChargerTypeNm() {
		return chargerTypeNm;
	}

	public void setChargerTypeNm(String chargerTypeNm) {
		this.chargerTypeNm = chargerTypeNm;
	}

	public String getCpTypeNm() {
		return cpTypeNm;
	}

	public void setCpTypeNm(String cpTypeNm) {
		this.cpTypeNm = cpTypeNm;
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
