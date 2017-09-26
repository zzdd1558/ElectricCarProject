package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.DTO.ChargerDataTableDTO;
import com.DTO.ChargerTypeTableDTO;
import com.DTO.GetChargerDataInfoDTO;
import com.Utils.DBUtil;

public class ChargerDataTableDAO {

	private static ChargerDataTableDAO instance;

	public static ChargerDataTableDAO getInstance() {
		if (instance == null) {
			instance = new ChargerDataTableDAO();
		}
		return instance;
	}

	// CHARGER_DATA_TB에서 입력된 String 값을 가지고 있는 로우들을 result set으로 먼저 받고, 결국에는
	// list형태로 반환받는다.
	public List<ChargerDataTableDTO> wordSearchChargerData(String str) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "SELECT * FROM CHARGER_DATA_TB WHERE ";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("wordSearchChargerData SELECT중 에러 발생!");
			throw new Exception("wordSearchChargerData SELECT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return null;
	}

	// CHARGER_DATA_TB에 Code 데이터 INSERT
	public int insertChargerData(ChargerDataTableDTO chargerData) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "INSERT INTO CHARGER_TYPE_TB VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";

		try {

			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, getMaxNo());
			pstmt.setInt(2, chargerData.getCsCodeCdFk());
			pstmt.setInt(3, chargerData.getCpUniqueNo());
			pstmt.setInt(4, chargerData.getCpNameCdFk());
			pstmt.setInt(5, chargerData.getCpStatCdFk());
			pstmt.setInt(6, chargerData.getCpTypeCdFk());
			pstmt.setInt(7, chargerData.getChargerTypeCdFk());
			pstmt.setInt(8, chargerData.getCityLowNoFk());
			pstmt.setString(9, chargerData.getStatUpdateDatetimeDt());
			pstmt.setDouble(10, chargerData.getLat());
			pstmt.setDouble(11, chargerData.getLongi());
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("insertChargerData INSERT중 에러 발생!");
			throw new Exception("insertChargerData INSERT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}

		return cnt;
	}

	// CHARGER_DATA_TB에 Code 데이터 DELETE
	public int deleteChargerData(int chargerDataNoPk) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "DELETE FROM CHARGER_DATA_TB WHERE CHARGER_DATA_NO_PK = ?";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, chargerDataNoPk);
			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("deleteChargerData DELETE중 에러 발생!");
			throw new Exception("deleteChargerData DELETE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	// CHARGER_DATA_TB에 Code 데이터 UPDATE
	public int updateChargerData(ChargerDataTableDTO chargerData) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		String sql = "뭐를 수정할지 정해야함";

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			/* update 할 것들 작성. */

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("updateChargerType UPDATE중 에러 발생!");
			throw new Exception("updateChargerType UPDATE중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return cnt;
	}

	
	// search한 지역의 리스트 반환
	public List<GetChargerDataInfoDTO> getChargerDataList(int middle) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		StringBuilder sql = null;
		List<GetChargerDataInfoDTO> list = null;
		
		try {
			con = DBUtil.getConnection();
			sql = new StringBuilder();
			list = new ArrayList<>();

			sql.append("SELECT CHARGERDT.CHARGER_DATA_NO_PK ,CHT.CITY_HIGH_NM ,");
			sql.append("CMT.CITY_MIDDLE_NM , CLT.CITY_LOW_NM, CCT.CS_CODE_NM ,");
			sql.append("  CNT.CP_NAME_NM , CST.CP_STAT_NM , CHARGERTT.CHARGER_TYPE_NM , CTT.CP_TYPE_NM, CHARGERDT.LAT , CHARGERDT.LONGI , CLT.CITY_LOW_NO_PK ");
			sql.append(" FROM CHARGER_DATA_TB CHARGERDT ");
			sql.append(" INNER JOIN CS_CODE_TB CCT ON CHARGERDT.CS_CODE_CD_FK = CCT.CS_CODE_CD_PK");
			sql.append(" INNER JOIN CP_NAME_TB CNT ON CHARGERDT.CP_NAME_CD_FK = CNT.CP_NAME_CD_PK");
			sql.append(" INNER JOIN CP_STAT_TB CST ON CHARGERDT.CP_STAT_CD_FK = CST.CP_STAT_CD_PK");
			sql.append(" INNER JOIN CP_TYPE_TB CTT ON CHARGERDT.CP_TYPE_CD_FK = CTT.CP_TYPE_CD_PK");
			sql.append(" INNER JOIN CHARGER_TYPE_TB CHARGERTT ON CHARGERDT.CHARGER_TYPE_CD_FK = CHARGERTT.CHARGER_TYPE_CD_PK");
			sql.append(" INNER JOIN CITY_LOW_TB CLT ON CHARGERDT.CITY_LOW_NO_FK = CLT.CITY_LOW_NO_PK");
			sql.append(" INNER JOIN CITY_MIDDLE_TB CMT ON CLT.CITY_MIDDLE_NO_FK = CMT.CITY_MIDDLE_NO_PK");
			sql.append(" INNER JOIN CITY_HIGH_TB CHT ON CMT.CITY_HIGH_NO_FK = CHT.CITY_HIGH_NO_PK ");
			sql.append(" WHERE CLT.CITY_MIDDLE_NO_FK = ?");
			sql.append(" ORDER BY CHARGERDT.CHARGER_DATA_NO_PK ASC");
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, middle);

			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new GetChargerDataInfoDTO(rset.getInt(1), rset.getString(2), rset.getString(3),
						rset.getString(4), rset.getString(5), rset.getString(6), rset.getString(7), rset.getString(8),
						rset.getString(9) , rset.getDouble(10), rset.getDouble(11), rset.getInt(12)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("getChargerDataList 정보를 가져오는중 에러 발생!");
			throw new Exception("getChargerDataList 정보를 가져오는중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt, rset);
		}

		return list;

	}

	// CHARGER_DATA_TB PK의 최대값 반환
	public int getMaxNo() throws Exception {
		return CommonDAO.getMaxNo("SELECT (MAX(CHARGER_NO_PK)+1) AS max_NO FROM CHARGER_DATA_TB");
	}

}