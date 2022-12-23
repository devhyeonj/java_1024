package assignment.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.NoSuchElementException;

import assignment.db.vo.Department;

public class UniversityDB {

	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	

	public UniversityDB() throws SQLException {
		con = getConnection();
		stmt = con.createStatement();
	}

	public void insertDepartment(Department department) {
		String sql = "insert into department(de_num,de_name,de_address,de_tel,de_pr_num) values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, department.getDe_num());
			pstmt.setString(2, department.getDe_name());
			pstmt.setString(3, department.getDe_address());
			pstmt.setString(4, department.getDe_tel());
			pstmt.setInt(5, department.getDe_pr_num());
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("[추가 실패]");
			} else {
				System.out.println("[추가 성공]");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			close();
		}
	}
	
	public void update(Department department, int searchNum) throws SQLException {
		String sql = "update department set de_num = ?, de_name = ?, de_address =? , de_tel = ? , de_pr_num = ? where de_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, department.getDe_num());
			pstmt.setString(2, department.getDe_name());
			pstmt.setString(3, department.getDe_address());
			pstmt.setString(4, department.getDe_tel());
			pstmt.setInt(5, department.getDe_pr_num());
			pstmt.setInt(6, searchNum);
			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("[수정 실패]");
			} else {
				System.out.println("[수정 성공]");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close();
		}
	}
	
	public boolean delete(int searchNum) throws SQLException {
		String sql = "delete from department where de_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, searchNum);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close();
		}
		return true;
	}
	
	public Department findByDeNum(int deNum) throws SQLException {
		String sql = "select * from department where de_num = ?";
		Department department = new Department();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deNum);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				department.setDe_num(rs.getInt("de_num"));
				department.setDe_name(rs.getString("de_name"));
				department.setDe_address(rs.getString("de_address"));
				department.setDe_tel(rs.getString("de_tel"));
				department.setDe_pr_num(rs.getInt("de_pr_num"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("해당 학부 번호를 조회 할수가 없습니다.");
		}
		return department;
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
