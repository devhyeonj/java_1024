package assignment.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import assignment.db.domain.Course;
import assignment.db.domain.Department;
import assignment.db.domain.Lecture;
import assignment.db.domain.Professor;
import assignment.db.domain.Score;
import assignment.db.domain.Student;

public class UniversityDB {

	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	

	public UniversityDB() throws SQLException {
		con = getConnection();
		stmt = con.createStatement();
	}
	
	public List<Score> findAllScore() throws SQLException {
		String sql = "select sc_num,sc_mid,sc_final,sc_homework,sc_attendance,sc_total,sc_co_num from score";
		List<Score> scList = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Score score = new Score();
				score.setSc_num(rs.getInt("sc_num"));
				score.setSc_mid(rs.getInt("sc_mid"));
				score.setSc_final(rs.getInt("sc_final"));
				score.setSc_homework(rs.getInt("sc_homework"));
				score.setSc_attendance(rs.getInt("sc_attendance"));
				score.setSc_total(rs.getInt("sc_total"));
				score.setSc_co_num(rs.getInt("sc_co_num"));
				scList.add(score);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return scList;
	}
	
	public void updateScore(Score score, int searchNum) throws SQLException {
		String sql = "update score set sc_mid=?,sc_final=?,sc_homework=?,sc_attendance=?,sc_total=?,sc_co_num=? where sc_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, score.getSc_mid());
			pstmt.setInt(2, score.getSc_final());
			pstmt.setInt(3, score.getSc_homework());
			pstmt.setInt(4, score.getSc_attendance());
			pstmt.setInt(5, score.getSc_total());
			pstmt.setInt(6, score.getSc_co_num());
			pstmt.setInt(7, searchNum);
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
	
	public boolean insertScore(Score score) {
		String sql = "insert into score(sc_mid,sc_final,sc_homework,sc_attendance,sc_total,sc_co_num) values(?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, score.getSc_mid());
			pstmt.setInt(2, score.getSc_final());
			pstmt.setInt(3, score.getSc_homework());
			pstmt.setInt(4, score.getSc_attendance());
			pstmt.setInt(5, score.getSc_total());
			pstmt.setInt(6, score.getSc_co_num());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("[추가 실패]");
				return false;
			}else {
				System.out.println("[추가 성공]");
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				close();
			}
		return true;
		}
	
	
	
	public boolean insertCourse(Course course) {
		String sql = "insert into course(co_st_num,co_le_num,co_type,co_grade) values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, course.getCo_st_num());
			pstmt.setInt(2, course.getCo_le_num());
			pstmt.setString(3, course.getCo_type());
			pstmt.setString(4, course.getCo_grade());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("[추가 실패]");
				return false;
			}else {
				System.out.println("[추가 성공]");
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				close();
			}
		return true;
		}
	public boolean deleteCourse(int searchNum) throws SQLException {
		String sql = "delete from course where co_num = ?";
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
	
	public Course findByCoStNum(int co_st_num) throws SQLException {
		String sql = "select co_num,co_st_num,co_le_num,co_type,co_grade from course where co_st_num = ?";
		Course course = new Course();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, co_st_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				course.setCo_num(rs.getInt("co_num"));
				course.setCo_st_num(rs.getInt("co_st_num"));
				course.setCo_le_num(rs.getInt("co_le_num"));
				course.setCo_type(rs.getString("co_type"));
				course.setCo_grade(rs.getString("co_grade"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("해당 수강신청된 학번을 조회 할수가 없습니다.");
		}
		return course;
	}
	
	public void insertProfessor(Professor professor) {
		String sql = "insert into professor(pr_num,pr_name,pr_state,pr_de_num,pr_tel) values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, professor.getPr_num());
			pstmt.setString(2, professor.getPr_name());
			pstmt.setString(3, professor.getPr_state());
			pstmt.setInt(4, professor.getPr_de_num());
			pstmt.setString(5, professor.getPr_tel());
			int count = pstmt.executeUpdate();
			if(count == 0) {
				System.out.println("[추가 실패]");
			}else {
				System.out.println("[추가 성공]");
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());
			} finally {
				close();
			}
		}
	
	public void updateProfessor(Professor professor, int searchNum) throws SQLException {
		String sql = "update professor set pr_num=?,pr_name=?,pr_state=?,pr_de_num=?,pr_tel=? where pr_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, professor.getPr_num());
			pstmt.setString(2, professor.getPr_name());
			pstmt.setString(3, professor.getPr_state());
			pstmt.setInt(4, professor.getPr_de_num());
			pstmt.setString(5, professor.getPr_tel());
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
	
	public boolean deleteProfessor(int searchNum) throws SQLException {
		String sql = "delete from professor where pr_num = ?";
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
	
	public Professor findByPrNum(int pr_num) throws SQLException {
		String sql = "select pr_num,pr_name,pr_state,pr_de_num,pr_tel from professor where pr_num = ?";
		Professor professor = new Professor();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, pr_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				professor.setPr_num(rs.getInt("pr_num"));
				professor.setPr_name(rs.getString("pr_name"));
				professor.setPr_state(rs.getString("pr_state"));
				professor.setPr_de_num(rs.getInt("pr_de_num"));
				professor.setPr_tel(rs.getString("pr_tel"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("해당 학생을 조회 할수가 없습니다.");
		}
		return professor;
	}
	
	public List<Professor> findAllProfessor() throws SQLException {
		String sql = "select pr_num,pr_name,pr_state,pr_de_num,pr_tel from professor";
		List<Professor> prList = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Professor professor = new Professor();
				professor.setPr_num(rs.getInt("pr_num"));
				professor.setPr_name(rs.getString("pr_name"));
				professor.setPr_state(rs.getString("pr_state"));
				professor.setPr_de_num(rs.getInt("pr_de_num"));
				professor.setPr_tel(rs.getString("pr_tel"));;
				prList.add(professor);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return prList;
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
	
	public void insertStudent(Student student) {
		String sql = "insert into student(st_num,st_name,st_semester,st_state,st_pr_num) values(?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getSt_num());
			pstmt.setString(2, student.getSt_name());
			pstmt.setInt(3, student.getSt_semester());
			pstmt.setString(4, student.getSt_state());
			pstmt.setInt(5, student.getSt_pr_num());
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
	
	public void updateStudent(Student student, int st_num) throws SQLException {
		String sql = "update student set st_num=?,st_name=?,st_semester=?,st_state=?,st_pr_num=? where st_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, student.getSt_num());
			pstmt.setString(2, student.getSt_name());
			pstmt.setInt(3, student.getSt_semester());
			pstmt.setString(4, student.getSt_state());
			pstmt.setInt(5, student.getSt_pr_num());
			pstmt.setInt(6, st_num);
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
	
	
	public boolean deleteStudent(int st_num) throws SQLException {
		String sql = "delete from student where st_num = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, st_num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			close();
		}
		return true;
	}
	
	
	public List<Student> findAllStudent() throws SQLException {
		String sql = "select st_num,st_name,st_semester,st_state,st_pr_num from student";
		List<Student> stList = new ArrayList<>();
		try {
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student();
				student.setSt_num(rs.getInt("st_num"));
				student.setSt_name(rs.getString("st_name"));
				student.setSt_semester(rs.getInt("st_semester"));
				student.setSt_state(rs.getString("st_state"));
				student.setSt_pr_num(rs.getInt("st_pr_num"));
				stList.add(student);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return stList;
	}
	
	public Student findByStNum(int st_num) throws SQLException {
		String sql = "select st_num,st_name,st_semester,st_state,st_pr_num from student where st_num = ?";
		Student student = new Student();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, st_num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				student.setSt_num(rs.getInt("st_num"));
				student.setSt_name(rs.getString("st_name"));
				student.setSt_semester(rs.getInt("st_semester"));
				student.setSt_state(rs.getString("st_state"));
				student.setSt_pr_num(rs.getInt("st_pr_num"));
				student.setSt_num(rs.getInt("st_num"));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (NoSuchElementException e) {
			System.out.println("해당 학생을 조회 할수가 없습니다.");
		}
		return student;
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