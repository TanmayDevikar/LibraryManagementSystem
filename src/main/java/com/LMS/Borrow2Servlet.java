package com.LMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LMS.dao.BookDao;
import com.LMS.model.Book;

/**
 * Servlet implementation class Borrow2Servlet
 */
public class Borrow2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Borrow2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
        String id = request.getParameter("bookId").toString();
		
		BookDao b2 = new BookDao();
		Book b3 = b2.BorrowBook(id);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='index.jsp'>Home</a>");
		
		if(b3!=null) {
			out.println("<h1>"+"Book borrowed successfully"+"</h1>");
		}
		else {
			out.println("<h1>"+"All the copies of this book are currently borrowed by other users."+"</h1>");
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
