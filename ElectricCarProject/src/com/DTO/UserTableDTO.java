package com.DTO;

public class UserTableDTO {
	private int userNoPk;			// user_NO_PK
	private String userId;			// user_ID
	private String userPassword;	// user_Password
	private String userNm;			// user_NM
	private String userPhoneNo;		// user_Phone_NO
	private String userSaltKey;		// user_Salt_Key
	private int managerCdFk;		// manager_CD_FK
	private int cityMiddleNoFk;		// city_Middle_NO_FK
	
	// 기본 생성자
	public UserTableDTO() {
		// TODO Auto-generated constructor stub
	}

	public UserTableDTO(int userNoPk, String userId, String userPassword, String userNm, String userPhoneNo,
			String userSaltKey, int managerCdFk, int cityMiddleNoFk) {
		super();
		this.userNoPk = userNoPk;
		this.userId = userId;
		this.userPassword = userPassword;
		this.userNm = userNm;
		this.userPhoneNo = userPhoneNo;
		this.userSaltKey = userSaltKey;
		this.managerCdFk = managerCdFk;
		this.cityMiddleNoFk = cityMiddleNoFk;
	}

	// setter / getter 
	public int getUserNoPk() {
		return userNoPk;
	}


	public void setUserNoPk(int userNoPk) {
		this.userNoPk = userNoPk;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserPassword() {
		return userPassword;
	}


	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}


	public String getUserNm() {
		return userNm;
	}


	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}


	public String getUserPhoneNo() {
		return userPhoneNo;
	}


	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}


	public String getUserSaltKey() {
		return userSaltKey;
	}


	public void setUserSaltKey(String userSaltKey) {
		this.userSaltKey = userSaltKey;
	}


	public int getManagerCdFk() {
		return managerCdFk;
	}


	public void setManagerCdFk(int managerCdFk) {
		this.managerCdFk = managerCdFk;
	}

	public int getCityMiddleNoFk() {
		return cityMiddleNoFk;
	}

	public void setCityMiddleNoFk(int cityMiddleNoFk) {
		this.cityMiddleNoFk = cityMiddleNoFk;
	}
	
	
}
