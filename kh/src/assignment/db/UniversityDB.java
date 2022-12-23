package assignment.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import assignment.db.vo.Department;

public class UniversityDB {
	
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void insertDepartment(Department department) {
		String sql = "insert into department(de_num,de_name,de_address,de_tel,de_pr_num) values(?,?,?,?,?)";		
	    try {
	    	con = getConnection();
	    	pstmt.setInt(1, department.getDe_num());
	    	pstmt.setString(2, department.getDe_name());
	    	pstmt.setString(3, department.getDe_address());
	    	pstmt.setString(2, department.getDe_tel());
	    	pstmt.setInt(2, department.getDe_pr_num());
	    	int count = pstmt.executeUpdate();
	    	if(count == 0) {
	    		System.out.println("[추가 실패]");
	    	}
	    	else {
	    		System.out.println("[추가 성공]");
	    	}
	    }catch(SQLException e) {
	    	System.out.println(e.getMessage());
	    }finally {
	    	close();
		}
	}
	
	 private void close() {
	        if (rs != null) {
	            try {
	                rs.close();
	            } catch (SQLException e) {
	            	System.out.println("에러: " + e);
	            }
	        }
	        if (stmt != null) {
	            try {
	                stmt.close();
	            } catch (SQLException e) {
	            	System.out.println("에러: " + e);
	            }
	        }
	        if (con != null) {
	            try {
	                con.close();
	            } catch (SQLException e) {
	            	System.out.println("에러: " + e);
	            }
	        }
	    }
	    private Connection getConnection() {
	        return DBConnection.getConnection();
	    }

}
