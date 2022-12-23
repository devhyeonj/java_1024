package db.day1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StudentMain {
	
	static Scanner sc = new Scanner(System.in);
	static StudentDB stdDB = null;
	static ArrayList<Student1> list = new ArrayList<Student1>();

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost/university";
		String id = "root";
		String pw = "root"; 
		
		try {
			stdDB = new StudentDB(url, id, pw);
		} catch (Exception e) {
			System.out.println("[DB연결 실패]");
			System.out.println("[프로그램 종료]");
			return;
		}
		int menu = -1;
		load();
		do {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			runMenu(menu);
		}while(menu!= 3);
	}

	private static void load() throws SQLException {
		try {
			list = stdDB.selectAllStudent();
		}catch (SQLException e) {
			System.out.println("[로딩 실패]");
		}
	}

	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			printStudentList();
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 메뉴");
		}
	}

	private static void insertStudent() {
		System.out.println("학번 : ");
		String st_num = sc.nextLine();
		System.out.print("이름 : ");
		String st_name = sc.nextLine();
		System.out.print("학기 :");
		int st_semester = sc.nextInt();
		System.out.print("상태(재학/휴학/자퇴/퇴학) :");
		String st_state = sc.nextLine();
		sc.nextLine();
		System.out.print("지도교수 번호 : ");
		String st_pr_num = sc.nextLine();
		try {
			stdDB.insertStudent(st_num,st_name,st_semester,st_state,st_pr_num);
			Student1 std = new Student1(st_num, st_name, st_semester, st_state, st_pr_num);
			list.add(std);
			Collections.sort(list,(o1,o2) -> {
				return o1.getSt_num().compareTo(o2.getSt_num());
			});
		}catch (SQLException e) {
			System.out.println("학생 등록에 실패했습니다.");
		}
	}

	private static void printStudentList() {
		if(list.size() == 0)
			System.out.println("저장된 학생 정보가 없습니다.");
		for (Student1 std : list) {
			System.out.println(std);
		}
	}

	private static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1.학생 등록");
		System.out.println("2. 학생 조회");
		System.out.println("3. 프로그램 종료");
	}

}
