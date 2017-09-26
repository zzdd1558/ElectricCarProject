package com.DTO;

public class CpTypeTableDTO {
	
	private int cpTypeCdPk; // cp_Type_CD_PK
	private String cpTypeNm; // cp_Type_NM
	
	
	//기본 생성자
	public CpTypeTableDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CpTypeTableDTO(int cpTypeCdPk, String cpTypeNm) {
		super();
		this.cpTypeCdPk = cpTypeCdPk;
		this.cpTypeNm = cpTypeNm;
	}

	
	// settger / getter
	public int getCpTypeCdPk() {
		return cpTypeCdPk;
	}

	public void setCpTypeCdPk(int cpTypeCdPk) {
		this.cpTypeCdPk = cpTypeCdPk;
	}

	public String getCpTypeNm() {
		return cpTypeNm;
	}

	public void setCpTypeNm(String cpTypeNm) {
		this.cpTypeNm = cpTypeNm;
	}
}
