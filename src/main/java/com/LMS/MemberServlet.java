package com.LMS;

import java.io.IOException;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LMS.dao.*;
import com.LMS.model.*;

/**
 * Servlet implementation class MemberServlet
 */
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String userName = request.getParameter("user").toString();
		String password = request.getParameter("pass").toString();
		
		MemberDao m2 = new MemberDao();
		Member m3 = m2.LogInMember(userName, password);
		request.setAttribute("Member", m3);
		
		if(m3!=null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("MemberLoginSuccess.jsp");
			rd.forward(request, response);
			
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("LoginFailed.jsp");
			rd.forward(request, response);
		}
		
		BookDao b1 = new BookDao();
		b1.getMember(userName);
		
		ViewBorrowedServlet v1 = new ViewBorrowedServlet();
		v1.getMember(userName);
		
		ReturnServlet r1 = new ReturnServlet();
		r1.getMember(userName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
