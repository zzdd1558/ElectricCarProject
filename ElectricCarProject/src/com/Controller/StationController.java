package com.Controller;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.DAO.ChargerDataTableDAO;
import com.DTO.ChargerDataTableDTO;
import com.DTO.GetChargerDataInfoDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class StationController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");

		if ("wordSearch".equals(command)) {

			/** 글자로 CS검색 */
			wordSearch(request, response);

		} else if ("selectSearch".equals(command)) {

			/** 셀렉트박스로 CS검색 */
			selectSearch(request, response);

		}
	} // end of service

	private void wordSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String str = request.getParameter("str");
		ChargerDataTableDAO cdtDAO = ChargerDataTableDAO.getInstance();
		List<ChargerDataTableDTO> list;
		try {
			list = cdtDAO.wordSearchChargerData(str);
			request.setAttribute("wordSearchList", list);
			response.sendRedirect("${pageContext.request.contextPath}/index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}// end of wordSearch

	private void selectSearch(HttpServletRequest request, HttpServletResponse response) {
		/*response.setContentType("application/json; charset=UTF-8");*/
		response.setContentType("text/html; charset=utf-8");
		ChargerDataTableDAO chargerDateDAO = ChargerDataTableDAO.getInstance();
		try {
			JSONArray array = JSONArray
					.fromObject(chargerDateDAO.getChargerDataList(Integer.parseInt(request.getParameter("middle"))));
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", array);

			response.getWriter().println(jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("JSON 데이터 반환중 에러 발생!");
		}

	}

}
