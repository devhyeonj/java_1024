package example.db.main;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.ibatis.session.SqlSession;

import example.db.main.dao.StudentDAO;
import example.db.main.vo.StudentVO;


public class MainController {

	private SqlSession session;
	private StudentDAO studentDao;
	private Scanner sc = new Scanner(System.in);
	
	
	public MainController(SqlSession session) {
		this.session = session;
		studentDao = session.getMapper(StudentDAO.class);
	}
	
	public void run() {
		int menu = -1;
		final int exit = 4;
		do {
			printMenu();
			menu = sc.nextInt();
			runStudent(menu);
		}while(menu != exit);
		
		
	}

	private void runStudent(int menu) {
		switch (menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			selectAllStudent();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴");
			break;
		}
	}

	private void selectAllStudent() {
		ArrayList<StudentVO> list = studentDao.selectAllStudent();
		System.out.println(list);
		
	}

	private void updateStudent() {
		StudentVO newStd = inputStudent();
		studentDao.updateStudent(newStd);
		session.commit();
	}

	private void insertStudent() {
		StudentVO std = inputStudent();
		studentDao.insertStudent(std);
		session.commit();
	}

	private StudentVO inputStudent() {
		System.out.println("추가할 학생 정보 입력하세요.");
		System.out.println("학번 :");
		int st_num = sc.nextInt();
		sc.nextLine();
		System.out.println("이름 :");
		String st_name = sc.nextLine();
		System.out.println("학기 :");
		int st_semester = sc.nextInt();
		sc.nextLine();
		System.out.println("상태 :");
		String st_state = sc.nextLine();
		System.out.println("지도교수번호 :");
		int st_pr_num = sc.nextInt();
		StudentVO std = new StudentVO(st_num,st_name,st_semester,st_state,st_pr_num);
		return std;
	}

	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 조회");
		System.out.println("4. 프로그램 종료");
	}

}
