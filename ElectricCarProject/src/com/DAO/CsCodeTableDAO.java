package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.CsCodeTableDTO;
import com.Utils.DBUtil;

public class CsCodeTableDAO {

	private static CsCodeTableDAO instance;

	public static CsCodeTableDAO getInstance() {
		if (instance == null) {
			instance = new CsCodeTableDAO();
		}
		return instance;
	}

	// CS_CODE_TB에 Code 데이터 INSERT
	public int insertCsCode(CsCodeTableDTO csCode) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CS_CODE_TB VALUES ( ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, csCode.getCsCodeNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCsCode INSERT중 에러 발생!");
			throw new Exception("insertCsCode INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// CS_CODE_TB에 Code 데이터 DELETE
	public int deleteCsCode(int csCodeCdPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CS_CODE_TB WHERE CS_CODE_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, csCodeCdPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCsCode DELETE중 에러 발생!");
			throw new Exception("deleteCsCode DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CS_CODE_TB에 Code 데이터 UPDATE
	public int updateCsCode(CsCodeTableDTO csCode) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CS_CODE_TB SET CS_CODE_NM = ? WHERE CS_CODE_CD_Pk = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, csCode.getCsCodeCdPk());
			pstmt.setString(2, csCode.getCsCodeNm());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateCsCode UPDATE중 에러 발생!");
			throw new Exception("updateCsCode UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CS_CODE_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(CS_CODE_CD_PK)+1) AS max_NO FROM CS_CODE_TB");
	}
}