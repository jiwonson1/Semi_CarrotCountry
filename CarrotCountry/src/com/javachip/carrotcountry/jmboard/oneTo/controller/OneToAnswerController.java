package com.javachip.carrotcountry.jmboard.oneTo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.oneTo.model.service.OneToService;
import com.javachip.carrotcountry.jmboard.oneTo.model.vo.OneTo;

/**
 * Servlet implementation class OneToAnswerController
 */
@WebServlet("/answer.on.jm")
public class OneToAnswerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OneToAnswerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 답변 겸 답변 수정 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		
		
		int ono = Integer.parseInt(request.getParameter("ono"));
		String answererNo = request.getParameter("answererNo");
		String content = request.getParameter("content");
		
		OneTo o = new OneTo();
		
		o.setOneToNo(ono);
		o.setAnswererNo(answererNo);
		o.setAnswerContent(content);
		//System.out.println();
		int result = new OneToService().answer(o); 
		
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "답변완료되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.on.jm?ono=" + ono);
		}else {
			request.setAttribute("errorMsg", "답변등록 실패.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
			
		}
		

		
		
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
