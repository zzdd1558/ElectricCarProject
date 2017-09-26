package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.CpTypeTableDTO;
import com.DTO.CsCodeTableDTO;
import com.Utils.DBUtil;

public class CpTypeTableDAO {

	private static CpTypeTableDAO instance;

	public static CpTypeTableDAO getInstance() {
		if (instance == null) {
			instance = new CpTypeTableDAO();
		}
		return instance;
	}
	

	// CP_TYPE_TB에 Code 데이터 INSERT
	public int insertCpType(CpTypeTableDTO cpType) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CP_TYPE_TB VALUES ( ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, cpType.getCpTypeNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCpType INSERT중 에러 발생!");
			throw new Exception("insertCpType INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// CP_TYPE_TB에 Code 데이터 DELETE
	public int deleteCpType(int cpTypeCdPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CP_TYPE_TB WHERE CP_TYPE_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cpTypeCdPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCpType DELETE중 에러 발생!");
			throw new Exception("deleteCpType DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CP_TYPE_TB에 Code 데이터 UPDATE
	public int updateCpType(CpTypeTableDTO cpType) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CP_TYPE_TB SET CP_TYPE_NM = ? WHERE CP_TYPE_CD_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cpType.getCpTypeNm());
			pstmt.setInt(2, cpType.getCpTypeCdPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("setString UPDATE중 에러 발생!");
			throw new Exception("setString UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	// CP_TYPE_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(CP_TYPE_CD_PK)+1) AS max_NO FROM CP_TYPE_TB");
	}
	
	
}