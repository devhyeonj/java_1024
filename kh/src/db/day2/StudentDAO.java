package db.day2;

import java.sql.SQLException;
import java.util.ArrayList;
/*
 * 디비 넣어야 하는 작업만 dao 디비에접근 조회 추가 수정..
 * data acess object 
 */
public interface StudentDAO {
	ArrayList<StudentVO1> selectAllStudent() throws SQLException;
	StudentVO1 selectStudentBySt_num(String st_num) throws SQLException;
	boolean insertStudent(StudentVO1 std);
	boolean deleteStudent(String st_num);
	//boolean updateStudent(String st_num, String st_name);
	boolean updateStudent(StudentVO1 std, int submenu);
	
}
