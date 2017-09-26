package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.DTO.FavoritesTableDTO;
import com.DTO.ManagerCodeTableDTO;
import com.Utils.DBUtil;

public class FavoritesTableDAO {

	private static FavoritesTableDAO instance;

	public static FavoritesTableDAO getInstance() {
		if (instance == null) {
			instance = new FavoritesTableDAO();
		}
		return instance;
	}

	// FAVORITES_TB에 Code 데이터 INSERT
	public int insertFavorite(FavoritesTableDTO favorite) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO FAVORITES_TB VALUES ( ? , ? , ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setInt(2, favorite.getUserNoFk());
			pstmt.setInt(3, favorite.getCityLowNoFk());
			pstmt.setString(4, favorite.getFavoriteScore());

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertFavorite INSERT중 에러 발생!");
			throw new Exception("insertFavorite INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// FAVORITES_TB에 Code 데이터 DELETE
	public int insertFavorite(int favoriteNoPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM FAVORITES_TB WHERE FAVORITE_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, favoriteNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertFavorite DELETE중 에러 발생!");
			throw new Exception("insertFavorite DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// FAVORITES_TB에 Code 데이터 UPDATE
	public int updateFavorite(FavoritesTableDTO favorite) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "UPDATE FAVORITES_TB SET FAVORITE_SCORE = ? WHERE FAVORITE_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, favorite.getFavoriteScore());
			pstmt.setInt(2, favorite.getFavoriteNoPk());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertFavorite UPDATE중 에러 발생!");
			throw new Exception("insertFavorite UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// FAVORITES_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(FAVORITE_NO_PK)+1) AS max_NO FROM FAVORITES_TB");
	}
}