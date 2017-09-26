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
		System.out.println(request.getParameter("middle"));
		
		
	}

}
