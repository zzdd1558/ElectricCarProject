package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Utils.DBUtil;

public class CommonDAO{
	
	public static int getMaxNo(String sql) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int cnt = 0;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				cnt = rset.getInt(1);
			}
			
			if(cnt == 0){
				cnt = 1;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new Exception("정보를 가져오는도중 에러가 발생하였습니다.");
		} finally {
			DBUtil.close(con, pstmt, rset);
		}

		return cnt;
	}
}
