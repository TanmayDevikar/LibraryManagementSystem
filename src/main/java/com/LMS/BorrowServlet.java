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
 * Servlet implementation class BorrowServlet
 */
public class BorrowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrowServlet() {
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
		String author = request.getParameter("author").toString();
		String category = request.getParameter("category").toString();
		int count=0;
		
		String title1="", author1="", cat="";
		if(title!="")
			title1="%"+title+"%";
		if(author!="")
			author1="%"+author+"%";
		if(category!="")
			cat="%"+category+"%";
		
//		BookDao b2 = new BookDao();
//		b2.SearchBook(id, title, author, category);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<a href='index.jsp'>Home</a>");
		
		try {
			Class.forName("org.postgresql.Driver");

		        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/LibraryManagementSystem", "postgres", "#Postgre123");
				Statement stmt = conn.createStatement();
				
				ResultSet rs = stmt.executeQuery("select * from book where book_id='"+id+"' or title like'"+title1+"' or author like'"+author1+"' or category like'"+cat+"'");
				count=0;
				while(rs.next()) {
					count++;
					if(count==1)
						out.println("<table><tr><th>Type</th><th>BookId</th><th>Title</th><th>Edition</th><th>Published Date</th><th>Author</th><th>Category</th><th>Copies</th></tr>");
					out.print("<tr><td>");
					out.print("Book");
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
					out.print("<td>");
					out.println(rs.getInt(7));
					out.print("</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				
				ResultSet rs1 = stmt.executeQuery("select * from journal where journal_id='"+id+"' or title like'"+title1+"'");
				count=0;
				while(rs1.next()) {
					count++;
					if(count==1)
						out.println("<table><tr><th>Type</th><th>Journal ID</th><th>Title</th>");
					out.print("<tr><td>");
					out.print("Journal");
					out.print("</td>");
					out.print("<td>");
					out.println(rs1.getString(1));
					out.print("</td>");
					out.print("<td>");
					out.println(rs1.getString(2));
					out.print("</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				
				ResultSet rs2 = stmt.executeQuery("select * from magazine where magazine_id='"+id+"' or name like'"+title1+"'");
				count=0;
				while(rs2.next()) {
					count++;
					if(count==1)
						out.println("<table><tr><th>Type</th><th>Magaazine ID</th><th>Name</th><th>Issue</th><th>Copies</th>");
					out.print("<tr><td>");
					out.print("Magazine");
					out.print("</td>");
					out.print("<td>");
					out.println(rs2.getString(1));
					out.print("</td>");
					out.print("<td>");
					out.println(rs2.getString(2));
					out.print("</td>");
					out.print("<td>");
					out.println(rs2.getString(3));
					out.print("</td>");
					out.print("<td>");
					out.println(rs2.getString(5));
					out.print("</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				
				ResultSet rs3 = stmt.executeQuery("select * from technical_reports where tech_id='"+id+"' or title like'"+title1+"'or category like'"+cat+"'");
				count=0;
				while(rs3.next()) {
					count++;
					if(count==1)
						out.println("<table><tr><th>Type</th><th>Tech ID</th><th>Title</th><th>Category</th>");
					out.print("<tr><td>");
					out.print("Technical Reports");
					out.print("</td>");
					out.print("<td>");
					out.println(rs3.getString(1));
					out.print("</td>");
					out.print("<td>");
					out.println(rs3.getString(2));
					out.print("</td>");
					out.print("<td>");
					out.println(rs3.getString(3));
					out.print("</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				
				ResultSet rs4 = stmt.executeQuery("select * from thesis where thesis_id='"+id+"' or title like'"+title1+"'or category like'"+cat+"'");
				count=0;
				while(rs4.next()) {
					count++;
					if(count==1)
						out.println("<table><tr><th>Type</th><th>Thesis ID</th><th>Title</th><th>Category</th><th>Copies</th>");
					out.print("<tr><td>");
					out.print("Thesis");
					out.print("</td>");
					out.print("<td>");
					out.println(rs4.getString(1));
					out.print("</td>");
					out.print("<td>");
					out.println(rs4.getString(2));
					out.print("</td>");
					out.print("<td>");
					out.println(rs4.getString(3));
					out.print("</td>");
					out.print("<td>");
					out.println(rs4.getString(4));
					out.print("</td>");
					out.print("</tr>");
				}
				out.print("</table>");
				out.print("<br/><br/><br/><br/>");
				out.print("Note the Book ID and &nbsp;"+"<a href='Borrow2.jsp'>Borrow</a>"+" a Book");
				

				
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
