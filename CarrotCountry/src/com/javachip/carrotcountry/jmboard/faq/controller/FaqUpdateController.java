package com.javachip.carrotcountry.jmboard.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachip.carrotcountry.jmboard.faq.model.service.FaqService;
import com.javachip.carrotcountry.jmboard.faq.model.vo.Faq;

/**
 * Servlet implementation class FaqUpdateController
 */
@WebServlet("/update.fa.jm")
public class FaqUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FaqUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		String faqTitle = request.getParameter("title");
		String faqContent = request.getParameter("content");
		
		Faq f = new Faq();
		
		f.setFaqNo(fno);
		f.setFaqTitle(faqTitle);
		f.setFaqContent(faqContent);
		System.out.println(f);
		
		int result = new FaqService().updateFaq(f);
		
		if(result > 0) {
			request.getSession().setAttribute("alertMsg", "성공적으로 FAQ 수정되었습니다.");
			response.sendRedirect(request.getContextPath() + "/detail.fa?fno=" + fno);
		}else {
			request.setAttribute("errorMsg", "FAQ 수정 실패.");
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
