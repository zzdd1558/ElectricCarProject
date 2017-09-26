package com.DTO;

public class FavoritesTableDTO {
	
	private int favoriteNoPk;		// favorite_NO_PK
	private int userNoFk;			// user_NO_FK
	private int cityLowNoFk;		// city_Low_NO_FK
	private String favoriteScore;	// favorite_Score
	
	
	// 기본 생성자
	public FavoritesTableDTO() {
		// TODO Auto-generated constructor stub
	}

	public FavoritesTableDTO(int favoriteNoPk, int userNoFk, int cityLowNoFk, String favoriteScore) {
		super();
		this.favoriteNoPk = favoriteNoPk;
		this.userNoFk = userNoFk;
		this.cityLowNoFk = cityLowNoFk;
		this.favoriteScore = favoriteScore;
	}
	
	
	// setter / getter
	public int getFavoriteNoPk() {
		return favoriteNoPk;
	}

	public void setFavoriteNoPk(int favoriteNoPk) {
		this.favoriteNoPk = favoriteNoPk;
	}

	public int getUserNoFk() {
		return userNoFk;
	}

	public void setUserNoFk(int userNoFk) {
		this.userNoFk = userNoFk;
	}

	public int getCityLowNoFk() {
		return cityLowNoFk;
	}

	public void setCityLowNoFk(int cityLowNoFk) {
		this.cityLowNoFk = cityLowNoFk;
	}

	public String getFavoriteScore() {
		return favoriteScore;
	}

	public void setFavoriteScore(String favoriteScore) {
		this.favoriteScore = favoriteScore;
	}
}
