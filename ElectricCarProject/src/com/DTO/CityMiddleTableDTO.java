package com.DTO;

public class CityMiddleTableDTO {

	private int cityMiddleNoPk; // city_Middle_NO_PK
	private int cityHighNoFk; // city_High_NO_FK
	private String cityMiddleNm; // city_Middle_NM
	
	
	//기본 생성자
	
	public CityMiddleTableDTO() {
		// TODO Auto-generated constructor stub
	}

	public CityMiddleTableDTO(int cityMiddleNoPk, int cityHighNoFk, String cityMiddleNm) {
		super();
		this.cityMiddleNoPk = cityMiddleNoPk;
		this.cityHighNoFk = cityHighNoFk;
		this.cityMiddleNm = cityMiddleNm;
	}

	
	//setter / getter
	
	public int getCityMiddleNoPk() {
		return cityMiddleNoPk;
	}

	public void setCityMiddleNoPk(int cityMiddleNoPk) {
		this.cityMiddleNoPk = cityMiddleNoPk;
	}

	public int getCityHighNoFk() {
		return cityHighNoFk;
	}

	public void setCityHighNoFk(int cityHighNoFk) {
		this.cityHighNoFk = cityHighNoFk;
	}

	public String getCityMiddleNm() {
		return cityMiddleNm;
	}

	public void setCityMiddleNm(String cityMiddleNm) {
		this.cityMiddleNm = cityMiddleNm;
	}
}
