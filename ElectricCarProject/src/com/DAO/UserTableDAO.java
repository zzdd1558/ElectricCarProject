package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.spi.DirStateFactory.Result;

import com.DTO.UserTableDTO;
import com.Utils.DBUtil;

public class UserTableDAO {

	private static UserTableDAO instance;

	public static UserTableDAO getInstance() {
		if (instance == null) {
			instance = new UserTableDAO();
		}
		return instance;
	}

	
	// 일반 유저 회원가입
	public int insertUser(UserTableDTO user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO USER_TB VALUES ( ? , ? , ? , ? , ? , ? , 1 , ? )";
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, getMaxNo());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setString(4, user.getUserNm());
			pstmt.setString(5, user.getUserPhoneNo());
			pstmt.setString(6, user.getUserSaltKey());
			pstmt.setInt(7, user.getCityMiddleNoFk());
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("회원가입중 에러 발생!");
			throw new Exception("회원가입중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// 일반 유저 삭제
	public int deleteUser(int userNoPk) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM USER_TB WHERE user_NO_PK = ?";
		int cnt = 0;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, userNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원 삭제중 에러 발생!");
			throw new Exception("회원가입중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// 일반 유저 수정
	public int updateUser(UserTableDTO user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update query 작성해야함";
		int cnt = 0;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			
			/** 업데이트 어떤것을 할건지 작성해야함*/
			
			
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("회원정보 수정중 에러 발생!");
			throw new Exception("회원정보 수정중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}
	
	
	public int userLogin(String userId , String userPassword){
		
		
		return 0;
	}

	// USER_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(USER_NO_PK)+1) AS max_NO FROM USER_TB");
	}
}