package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.DTO.CityHighTableDTO;
import com.DTO.CityMiddleTableDTO;
import com.DTO.CpNameTableDTO;
import com.Utils.DBUtil;

public class CityMiddleTableDAO {

	private static CityMiddleTableDAO instance;

	public static CityMiddleTableDAO getInstance() {
		if (instance == null) {
			instance = new CityMiddleTableDAO();
		}
		return instance;
	}
	

	// CITY_MIDDLE_TB에 Code 데이터 INSERT
	public int insertCityMiddle(CityMiddleTableDTO cityMiddle) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CITY_MIDDLE_TB VALUES ( ? , ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setInt(2, cityMiddle.getCityHighNoFk());
			pstmt.setString(3, cityMiddle.getCityMiddleNm());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertCityMiddle INSERT중 에러 발생!");
			throw new Exception("insertCityMiddle INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}
	

	// CITY_MIDDLE_TB에 Code 데이터 DELETE
	public int deleteCityMiddle(int cityMiddleNoPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CITY_MIDDLE_TB WHERE CITY_MIDDLE_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, cityMiddleNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteCityMiddle DELETE중 에러 발생!");
			throw new Exception("deleteCityMiddle DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	
	// CITY_MIDDLE_TB에 Code 데이터 UPDATE
	public int updateCityMiddle(CityMiddleTableDTO cityMiddle) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE CITY_MIDDLE_TB SET CITY_MIDDLE_NM = ? WHERE CITY_MIDDLE_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, cityMiddle.getCityMiddleNm());
			pstmt.setInt(2, cityMiddle.getCityMiddleNoPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateCityMiddle UPDATE중 에러 발생!");
			throw new Exception("updateCityMiddle UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}
	
	
	public List<CityMiddleTableDTO> getCityMiddleList(int selected) throws Exception{
		List<CityMiddleTableDTO> list = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM CITY_Middle_TB WHERE CITY_HIGH_NO_FK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, selected);
			rset = pstmt.executeQuery();
			list = new ArrayList<>();
			
			while(rset.next()){
				list.add(new CityMiddleTableDTO(rset.getInt(1), rset.getInt(2) , rset.getString(3)));
			}

		} catch (Exception e) {
			System.out.println("CityMiddle List를 가져오는 중 에러 발생!");
			throw new Exception("CityMiddle List를 가져오는 중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
		
	}
	
	// CITY_MIDDLE_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(city_Middle_NO_PK)+1) AS max_NO FROM CITY_MIDDLE_TB");
	}
}