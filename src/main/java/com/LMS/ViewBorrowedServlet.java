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

/**
 * Servlet implementation class ViewBorrowedServlet
 */
public class ViewBorrowedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String uName="";
	public void getMember(String uName1) {
		uName = uName1;
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBorrowedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int count=0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='index.jsp'>Home</a>");
		
		try {
			Class.forName("org.postgresql.Driver");

		        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryManagementSystem", "postgres", "#Postgre123");
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from book where member_id='"+uName+"'");
				count=0;
				while(rs.next()) {
					count++;
					if(count==1)
						out.println("<table><tr><th>Member ID</th><th>BookId</th><th>Title</th><th>Edition</th><th>Published Date</th><th>Author</th><th>Category</th></tr>");
					out.print("<tr><td>");
					out.print(rs.getString(8));
					out.print("</td>");
					out.print("<td>");
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
					out.print("</tr>");
				}
				out.print("</table>");
				
				out.print("<br/><br/><br/>");
				out.print("<a href='Return.jsp'>Return a book</a>");
				
				
		} catch(Exception e) {
			System.out.println(e.getMessage());
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
