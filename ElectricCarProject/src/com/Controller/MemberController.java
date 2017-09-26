package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserTableDAO;
import com.DTO.UserTableDTO;
import com.Utils.EncryptionUtil;



@WebServlet("/memberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("command");

		if (command.equals("login")) {
			login(request, response);
			
			//세션을 이용해 로그인여부 확인
			HttpSession session = request.getSession();
			session.setAttribute("flag", true);
			
			System.out.println("로그인성공");
			 response.sendRedirect("loginView.jsp"); 
		} else if (command.equals("signup")) {
			insertMember(request, response);
			System.out.println("가입성공");
		} else if (command.equals("modify")) {
			modify(request, response);
			System.out.println("수정성공");
		} else if (command.equals("info")) {
			System.out.println("정보확인");
			info(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		UserTableDAO userDAO = UserTableDAO.getInstance();
		UserTableDTO userDTO = userDAO.userLogin(userId);
		
		boolean loginCheck = EncryptionUtil.passwordConfirm(userPassword, userDTO);
		
		String url = "loginView.jsp";

		request.setAttribute("userId", userId);

		RequestDispatcher rdp = request.getRequestDispatcher(url);
		rdp.forward(request, response);
		System.out.println("로그인");
		System.out.println(loginMember.toString());
	}	
	private void insertMember(HttpServletRequest request, HttpServletResponse response) {
		
	}
	private void modify(HttpServletRequest request, HttpServletResponse response) {
		
	}
	private void info(HttpServletRequest request, HttpServletResponse response) {
		
	}



	
}// end of class

