package com.cruzeiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	private DataSource dataSource;
	
	public StudentDbUtil(DataSource datasource) {
		this.dataSource = datasource;
	}
	
	public List<Student> getStudents() throws Exception{

		List<Student> students = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql= "SELECT id, firstname, lastname, email FROM STUDENT ORDER BY lastname";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				
				Student tempStudent = new Student(id, firstName, lastName, email);
				
				students.add(tempStudent);
			}
			
			return students;
		}finally {
			close(conn, stmt, rs);
		}
	}
	
	
	public void addStudent(Student student) throws Exception{
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO STUDENT(FIRSTNAME, LASTNAME, EMAIL) VALUES(?,?,?)";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setString(3, student.getEmail());
			stmt.execute();
		}finally {
			close(conn, stmt, null);
		}
	}
	
	
	private void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(conn != null) {
				rs.close();
			}
			if(stmt != null) {
				rs.close();
			}
			if(rs != null) {
				rs.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
