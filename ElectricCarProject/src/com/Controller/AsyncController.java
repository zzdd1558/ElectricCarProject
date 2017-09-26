package com.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.CityHighTableDAO;
import com.DAO.CityMiddleTableDAO;
import com.DTO.CityHighTableDTO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AsyncController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		

		String command = request.getParameter("kinds");
		System.out.println(command);
		if ("clickHigh".equals(command)) {
			getCityList(request, response, command);
		}else if ( "clickMiddle".equals(command)){
			getCityList(request,response,command);
		}
	}

	protected void getCityList(HttpServletRequest request, HttpServletResponse response, String command) {
		/*response.setContentType("application/json; charset=UTF-8");*/
		response.setContentType("text/html; charset=utf-8");
		List<?> list = null;
		try {
			if("clickHigh".equals(command)){
				list = new CityHighTableDAO().getInstance().getCityHighList();
			}else if ("clickMiddle".equals(command)){
				list = new CityMiddleTableDAO().getInstance().getCityMiddleList(Integer.parseInt(request.getParameter("check")));
			}
			
			JSONArray jsonArray = JSONArray.fromObject(list);
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("data", jsonArray);

			response.getWriter().println(jsonObject);
		} catch (Exception e1) {
			System.out.println("JSON 데이터 반환중 에러 발생!");
		}
	}
}
