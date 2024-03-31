package com.LMS.dao;

import java.sql.*;
import com.LMS.model.Librarian;

public class LibrarianDao {
	
	final String url = "jdbc:postgresql://localhost:5432/LibraryManagementSystem";
	final String user= "postgres";
	final String pass= "#Postgre123";
	String p="";
	
	public Librarian LogInLibrarian(String userName, String pass1) {
		
		String login = "select password from librarian where librarian_id=?";
		
		Librarian l1 = new Librarian();
		
		try {
			Class.forName("org.postgresql.Driver");
		}catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(url, user, pass);
				PreparedStatement stmt = conn.prepareStatement(login)){
				stmt.setString(1, userName.trim());
				ResultSet rs = stmt.executeQuery();
					
					while(rs.next()) {
						p = rs.getString("password");
					}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
		if(p.equals(pass1))
			return l1;
		else
			return null;
	}

}
