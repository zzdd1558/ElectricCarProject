package com.DTO;

public class CpStatTableDTO {
	
	private int cpStatCdPk; // cp_Stat_CD_PK
	private String cpStatNm; // cp_Stat_NM
	
	
	//기본 생성자
	public CpStatTableDTO() {
		// TODO Auto-generated constructor stub
	}


	public CpStatTableDTO(int cpStatCdPk, String cpStatNm) {
		super();
		this.cpStatCdPk = cpStatCdPk;
		this.cpStatNm = cpStatNm;
	}


	//setter / getter
	
	public int getCpStatCdPk() {
		return cpStatCdPk;
	}


	public void setCpStatCdPk(int cpStatCdPk) {
		this.cpStatCdPk = cpStatCdPk;
	}


	public String getCpStatNm() {
		return cpStatNm;
	}


	public void setCpStatNm(String cpStatNm) {
		this.cpStatNm = cpStatNm;
	}
}
