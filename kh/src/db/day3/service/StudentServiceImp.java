package db.day3.service;

import java.util.Scanner;

import db.day3.DBConnector;
import db.day3.dao.StudentMapper;
import db.day3.vo.StudentVO;

public class StudentServiceImp implements StudentService {
	
	private StudentMapper studentDao;
	private Scanner sc = new Scanner(System.in);
	
	//공유해서 다른 서비스도 이 dbConnector를 이용 할 수 있게함
	public StudentServiceImp(DBConnector dbConnector) {
		studentDao = new StudentMapper(dbConnector);
	}
	
	public void insertStudent() {
		System.out.println("추가할 학생 정보 입력하세요.");
		System.out.println("학번 :");
		String st_num = sc.nextLine();
		System.out.println("이름 :");
		String st_name = sc.nextLine();
		System.out.println("학기 :");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.println("상태 :");
		String st_state = sc.nextLine();
		System.out.println("지도교수번호 :");
		String st_pr_num = sc.nextLine();
		StudentVO std = new StudentVO(st_num,st_name,st_semester,st_state,st_pr_num);
		studentDao.insertStudent(std);
	}

	public void updateStudent() {
		System.out.println("수정할 학생 정보 입력하세요.");
		System.out.println("학번 :");
		String st_num = sc.nextLine();
		System.out.println("이름 :");
		String st_name = sc.nextLine();
		System.out.println("학기 :");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.println("상태 :");
		String st_state = sc.nextLine();
		System.out.println("지도교수번호 :");
		String st_pr_num = sc.nextLine();
		StudentVO std = new StudentVO(st_num,st_name,st_semester,st_state,st_pr_num);
		studentDao.updateStudent(std);
	}

}
