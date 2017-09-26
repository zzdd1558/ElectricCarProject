package com.DTO;

public class CityHighTableDTO {

	private int cityHighNoPk; // city_High_NO_PK
	private String cityHighNm;// city_High_NM
	
	
	//기본 생성자
	public CityHighTableDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CityHighTableDTO(int cityHighNoPk, String cityHighNm) {
		super();
		this.cityHighNoPk = cityHighNoPk;
		this.cityHighNm = cityHighNm;
	}


	// setter / getter
	
	public int getCityHighNoPk() {
		return cityHighNoPk;
	}

	public void setCityHighNoPk(int cityHighNoPk) {
		this.cityHighNoPk = cityHighNoPk;
	}

	public String getCityHighNm() {
		return cityHighNm;
	}

	public void setCityHighNm(String cityHighNm) {
		this.cityHighNm = cityHighNm;
	}
}
