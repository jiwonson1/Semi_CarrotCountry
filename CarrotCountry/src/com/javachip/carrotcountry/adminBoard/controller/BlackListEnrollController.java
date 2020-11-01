package com.javachip.carrotcountry.adminBoard.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.adminBoard.model.service.AdminMemberService;

@WebServlet("/blacklistEnroll.sb")
public class BlackListEnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BlackListEnrollController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String memNo = request.getParameter("memNo");
		String bList = request.getParameter("bList");
		
		int result = new AdminMemberService().blackListEnroll(memNo, bList);
		
		if (result > 0) { 	// 블랙리스트 등록 성공 시
			response.sendRedirect(request.getContextPath() + "/userList.sb?currentPage=1");
		} else {	// 블랙리스트 등록 실패 시
			response.sendRedirect(request.getContextPath() + "/userList.sb?currentPage=1");	
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
