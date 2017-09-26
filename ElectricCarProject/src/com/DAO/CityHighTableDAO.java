package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.CityHighTableDTO;
import com.DTO.CityLowTableDTO;
import com.Utils.DBUtil;

public class CityHighTableDAO {

	private static CityHighTableDAO instance;

	public static CityHighTableDAO getInstance() {
		if (instance == null) {
			instance = new CityHighTableDAO();
		}
		return instance;
	}
	

	// CITY_HIGH_TB에 Code 데이터 INSERT
	public int insertCityHigh(CityHighTableDTO cityHigh) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CITY_HIGH_TB VALUES ( ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, cityHigh.getCityHighNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCityHigh INSERT중 에러 발생!");
			throw new Exception("insertCityHigh INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}
	

	// CITY_HIGH_TB에 Code 데이터 DELETE
	public int deleteCityHigh(int cityHighNoPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CITY_HIGH_TB WHERE CITY_HIGH_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cityHighNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCityHigh DELETE중 에러 발생!");
			throw new Exception("deleteCityHigh DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	
	// CITY_HIGH_TB에 Code 데이터 UPDATE
	public int updateCityHigh(CityHighTableDTO cityHigh) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CITY_HIGH_TB SET CITY_HIGH_NM = ? WHERE CITY_HIGH_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cityHigh.getCityHighNm());
			pstmt.setInt(2, cityHigh.getCityHighNoPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateCityHigh UPDATE중 에러 발생!");
			throw new Exception("updateCityHigh UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	
	// CITY_HIGH_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(city_High_NO_PK)+1) AS max_NO FROM CITY_HIGH_TB");
	}
}