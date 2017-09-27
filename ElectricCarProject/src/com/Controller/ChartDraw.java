package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AMChartsDAO;

import net.sf.json.JSONObject;

public class ChartDraw extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		String command = request.getParameter("command");
		if ("high".equals(command)) {
			drawHighChart(request, response);
		} 
	}
	
	
	protected void drawHighChart(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		AMChartsDAO chartDAO = AMChartsDAO.getInstance();
		JSONObject data =null;
		try {
			data= chartDAO.getHighChart();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().println(data);
	}
}
