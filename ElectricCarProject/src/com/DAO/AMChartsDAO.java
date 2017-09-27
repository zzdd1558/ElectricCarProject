package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.DTO.ChargerDataTableDTO;
import com.Utils.DBUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AMChartsDAO {
	private static AMChartsDAO instance = new AMChartsDAO();

	public static AMChartsDAO getInstance() {
		return instance;
	}

	// list형태로 반환받는다.
	public JSONObject getHighChart() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		JSONObject arrayObject = null;
		JSONObject sendDataObject = null;
		JSONArray array = null;
		String[] colorArray = new String[] { "#FF0F00", "#FF6600", "#FF9E01", "#FCD202", "#F8FF01", "#B0DE09",
				"#04D215", "#0D8ECF", "#0D52D1", "#2A0CD0", "#8A0CCF", "#CD0D74" };
		String sql = "SELECT CITY_HIGH_NO_PK, CITY_HIGH_NM, COUNT(*) FROM CITY_HIGH_TB CHT "
				+ " INNER  JOIN CITY_MIDDLE_TB CMT ON CHT.CITY_HIGH_NO_PK =  CMT.CITY_HIGH_NO_FK"
				+ " INNER JOIN CITY_LOW_TB CLT ON CMT.CITY_MIDDLE_NO_PK = CLT.CITY_MIDDLE_NO_FK"
				+ " GROUP by CITY_HIGH_NM,  CITY_HIGH_NO_PK ORDER BY CHT.CITY_HIGH_NO_PK";

		try {
			arrayObject = new JSONObject();
			sendDataObject = new JSONObject();
			array = new JSONArray();
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				arrayObject.put("country", rset.getString(2));
				arrayObject.put("visits", rset.getInt(3));
				arrayObject.put("color", colorArray[(int) (Math.random() * colorArray.length)]);
				array.add(arrayObject);
			}

			sendDataObject.put("dataProvider", array);

		} catch (Exception e) {
			System.out.println("chartJsonData SELECT중 에러 발생!");
			throw new Exception("chartJsonData SELECT중 에러 발생!");
		} finally {
			DBUtil.close(con, pstmt);
		}
		return sendDataObject;
	}
}
