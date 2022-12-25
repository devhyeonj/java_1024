package assignment.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import assignment.db.domain.Department;
import assignment.db.domain.Lecture;

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
	
	public void updateDepartment(Department department, int searchNum) throws SQLException {
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
	
	public boolean deleteDepartment(int searchNum) throws SQLException {
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
	
	public Department findByDeName(String de_name) throws SQLException {
		String sql = "select de_num,de_name,de_address,de_tel,de_pr_num from department where de_name = ?";
		Department department = new Department();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, de_name);
			
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
			System.out.println("해당 학부 명을 조회 할수가 없습니다.");
		}
		return department;
	}
	
	public List<Department> findAllDepartment() throws SQLException {
		String sql = "select de_num,de_name,de_address,de_tel,de_pr_num from department";
		List<Department> deList = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Department department = new Department();
				department.setDe_num(rs.getInt("de_num"));
				department.setDe_name(rs.getString("de_name"));
				department.setDe_address(rs.getString("de_address"));
				department.setDe_tel(rs.getString("de_tel"));
				department.setDe_pr_num(rs.getInt("de_pr_num"));
				deList.add(department);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return deList;
	}
	
	public void insertLecture(Lecture lecture) {
		String sql = "insert into lecture(le_name,le_schedule,le_point,le_class,le_year,le_term,le_pr_num) values(?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lecture.getLe_name());
			pstmt.setString(2, lecture.getLe_schedule());
			pstmt.setInt(3, lecture.getLe_point());
			pstmt.setInt(4, lecture.getLe_class());
			pstmt.setInt(5, lecture.getLe_year());
			pstmt.setString(6, lecture.getLe_term());
			pstmt.setInt(7, lecture.getLe_pr_num());
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
	
	public void updateLecture(Lecture lecture, String le_name) throws SQLException {
		String sql = "update lecture set le_name=?,le_schedule=?,le_point=?,le_class=?,le_year=?,le_term=?,le_pr_num=? where le_name =?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, lecture.getLe_name());
			pstmt.setString(2, lecture.getLe_schedule());
			pstmt.setInt(3, lecture.getLe_point());
			pstmt.setInt(4, lecture.getLe_class());
			pstmt.setInt(5, lecture.getLe_year());
			pstmt.setString(6, lecture.getLe_term());
			pstmt.setInt(7, lecture.getLe_pr_num());
			pstmt.setString(8, le_name);
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
	
	
	public boolean deleteLecture(String searchName) throws SQLException {
		String sql = "delete from lecture where le_name = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, searchName);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close();
		}
		return true;
	}
	
	
	public List<Lecture> findAllLecture() throws SQLException {
		String sql = "select le_num,le_name,le_schedule,le_point,le_class,le_year,le_term,le_pr_num from Lecture";
		List<Lecture> leList = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Lecture lecture = new Lecture();
				lecture.setLe_num(rs.getInt("le_num"));
				lecture.setLe_name(rs.getString("le_name"));
				lecture.setLe_schedule(rs.getString("le_schedule"));
				lecture.setLe_point(rs.getInt("le_point"));
				lecture.setLe_class(rs.getInt("le_class"));
				lecture.setLe_year(rs.getInt("le_year"));
				lecture.setLe_term(rs.getString("le_term"));
				lecture.setLe_pr_num(rs.getInt("le_pr_num"));
				leList.add(lecture);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return leList;
	}
	
	public Lecture findByLeName(String le_name) throws SQLException {
		String sql = "select le_num,le_name,le_schedule,le_point,le_class,le_year,le_term,le_pr_num from Lecture where le_name = ?";
		Lecture lecture = new Lecture();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, le_name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				lecture.setLe_num(rs.getInt("le_num"));
				lecture.setLe_name(rs.getString("le_name"));
				lecture.setLe_schedule(rs.getString("le_schedule"));
				lecture.setLe_point(rs.getInt("le_point"));
				lecture.setLe_class(rs.getInt("le_class"));
				lecture.setLe_year(rs.getInt("le_year"));
				lecture.setLe_term(rs.getString("le_term"));
				lecture.setLe_pr_num(rs.getInt("le_pr_num"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("해당 강좌 명을 조회 할수가 없습니다.");
		}
		return lecture;
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