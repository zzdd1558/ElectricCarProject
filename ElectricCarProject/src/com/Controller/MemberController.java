package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserTableDAO;
import com.DTO.UserTableDTO;
import com.Utils.EncryptionUtil;

public class MemberController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");

		if ("login".equals(command)) {
			login(request, response);
		} else if ("signup".equals(command)) {
			insertMember(request, response);
			System.out.println("가입성공");
		} else if ("modify".equals(command)) {
			modify(request, response);
			System.out.println("수정성공");
		} else if ("info".equals(command)) {
			System.out.println("정보확인");
			info(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		UserTableDAO userDAO = UserTableDAO.getInstance();
		UserTableDTO userDTO = null;
		String url = "index.jsp";
		
		try {
			userDTO = userDAO.userLogin(userId);
		} catch (Exception e) {
			System.out.println("ID 비교중 에러 발생");
		}
		
		boolean loginCheck = EncryptionUtil.passwordConfirm(userPassword, userDTO);
		if (loginCheck) {
			/** 여기서 세션 생성 */
			
		}else{
			
			/** 세셩 생성 X And 로그인 페이지로 다시 이동*/ 
		}

		

		request.setAttribute("managerCdFk", userDTO.getManagerCdFk());

		request.getRequestDispatcher(url).forward(request, response);
	}

	private void insertMember(HttpServletRequest request, HttpServletResponse response) {

	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {

	}

	private void info(HttpServletRequest request, HttpServletResponse response) {

	}

}// end of class
