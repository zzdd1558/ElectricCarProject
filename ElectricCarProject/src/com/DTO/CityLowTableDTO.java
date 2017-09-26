package com.DTO;

public class CityLowTableDTO {
	private int cityLowNoPk;	// city_Low_NO_PK
	private int cityMiddleNoFk; // city_Middle_NO_fK
	private String cityLowNm; 	// city_Low_NM
	
	
	//기본 생성자
	
	public CityLowTableDTO() {
		// TODO Auto-generated constructor stub
	}


	public CityLowTableDTO(int cityLowNoPk, int cityMiddleNoFk, String cityLowNm) {
		super();
		this.cityLowNoPk = cityLowNoPk;
		this.cityMiddleNoFk = cityMiddleNoFk;
		this.cityLowNm = cityLowNm;
	}

	
	// setter / getter

	public int getCityLowNoPk() {
		return cityLowNoPk;
	}


	public void setCityLowNoPk(int cityLowNoPk) {
		this.cityLowNoPk = cityLowNoPk;
	}


	public int getCityMiddleNoFk() {
		return cityMiddleNoFk;
	}


	public void setCityMiddleNoFk(int cityMiddleNoFk) {
		this.cityMiddleNoFk = cityMiddleNoFk;
	}


	public String getCityLowNm() {
		return cityLowNm;
	}


	public void setCityLowNm(String cityLowNm) {
		this.cityLowNm = cityLowNm;
	}
}
