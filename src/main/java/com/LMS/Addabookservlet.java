package com.LMS;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LMS.dao.BookDao;

/**
 * Servlet implementation class Addabookservlet
 */
public class Addabookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addabookservlet() {
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
		String title = request.getParameter("title").toString();
		int edition = Integer.parseInt(request.getParameter("edition"));
		String date = request.getParameter("date").toString();
		String author = request.getParameter("author").toString();
		String category = request.getParameter("category").toString();
		int copies = Integer.parseInt(request.getParameter("copies"));
		
		BookDao b2 = new BookDao();
		b2.AddBook(id, title,edition, date, author, category, copies);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='index.jsp'>Home</a>");
		out.println("<h1>"+"Book details added successfully!"+"</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
