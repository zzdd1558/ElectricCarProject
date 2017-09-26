package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.ManagerCodeTableDTO;
import com.Utils.DBUtil;

public class ManagerCodeTableDAO {

	private static ManagerCodeTableDAO instance;

	public static ManagerCodeTableDAO getInstance() {
		if (instance == null) {
			instance = new ManagerCodeTableDAO();
		}
		return instance;
	}

	// MANAGER_CODE_TB에 Code 데이터 INSERT
	public int insertManagerCode(ManagerCodeTableDTO manager) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO MANAGER_CODE_TB VALUES ( ? , ? )";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, manager.getManagerNm());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ManagerCode INSERT중 에러 발생!");
			throw new Exception("ManagerCode INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// MANAGER_CODE_TB에 Code 데이터 DELETE
	public int deleteManagerCode(int managerCdPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM MANAGER_CODE_TB WHERE MANAGER_CD_PK = ?";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, managerCdPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("ManagerCode DELETE중 에러 발생!");
			throw new Exception("ManagerCode DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	// MANAGER_CODE_TB에 Code 데이터Update
		public int updateManagerCode(ManagerCodeTableDTO manager) throws Exception {

			Connection con = null;
			PreparedStatement pstmt = null;
			int cnt = 0;
			String sql = "UPDATE MANAGER_CODE_TB SET MANAGER_NM = ? WHERE MANAGER_CD_PK = ?";

			try {

				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, manager.getManagerNm());
				pstmt.setInt(2, manager.getManagerCdPk());
				cnt = pstmt.executeUpdate();

			} catch (Exception e) {
				System.out.println("ManagerCode UPDATE중 에러 발생!");
				throw new Exception("ManagerCode UPDATE중 에러 발생!");
			} finally {
				DBUtil.close(con, pstmt);
			}
			return cnt;
		}

	// MANAGER_CODE_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(MANAGER_CD_PK)+1) AS max_NO FROM MANAGER_CODE_TB");
	}
}