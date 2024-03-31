package com.LMS.dao;

import java.sql.*;
import com.LMS.model.Member;

public class MemberDao {
	
	final String url = "jdbc:postgresql://localhost:5432/LibraryManagementSystem";
	final String user= "postgres";
	final String pass= "#Postgre123";
	String p="";
	
	public Member LogInMember(String userName, String pass1) {
		
		String login = "select password from members where member_id=?";
		
		Member m1 = new Member();
		
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
			return m1;
		else
			return null;
	}

}
