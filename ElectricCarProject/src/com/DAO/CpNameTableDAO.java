package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.CpNameTableDTO;
import com.DTO.CpStatTableDTO;
import com.Utils.DBUtil;

public class CpNameTableDAO {

	private static CpNameTableDAO instance;

	public static CpNameTableDAO getInstance() {
		if (instance == null) {
			instance = new CpNameTableDAO();
		}
		return instance;
	}
	

	// CP_NAME_TB에 Code 데이터 INSERT
	public int insertCpName(CpNameTableDTO cpName) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CP_NAME_TB VALUES ( ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, cpName.getCpNameNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCpName INSERT중 에러 발생!");
			throw new Exception("insertCpName INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}
	

	// CP_NAME_TB에 Code 데이터 DELETE
	public int deleteCpName(int cpNameCdPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CP_NAME_TB WHERE CP_NAME_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cpNameCdPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCpName DELETE중 에러 발생!");
			throw new Exception("deleteCpName DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	
	// CP_NAME_TB에 Code 데이터 UPDATE
	public int updateCpStat(CpNameTableDTO cpName) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CP_NAME_TB SET CP_NAME_NM = ? WHERE CP_NAME_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpName.getCpNameNm());
			pstmt.setInt(2, cpName.getCpTypeCdPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateCpStat UPDATE중 에러 발생!");
			throw new Exception("updateCpStat UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	
	// CP_NAME_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(CP_NAME_CD_PK)+1) AS max_NO FROM CP_NAME_TB");
	}
}