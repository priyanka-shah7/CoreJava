package com.corejava.jdbc;
import java.sql.*;
public class jdbcTest {
	
public static void main(String[] args) throws Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver"); 
	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");
	System.out.println("Connection established");
	Statement stmt1 = con.createStatement();
	System.out.println("Statement object created");
	 stmt1.executeUpdate("INSERT INTO department VALUES (2, 'Production')");
	 stmt1.executeUpdate("INSERT INTO department VALUES (3, 'HR')");
	 stmt1.executeUpdate("INSERT INTO department VALUES (4, 'Accounts')");
	
	ResultSet rs = stmt1.executeQuery("select * from department"); 
	while(rs.next()) {
		System.out.println(rs.getInt("ID") + " - " + rs.getString("NAME"));
		} 
	rs.close(); 
	stmt1.close();
	con.close();

}

}