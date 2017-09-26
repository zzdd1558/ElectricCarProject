package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.ChargerTypeTableDTO;
import com.DTO.CpTypeTableDTO;
import com.Utils.DBUtil;

public class ChargerTypeTableDAO {

	private static ChargerTypeTableDAO instance;

	public static ChargerTypeTableDAO getInstance() {
		if (instance == null) {
			instance = new ChargerTypeTableDAO();
		}
		return instance;
	}

	// CHARGER_TYPE_TB에 Code 데이터 INSERT
	public int insertChargerType(ChargerTypeTableDTO chargerType) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CHARGER_TYPE_TB VALUES ( ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, chargerType.getChargerTypeNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertChargerType INSERT중 에러 발생!");
			throw new Exception("insertChargerType INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// CHARGER_TYPE_TB에 Code 데이터 DELETE
	public int deleteChargerType(int chargerTypeCdPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CHARGER_TYPE_TB WHERE CHARGER_TYPE_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, chargerTypeCdPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteChargerType DELETE중 에러 발생!");
			throw new Exception("deleteChargerType DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CHARGER_TYPE_TB에 Code 데이터 UPDATE
	public int updateChargerType(ChargerTypeTableDTO chargerType) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CHARGER_TYPE_TB SET CHARGER_TYPE_NM = ? WHERE CHARGER_TYPE_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, chargerType.getChargerTypeNm());
			pstmt.setInt(2, chargerType.getChargerTypeCdPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateChargerType UPDATE중 에러 발생!");
			throw new Exception("updateChargerType UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CHARGER_TYPE_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(charger_Type_CD_PK)+1) AS max_NO FROM CHARGER_TYPE_TB");
	}
}