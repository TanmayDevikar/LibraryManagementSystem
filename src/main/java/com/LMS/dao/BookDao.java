package com.LMS.dao;

import java.sql.*;

import com.LMS.model.*;

public class BookDao {
	
	final String url = "jdbc:postgresql://localhost:5432/LibraryManagementSystem";
	final String user= "postgres";
	final String pass= "#Postgre123";
	
	public static String uName = "";
	
	public Book AddBook(String bookID1, String title1, int edition, String date, String author1, String catogery1, int copies) {
		
		String add = "insert into book values(?,?,?,?,?,?,?);";
		
		Book b1 = new Book();
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(add)){
				stmt.setString(1, bookID1.trim());
				stmt.setString(2, title1.trim());
				stmt.setInt(3, edition);
				stmt.setString(4, date.trim());
				stmt.setString(5, author1.trim());
				stmt.setString(6, catogery1.trim());
				stmt.setInt(7, copies);
				stmt.executeQuery();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return b1;
	}
	
	public Book DeleteBook(String bookID) {
		
		String delete = "delete from book where book_id=?;";
		
		Book b2 = new Book();
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(delete)){
				stmt.setString(1, bookID.trim());
				stmt.executeQuery();
				
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return b2;
	}
	
public Book ModifyBook(String bookID1, String title1, Integer edition1, String date1, String author1, String catogery1, Integer copies1) {
		
	String old = "select * from book where book_id=?";
	String modify = "update book set title=?, edition=?, published_date=?, author=?, category=?, no_of_copies=? where book_id=?;";
	String title2="", date2="", author2="", cat="";
	int edition2=1, noc=1;
		
		Book b1 = new Book();
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, user, pass);
				
				PreparedStatement stmt1 = conn.prepareStatement(old)) {
			    stmt1.setString(1, bookID1.trim());
				ResultSet rs = stmt1.executeQuery();
				
				while(rs.next()) {
					b1.setBookID(rs.getString("book_id"));
					b1.setTitle(rs.getString("title"));
					b1.setEdition(rs.getInt("edition"));
					b1.setPublishedDate(rs.getString("published_date"));
					b1.setAuthor(rs.getString("author"));
					b1.setCatogery(rs.getString("category"));
					b1.setNoOfCopies(rs.getInt("no_of_copies"));
				}
				
				if(title1!="")
					title2 = title1;
		        else
		        	title2=b1.getTitle();
				
				if(edition1>-1)
					edition2 = edition1;
		        else
		        	edition2=b1.getEdition();
				
				if(date1!="")
					date2 = date1;
		        else
		        	date2=b1.getPublishedDate();
				
				if(author1!="")
					author2 = author1;
		        else
		        	author2=b1.getAuthor();
				
				if(catogery1!="")
					cat = catogery1;
		        else
		        	cat=b1.getCatogery();
				
				if(copies1>-1)
					noc = copies1;
		        else
		        	noc=b1.getNoOfCopies();
				
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
try(Connection conn = DriverManager.getConnection(url, user, pass);
				
				PreparedStatement stmt2 = conn.prepareStatement(modify)){
				stmt2.setString(1, title2);
				stmt2.setInt(2, edition2);
				stmt2.setString(3, date2);
				stmt2.setString(4, author2);
				stmt2.setString(5, cat);
				stmt2.setInt(6, noc);
				stmt2.setString(7, bookID1);
				stmt2.executeQuery();
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return b1;
	}

public void getMember(String uName1) {
	uName = uName1;
}


public Book BorrowBook(String id) {
	
	String copies = "select no_of_copies from book where book_id=?;";
	
	Book bs = new Book();
	
	try {
		Class.forName("org.postgresql.Driver");
	}catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try(Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(copies)){
			stmt.setString(1, id.trim());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				bs.setNoOfCopies(rs.getInt("no_of_copies"));
			}
			
			if(bs.getNoOfCopies()>0) {
				String reduce = "update book set no_of_copies=no_of_copies-1, member_id = ? where book_id=?";
				PreparedStatement stmt1 = conn.prepareStatement(reduce);
					stmt1.setString(1, uName.trim());
					stmt1.setString(2, id.trim());
					ResultSet rs1 = stmt1.executeQuery();
			}
			else {
				bs=null;
			}

			
	} catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	
	return bs;
}

public Book returnBook(String id, String mid) {
	
	String count = "select member_id from book where book_id=?;";
	Book bs = new Book();
	int tag=0;
	
	try {
		Class.forName("org.postgresql.Driver");
	}catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	}
	try(Connection conn = DriverManager.getConnection(url, user, pass);
			PreparedStatement stmt = conn.prepareStatement(count)){
			stmt.setString(1, id.trim());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				bs.setMemberId(rs.getString("member_id"));
			}
			try {
				tag=1;
				if(bs.getMemberId().equals(mid)) {
					String reduce = "update book set no_of_copies=no_of_copies+1, member_id='' where book_id=?";
					PreparedStatement stmt1 = conn.prepareStatement(reduce);
						stmt1.setString(1, id.trim());
						ResultSet rs1 = stmt1.executeQuery();
				}
				else {
					tag=0;
				}
			} catch(Exception e) {
				if(tag==0)
					bs=null;
			}

			
	} catch(SQLException e) {
		System.out.println(e.getMessage());
	}
	
	if(tag==1)
		return bs;
	else
		return null;
}
	


}
