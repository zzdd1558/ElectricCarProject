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

/**
 * Servlet implementation class StationController
 */
public class StationController extends HttpServlet {
    public StationController() {
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");

		if ("wordSearch".equals(command)) {
			/** 글자로 CS검색 */
			System.out.println("검색시도");
			wordSearch(request, response);
			System.out.println("검색성공");
		} else if ("selectSearch".equals(command)) {
			/** 셀렉트박스로 CS검색 */
			System.out.println("검색시도");
			selectSearch(request, response);
			System.out.println("검색성공");
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
	}

	private void selectSearch(HttpServletRequest request, HttpServletResponse response) {
		
	}

}
