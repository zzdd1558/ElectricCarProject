package com.DTO;

public class CsCodeTableDTO {
	
	private int csCodeCdPk;  // cs_Code_CD_PK
	private String csCodeNm;	// cs_Code_NM
	
	//기본 생성자
	public CsCodeTableDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CsCodeTableDTO(int csCodeCdPk, String csCodeNm) {
		super();
		this.csCodeCdPk = csCodeCdPk;
		this.csCodeNm = csCodeNm;
	}
	
	// setter / getter
	
	public int getCsCodeCdPk() {
		return csCodeCdPk;
	}
	public void setCsCodeCdPk(int csCodeCdPk) {
		this.csCodeCdPk = csCodeCdPk;
	}
	public String getCsCodeNm() {
		return csCodeNm;
	}
	public void setCsCodeNm(String csCodeNm) {
		this.csCodeNm = csCodeNm;
	}
	
	
}
