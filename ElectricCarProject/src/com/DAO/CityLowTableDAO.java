package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.CityLowTableDTO;
import com.DTO.CityMiddleTableDTO;
import com.Utils.DBUtil;

public class CityLowTableDAO {

	private static CityLowTableDAO instance;

	public static CityLowTableDAO getInstance() {
		if (instance == null) {
			instance = new CityLowTableDAO();
		}
		return instance;
	}
	

	// CITY_LOW_TB에 Code 데이터 INSERT
	public int insertCityLow(CityLowTableDTO cityLow) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CITY_LOW_TB VALUES ( ? , ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setInt(2, cityLow.getCityMiddleNoFk());
			pstmt.setString(3, cityLow.getCityLowNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCityLow INSERT중 에러 발생!");
			throw new Exception("insertCityLow INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}
	

	// CITY_LOW_TB에 Code 데이터 DELETE
	public int deleteCityLow(int cityLowNoPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CITY_LOW_TB WHERE CITY_LOW_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cityLowNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCityLow DELETE중 에러 발생!");
			throw new Exception("deleteCityLow DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	
	// CITY_LOW_TB에 Code 데이터 UPDATE
	public int updateCityLow(CityLowTableDTO cityLow) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CITY_LOW_TB SET CITY_Low_NM = ? WHERE CITY_Low_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cityLow.getCityLowNm());
			pstmt.setInt(2, cityLow.getCityLowNoPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateCityLow UPDATE중 에러 발생!");
			throw new Exception("updateCityLow UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	
	// CITY_LOW_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(city_Low_NO_PK)+1) AS max_NO FROM CITY_LOW_TB");
	}
}