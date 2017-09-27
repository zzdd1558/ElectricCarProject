package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserTableDAO;
import com.DTO.UserTableDTO;
import com.Utils.EncryptionUtil;

public class MemberController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String command = request.getParameter("command");

		if ("login".equals(command)) {
			/** 로그인 */
			login(request, response);
		} else if ("signup".equals(command)) {
			/** 회원가입 */
			insertMember(request, response);
		} else if ("modify".equals(command)) {
			/** 수정 */
			modify(request, response);
		} else if ("info".equals(command)) {
			/** 정보 */
			info(request, response);
		} else if ("logout".equals(command)) {
			/** 로그아웃 */
			logout(request, response);
		}
		
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("logout");
		HttpSession session = request.getSession();
		session.invalidate();
		session = null;
		try {
			response.sendRedirect("index.jsp");
		} catch (IOException e) {
			System.out.println("로그아웃 도중 에러발생!");
		}
	}

	// 로그인 영역
	private void login(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = null;
		UserTableDTO userDTO = null;
		UserTableDAO userDAO = UserTableDAO.getInstance();
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");

		
		try {
			userDTO = userDAO.userLogin(userId);
			boolean loginCheck = EncryptionUtil.passwordConfirm(userPassword, userDTO);
			
			if (loginCheck) {
				/** 세션 생성 */
				session = request.getSession();
				session.setAttribute("managerKey", userDTO.getManagerCdFk());
				
			} else {
				/** 세셩 생성 X And 로그인 페이지로 다시 이동 */

			}
			response.sendRedirect("index.jsp");
			/*response.getWriter().println("<script>alert('로그인',(function(){location.href = 'index.jsp'})());</script>");*/
		} catch (Exception e) {
			System.out.println("ID 비교중 에러 발생");
		}
	}

	// 회원가입 영역
	private void insertMember(HttpServletRequest request, HttpServletResponse response) {
		UserTableDTO userDTO = new UserTableDTO();
		UserTableDAO userDAO = UserTableDAO.getInstance();
		userDTO.setUserId(request.getParameter("userId"));
		userDTO.setUserNm(request.getParameter("userNm"));
		userDTO.setUserPhoneNo(request.getParameter("userPhoneNo"));
		userDTO.setCityMiddleNoFk(Integer.parseInt(request.getParameter("city_middle")));

		
		// 비밀번호 암호화와 Salt Key 내부적으로 setter 동작
		EncryptionUtil.passwordEncryption(request.getParameter("userPassword"), userDTO);
		
		
		int result = 0;
		try {
			result = userDAO.insertUser(userDTO);

			if (result == 0) {
				System.out.println("데이터 삽입 오류");
			}
			
			
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void modify(HttpServletRequest request, HttpServletResponse response) {

	}

	private void info(HttpServletRequest request, HttpServletResponse response) {

	}

}// end of class
