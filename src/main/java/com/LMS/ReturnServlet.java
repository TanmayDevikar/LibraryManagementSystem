package com.LMS;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LMS.dao.*;
import com.LMS.model.*;

/**
 * Servlet implementation class ReturnServlet
 */
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String uName="";
	public void getMember(String uName1) {
		uName = uName1;
	}
	public static int count=0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
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
		BookDao b1 = new BookDao();
		Book d2 = b1.returnBook(id, uName);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='index.jsp'>Home</a>");
		
		if(d2!=null) {
			out.print("You have returned the following book successfully.");
			try {
				Class.forName("org.postgresql.Driver");

			        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryManagementSystem", "postgres", "#Postgre123");
					Statement stmt = conn.createStatement();
					
					ResultSet rs = stmt.executeQuery("select * from book where book_id='"+id+"'");
					count=0;
					while(rs.next()) {
						count++;
						if(count==1)
							out.println("<table><tr><th>BookId</th><th>Title</th><th>Edition</th><th>Published Date</th><th>Author</th><th>Category</th><th>Copies</th></tr>");
						out.print("<tr><td>");
						out.println(rs.getString(1));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getString(2));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getInt(3));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getString(4));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getString(5));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getString(6));
						out.print("</td>");
						out.print("<td>");
						out.println(rs.getInt(7));
						out.print("</td>");
						out.print("</tr>");
					}
					out.print("</table>");
			} catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		else {
			out.print("You cannot return this book as you never borrowed it.");
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
