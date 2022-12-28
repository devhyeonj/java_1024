package db.day4.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import db.day4.vo.CourseVO;
import db.day4.vo.StudentVO;

public interface StudentDAO {
	
	ArrayList<StudentVO> selectAllStudent();

	//매개변수가 2개이상인 경우는 파람을 붙여야함
	void insertStudent(@Param("std") StudentVO std);

	void insertCourse(CourseVO co);

}
