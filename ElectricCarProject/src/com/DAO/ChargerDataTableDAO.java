package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.ChargerDataTableDTO;
import com.DTO.ChargerTypeTableDTO;
import com.Utils.DBUtil;

public class ChargerDataTableDAO {
	
	private static ChargerDataTableDAO instance;
	
	public static ChargerDataTableDAO getInstance(){
		if(instance == null){
			instance = new ChargerDataTableDAO();
		}
		return instance;
	}
	

	// CHARGER_DATA_TB에 Code 데이터 INSERT
	public int insertChargerData(ChargerDataTableDTO chargerData) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CHARGER_TYPE_TB VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setInt(2, chargerData.getCsCodeCdFk());
			pstmt.setInt(3, chargerData.getCpUniqueNo());
			pstmt.setInt(4, chargerData.getCpNameCdFk());
			pstmt.setInt(5, chargerData.getCpStatCdFk());
			pstmt.setInt(6, chargerData.getCpTypeCdFk());
			pstmt.setInt(7, chargerData.getChargerTypeCdFk());
			pstmt.setInt(8, chargerData.getCityLowNoFk());
			pstmt.setString(9, chargerData.getStatUpdateDatetimeDt());
			pstmt.setDouble(10, chargerData.getLat());
			pstmt.setDouble(11, chargerData.getLongi());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertChargerData INSERT중 에러 발생!");
			throw new Exception("insertChargerData INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// CHARGER_DATA_TB에 Code 데이터 DELETE
	public int deleteChargerData(int chargerDataNoPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CHARGER_DATA_TB WHERE CHARGER_DATA_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, chargerDataNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteChargerData DELETE중 에러 발생!");
			throw new Exception("deleteChargerData DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CHARGER_DATA_TB에 Code 데이터 UPDATE
	public int updateChargerData(ChargerDataTableDTO chargerData) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "뭐를 수정할지 정해야함";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			/* update 할 것들 작성.*/
			
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateChargerType UPDATE중 에러 발생!");
			throw new Exception("updateChargerType UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	// CHARGER_DATA_TB PK의 최대값 반환
	public int getMaxNo() throws Exception{
		return CommonDAO.getMaxNo("SELECT (MAX(CHARGER_NO_PK)+1) AS max_NO FROM CHARGER_DATA_TB");
	}

}