package com.DTO;

public class ManagerCodeTableDTO {
	
	private int managerCdPk; // manager_CD_PK
	private String managerNm; // manager_NM
	
	
	//기본 생성자
	public ManagerCodeTableDTO() {
		// TODO Auto-generated constructor stub
	}

	public ManagerCodeTableDTO(int managerCdPk, String managerNm) {
		super();
		this.managerCdPk = managerCdPk;
		this.managerNm = managerNm;
	}

	
	// setter / getter 
	public int getManagerCdPk() {
		return managerCdPk;
	}

	public void setManagerCdPk(int managerCdPk) {
		this.managerCdPk = managerCdPk;
	}

	public String getManagerNm() {
		return managerNm;
	}

	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}
	
	
	
}
