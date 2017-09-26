package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.CpStatTableDTO;
import com.DTO.CpTypeTableDTO;
import com.Utils.DBUtil;

public class CpStatTableDAO {

	private static CpStatTableDAO instance;

	public static CpStatTableDAO getInstance() {
		if (instance == null) {
			instance = new CpStatTableDAO();
		}
		return instance;
	}
	
	// CP_STAT_TB에 Code 데이터 INSERT
	public int insertCpStat(CpStatTableDTO cpStat) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CP_STAT_TB VALUES ( ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, cpStat.getCpStatNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCpStat INSERT중 에러 발생!");
			throw new Exception("insertCpStat INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}
	

	// CP_STAT_TB에 Code 데이터 DELETE
	public int deleteCpStat(int cpStatCdPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CP_STAT_TB WHERE CP_STAT_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cpStatCdPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCpStat DELETE중 에러 발생!");
			throw new Exception("deleteCpStat DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	
	// CP_STAT_TB에 Code 데이터 UPDATE
	public int updateCpStat(CpStatTableDTO cpStat) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CP_STAT_TB SET CP_STAT_NM = ? WHERE CP_STAT_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpStat.getCpStatNm());
			pstmt.setInt(2, cpStat.getCpStatCdPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateCpStat UPDATE중 에러 발생!");
			throw new Exception("updateCpStat UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	
	// CP_STAT_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(CP_STAT_CD_PK)+1) AS max_NO FROM CP_STAT_TB");
	}
	
}