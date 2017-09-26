package com.DTO;

public class CpNameTableDTO {
	
	private int cpTypeCdPk; // cp_Type_CD_PK
	private String cpNameNm ;// cp_Name_NM
	
	
	//기본 생성자
	public CpNameTableDTO() {
		// TODO Auto-generated constructor stub
	}


	public CpNameTableDTO(int cpTypeCdPk, String cpNameNm) {
		super();
		this.cpTypeCdPk = cpTypeCdPk;
		this.cpNameNm = cpNameNm;
	}


	// setter / getter
	
	public int getCpTypeCdPk() {
		return cpTypeCdPk;
	}


	public void setCpTypeCdPk(int cpTypeCdPk) {
		this.cpTypeCdPk = cpTypeCdPk;
	}


	public String getCpNameNm() {
		return cpNameNm;
	}


	public void setCpNameNm(String cpNameNm) {
		this.cpNameNm = cpNameNm;
	}
	
	
	
}
