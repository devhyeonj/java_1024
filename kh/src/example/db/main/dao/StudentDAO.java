package example.db.main.dao;

import java.util.ArrayList;

import example.db.main.vo.StudentVO;

public interface StudentDAO {
	void insertStudent(StudentVO std);
	void updateStudent(StudentVO std);
	ArrayList<StudentVO> selectAllStudent();
}
