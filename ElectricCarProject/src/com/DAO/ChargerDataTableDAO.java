package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.Utils.DBUtil;

public class ChargerDataTableDAO implements CommonDAO {

	@Override
	public void getMaxNo() {
		// TODO Auto-generated method stub
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement pstmt = con.prepareStatement("1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}